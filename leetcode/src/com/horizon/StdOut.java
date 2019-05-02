package com.horizon;

import java.util.Collection;
import java.util.Iterator;

public class StdOut {

	public static void printListOrSet(Collection<?> collection) {
		Iterator<?> iterator = collection.iterator();
		while(iterator.hasNext()) {
			Object obj = iterator.next();
			if (iterator.hasNext()) {
				System.out.print(obj + ",");
			} else {
				System.out.print(obj);
			}
		}
	}
	
	public static <T> void printArray(T[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				System.out.print(array[i]);
			} else {
				System.out.print(array[i] + ",");
			}
		}
	}
}
