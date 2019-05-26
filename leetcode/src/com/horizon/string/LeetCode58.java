package com.horizon.string;

/**
 * leetcode58.
 * title: 最后一个	单词的长度
 * level: easy
 * @author Horizon
 *
 * @Date 2019年5月26日下午11:23:27
 */
public class LeetCode58 {
	 public int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int n = s.length() - 1;
		// 后面可能有空格，一小坑
		while (n >= 0 && s.charAt(n) == ' ')
			n--;
		int i = n;
		while (i >= 0 && s.charAt(i) != ' ')
			i--;
		return n - i;
	}
}
