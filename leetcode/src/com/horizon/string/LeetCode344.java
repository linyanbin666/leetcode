package com.horizon.string;
/**
 * leetcode344.
 * title: 反转字符串
 * level: simple
 * @author Horizon
 *
 * @Date 2019年4月11日下午10:27:32
 */
public class LeetCode344 {
	public void reverseString(char[] s) {
		if (s == null || s.length == 0)
			return;
		int n = s.length;
		for (int i = 0; i < n / 2; i++) {
			swap(s, i, n - i - 1);
		}
	}

	private void swap(char[] s, int i, int j) {
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}
}
