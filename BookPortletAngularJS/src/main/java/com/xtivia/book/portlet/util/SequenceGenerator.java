package com.xtivia.book.portlet.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author created by dtran
 * An utility class
 */
public class SequenceGenerator {

	private AtomicInteger atomicInteger;
	private static SequenceGenerator obj = null;

	private SequenceGenerator(int initialValue){
	        this.atomicInteger = new AtomicInteger(initialValue); 
	    }

	/**
	 * Singleton method
	 * @return SequenceGenerator instance
	 */
	public static SequenceGenerator getInstance() {
		if (obj == null) {
			obj = new SequenceGenerator(1);
		}
		return obj;
	}

	public int getSequence() {
		return atomicInteger.getAndIncrement();
	}
}
