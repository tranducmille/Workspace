/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.xtivia.book.portlet.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;
import com.xtivia.book.portlet.exception.EntryEmailException;
import com.xtivia.book.portlet.exception.EntryMessageException;
import com.xtivia.book.portlet.exception.EntryNameException;
import com.xtivia.book.portlet.model.Entry;
import com.xtivia.book.portlet.service.base.EntryLocalServiceBaseImpl;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.xtivia.book.portlet.service.EntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntryLocalServiceBaseImpl
 * @see com.xtivia.book.portlet.service.EntryLocalServiceUtil
 */
@ProviderType
public class EntryLocalServiceImpl extends EntryLocalServiceBaseImpl {
	public List<Entry> getEntries(long groupId, long guestbookId) throws SystemException {

	    return entryPersistence.findByB_G(groupId, guestbookId);
	}

	public List<Entry> getEntries(long groupId, long guestbookId, int start, int end)
	     throws SystemException {

	    return entryPersistence.findByB_G(groupId, guestbookId, start, end);
	}
	
	protected void validate (String name, String email, String entry) 
	        throws PortalException {
	    if (Validator.isNull(name)) {
	        throw new EntryNameException();
	    }
	    if (Validator.isNull(email)) {
	        throw new EntryEmailException();
	    }
	    if (Validator.isNull(entry)) {
	        throw new EntryMessageException();
	    }
	}
	public Entry updateEntry(
	        long userId, long guestbookId, long entryId, String name,
	        String email, String message, ServiceContext serviceContext)
	    throws PortalException, SystemException {

	    long groupId = serviceContext.getScopeGroupId();
	    User user = userPersistence.findByPrimaryKey(userId);
	    Date now = new Date();
	    validate(name, email, message);

	    Entry entry = getEntry(entryId);

	    entry.setUserId(userId);
	    entry.setUserName(user.getFullName());
	    entry.setName(name);
	    entry.setEmail(email);
	    entry.setMessage(message);
	    entry.setModifiedDate(serviceContext.getModifiedDate(now));
	    entry.setExpandoBridgeAttributes(serviceContext);

	    entryPersistence.update(entry);

	    resourceLocalService.updateResources(
	        user.getCompanyId(), groupId, Entry.class.getName(), entryId,
	        serviceContext.getGroupPermissions(),
	        serviceContext.getGuestPermissions());
	    
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId, groupId, entry.getCreatedDate(),
				entry.getModifiedDate(), Entry.class.getName(), entryId, "", 0,
				serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, entry.getMessage(), null, null, null, null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Entry.class);

		indexer.reindex(entry);

	    return entry;
	}
	public Entry addEntry(long userId, long bookId, String name, String email, String message, ServiceContext serviceContext)
	         throws PortalException, SystemException {
	    long groupId = serviceContext.getScopeGroupId();

	    User user = userPersistence.findByPrimaryKey(userId);

	    Date now = new Date();
	    validate(name, email, message);

	    long entryId = counterLocalService.increment();
	    Entry entry = entryPersistence.create(entryId);

	    entry.setUserUuid(serviceContext.getUuid());
	    entry.setUserId(userId);
	    entry.setGroupId(groupId);
	    entry.setCompanyId(user.getCompanyId());
	    entry.setUserName(user.getFullName());
	    entry.setCreatedDate(serviceContext.getCreateDate(now));
	    entry.setModifiedDate(serviceContext.getModifiedDate(now));
	    entry.setExpandoBridgeAttributes(serviceContext);
	    entry.setBookId(bookId);
	    entry.setName(name);
	    entry.setMessage(message);
	    entryPersistence.update(entry);
	    
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, Entry.class.getName(), 
				entryId, false, true, true);

		  AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
                  groupId, entry.getCreatedDate(), entry.getModifiedDate(),
                  Entry.class.getName(), entryId, "", 0,
                  serviceContext.getAssetCategoryIds(),
                  serviceContext.getAssetTagNames(), true, null, null, null,
                  ContentTypes.TEXT_HTML, entry.getMessage(), null, null, null,
                  null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		Indexer<Entry> indexer = IndexerRegistryUtil.nullSafeGetIndexer(Entry.class);

		indexer.reindex(entry);

	    return entry;

	}
	
	public Entry deleteEntry(long entryId, ServiceContext serviceContext) throws PortalException, SystemException {

		Entry entry = getEntry(entryId);
		resourceLocalService.deleteResource(serviceContext.getCompanyId(), Entry.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, entryId);
		
		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(Entry.class.getName(), entryId);

		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
		assetEntryLocalService.deleteEntry(assetEntry);
		Indexer<Entry> indexer = IndexerRegistryUtil.nullSafeGetIndexer(Entry.class);
		indexer.delete(entry);
		
		entry = deleteEntry(entryId);

		return entry;
	}

	@Override
	public Entry addEntry(long userId, long bookId, String name, String message, ServiceContext serviceContext)
			throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

}