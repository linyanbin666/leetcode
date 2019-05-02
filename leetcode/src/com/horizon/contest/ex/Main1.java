package com.horizon.contest.ex;

import org.junit.Test;

public class Main1 {

	public int main(String source, String target) {
		char[] t = target.toCharArray();
		int[] index = new int[t.length];
		int count = -1;
		for (int i = 0; i < t.length; i++) {
			int j = source.indexOf(t[i]);
			if (j == -1) {
				return -1;
			} 
			index[i] = j;
			if (i == 0) {
				count = 1;
			}
			if (i > 0 && index[i] < index[i - 1]) {
				count++;
			}
		}
		return count;
	}
	
	@Test
	public void test() {
		String source = "abc", target = "abcbc";
		System.out.println(main(source, target));
	}
}
