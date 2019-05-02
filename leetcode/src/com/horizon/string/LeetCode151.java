package com.horizon.string;

import org.junit.Test;

/**
 * leetcode151.
 * title: 翻转字符串里的单词
 * level: medium
 * @author Horizon
 *
 * @Date 2019年4月11日下午10:33:01
 */
public class LeetCode151 {
	
	/*public String reverseWords(String s) {
		if (s == null)
			return s;
		if (s.trim().length() == 0)
			return s.trim();
		StringBuilder sb = new StringBuilder(s);
		String[] arr = sb.reverse().toString().trim().split("\\s+");
//		System.out.println(Arrays.toString(arr));
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				builder.append(reverseString(arr[i].trim().toCharArray()));
			} else {
				builder.append(reverseString(arr[i].trim().toCharArray())).append(" ");
			}
		}
		return builder.toString();
	}
	
	public String reverseString(char[] s) {
		if (s == null || s.length == 0)
			return new String(s);
		int n = s.length;
		for (int i = 0; i < n / 2; i++) {
			swap(s, i, n - i - 1);
		}
		return String.valueOf(s);
	}

	private void swap(char[] s, int i, int j) {
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}*/
	
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		int high = s.length() - 1, low;
		while (high >= 0) {
			// 找到单词的最后一个字母
			while (high >= 0 && s.charAt(high) == ' ')
				high--;
			low = high;
			// 找到单词的第一个字母（low为第一个字母前的空格下标或-1）
			while (low >= 0 && s.charAt(low) != ' ')
				low--;
			// 截取单词
			sb.append(s.substring(low + 1, high + 1)).append(" ");
			high = low;
		}
		// 判断空串("")或空格字符串(如" "等)的情况
		return s.trim().length() != 0 ? 
				sb.toString().trim() : s.trim();
	}
	
	@Test
	public void test() {
		System.out.println(reverseWords("  hello world!  "));
	}
}
