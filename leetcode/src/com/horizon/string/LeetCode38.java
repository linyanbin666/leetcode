package com.horizon.string;

import org.junit.Test;

/**
 * leetcode38.
 * title: 报数
 * level: easy
 * @author Horizon
 *
 * @Date 2019年5月24日下午10:45:15
 */
public class LeetCode38 {

	public String countAndSay(int n) {
		String s = "1";
		for (int i = 2; i <= n; i++) {
			StringBuilder sb = new StringBuilder();
			int count = 1;
			char pre = s.charAt(0);
			for (int j = 1; j < s.length(); j++) {
				char ch = s.charAt(j);
				if (pre == ch) {
					count++;
				} else {
					// 几个几
					sb.append(count).append(pre);
					pre = ch;
					count = 1;
				}
			}
			sb.append(count).append(pre);
			s = sb.toString();
		}
		return s;
	}
	
	// 递归代码
	public String countAndSay1(int n) {
		if (n == 1) {
			return "1";
		} else {
			String retStr = countAndSay1(n - 1);
			int count = 1;
			String res = "";
			for (int i = 0; i < retStr.length(); i++) {
				while (i < retStr.length() - 1 && retStr.charAt(i) == retStr.charAt(i + 1)) {
					count++;
					i++;
				}
				res += "" + count + retStr.charAt(i);
				count = 1;
			}
			return res;
		}
	}
	
	@Test
	public void test() {
		System.out.println(countAndSay(5));
	}
	
}
