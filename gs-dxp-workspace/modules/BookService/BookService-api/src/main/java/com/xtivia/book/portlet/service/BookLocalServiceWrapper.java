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

package com.xtivia.book.portlet.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BookLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BookLocalService
 * @generated
 */
@ProviderType
public class BookLocalServiceWrapper implements BookLocalService,
	ServiceWrapper<BookLocalService> {
	public BookLocalServiceWrapper(BookLocalService bookLocalService) {
		_bookLocalService = bookLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _bookLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bookLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _bookLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bookLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bookLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the book to the database. Also notifies the appropriate model listeners.
	*
	* @param book the book
	* @return the book that was added
	*/
	@Override
	public com.xtivia.book.portlet.model.Book addBook(
		com.xtivia.book.portlet.model.Book book) {
		return _bookLocalService.addBook(book);
	}

	@Override
	public com.xtivia.book.portlet.model.Book createBook(
		com.xtivia.book.portlet.model.Book newBook, long userId,
		com.liferay.portal.kernel.service.ServiceContext context)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bookLocalService.createBook(newBook, userId, context);
	}

	/**
	* Creates a new book with the primary key. Does not add the book to the database.
	*
	* @param bookId the primary key for the new book
	* @return the new book
	*/
	@Override
	public com.xtivia.book.portlet.model.Book createBook(long bookId) {
		return _bookLocalService.createBook(bookId);
	}

	/**
	* Deletes the book from the database. Also notifies the appropriate model listeners.
	*
	* @param book the book
	* @return the book that was removed
	*/
	@Override
	public com.xtivia.book.portlet.model.Book deleteBook(
		com.xtivia.book.portlet.model.Book book) {
		return _bookLocalService.deleteBook(book);
	}

	/**
	* Deletes the book with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bookId the primary key of the book
	* @return the book that was removed
	* @throws PortalException if a book with the primary key could not be found
	*/
	@Override
	public com.xtivia.book.portlet.model.Book deleteBook(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bookLocalService.deleteBook(bookId);
	}

	@Override
	public com.xtivia.book.portlet.model.Book deleteBook(long bookId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookLocalService.deleteBook(bookId, serviceContext);
	}

	@Override
	public com.xtivia.book.portlet.model.Book fetchBook(long bookId) {
		return _bookLocalService.fetchBook(bookId);
	}

	/**
	* Returns the book matching the UUID and group.
	*
	* @param uuid the book's UUID
	* @param groupId the primary key of the group
	* @return the matching book, or <code>null</code> if a matching book could not be found
	*/
	@Override
	public com.xtivia.book.portlet.model.Book fetchBookByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _bookLocalService.fetchBookByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the book with the primary key.
	*
	* @param bookId the primary key of the book
	* @return the book
	* @throws PortalException if a book with the primary key could not be found
	*/
	@Override
	public com.xtivia.book.portlet.model.Book getBook(long bookId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bookLocalService.getBook(bookId);
	}

	/**
	* Returns the book matching the UUID and group.
	*
	* @param uuid the book's UUID
	* @param groupId the primary key of the group
	* @return the matching book
	* @throws PortalException if a matching book could not be found
	*/
	@Override
	public com.xtivia.book.portlet.model.Book getBookByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bookLocalService.getBookByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param book the book
	* @return the book that was updated
	*/
	@Override
	public com.xtivia.book.portlet.model.Book updateBook(
		com.xtivia.book.portlet.model.Book book) {
		return _bookLocalService.updateBook(book);
	}

	@Override
	public com.xtivia.book.portlet.model.Book updateBook(long userId,
		long bookId, com.xtivia.book.portlet.model.Book oldBook,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookLocalService.updateBook(userId, bookId, oldBook,
			serviceContext);
	}

	@Override
	public com.xtivia.book.portlet.model.Book updateBook(long userId,
		long bookId, java.lang.String name,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookLocalService.updateBook(userId, bookId, name, serviceContext);
	}

	@Override
	public com.xtivia.book.portlet.model.Book updateStatus(long userId,
		long bookId, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bookLocalService.updateStatus(userId, bookId, status,
			serviceContext);
	}

	/**
	* Returns the number of books.
	*
	* @return the number of books
	*/
	@Override
	public int getBooksCount() {
		return _bookLocalService.getBooksCount();
	}

	@Override
	public int getBooksCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookLocalService.getBooksCount(groupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _bookLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.lang.String getTitle(long primePK, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bookLocalService.getTitle(primePK, locale);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _bookLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.xtivia.book.portlet.model.impl.BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _bookLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.xtivia.book.portlet.model.impl.BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _bookLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.xtivia.book.portlet.model.Book> findAll() {
		return _bookLocalService.findAll();
	}

	@Override
	public java.util.List<com.xtivia.book.portlet.model.Book> findBookByISBN(
		java.lang.String isbn) {
		return _bookLocalService.findBookByISBN(isbn);
	}

	/**
	* Returns a range of all the books.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.xtivia.book.portlet.model.impl.BookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of books
	* @param end the upper bound of the range of books (not inclusive)
	* @return the range of books
	*/
	@Override
	public java.util.List<com.xtivia.book.portlet.model.Book> getBooks(
		int start, int end) {
		return _bookLocalService.getBooks(start, end);
	}

	@Override
	public java.util.List<com.xtivia.book.portlet.model.Book> getBooks(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookLocalService.getBooks(groupId);
	}

	@Override
	public java.util.List<com.xtivia.book.portlet.model.Book> getBooks(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookLocalService.getBooks(groupId, start, end);
	}

	@Override
	public java.util.List<com.xtivia.book.portlet.model.Book> getBooks(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bookLocalService.getBooks(groupId, status);
	}

	/**
	* Returns all the books matching the UUID and company.
	*
	* @param uuid the UUID of the books
	* @param companyId the primary key of the company
	* @return the matching books, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.xtivia.book.portlet.model.Book> getBooksByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _bookLocalService.getBooksByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of books matching the UUID and company.
	*
	* @param uuid the UUID of the books
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of books
	* @param end the upper bound of the range of books (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching books, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.xtivia.book.portlet.model.Book> getBooksByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.xtivia.book.portlet.model.Book> orderByComparator) {
		return _bookLocalService.getBooksByUuidAndCompanyId(uuid, companyId,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _bookLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _bookLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public void createBook(
		java.util.Map<java.lang.String, java.lang.String> map) {
		_bookLocalService.createBook(map);
	}

	@Override
	public void deleteNewBook(com.xtivia.book.portlet.model.Book book)
		throws com.liferay.portal.kernel.exception.PortalException {
		_bookLocalService.deleteNewBook(book);
	}

	@Override
	public BookLocalService getWrappedService() {
		return _bookLocalService;
	}

	@Override
	public void setWrappedService(BookLocalService bookLocalService) {
		_bookLocalService = bookLocalService;
	}

	private BookLocalService _bookLocalService;
}