package com.xtivia.portlet.book.util;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * @author created by dtran
 * A library to generate sequence of number
 */
public class SequenceGenerator {

	private AtomicInteger atomicInteger;
	private static SequenceGenerator obj = null;

	private SequenceGenerator(int initialValue){
	        this.atomicInteger = new AtomicInteger(initialValue); 
	    }

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
