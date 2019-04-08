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
}
