package com.horizon.string;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode6. title: Z字形变换 level: medium
 * 
 * @author Horizon
 *
 * @Date 2019年5月22日下午11:05:14
 */
public class LeetCode6 {
	
	// 按行读取
	public String convert2(String s, int numRows) {
		if (s == null || numRows < 2)
			return s;
		List<StringBuilder> list = new ArrayList<>();
		for (int i = 0; i < Math.min(s.length(), numRows); i++) {
			list.add(new StringBuilder());
		}
		
		int curRow = 0;
		boolean isDown = false;
		for (int i = 0; i < s.length(); i++) {
			list.get(curRow).append(s.charAt(i));
			if (curRow == 0 || curRow == numRows - 1) {
				isDown = !isDown;
			}
			curRow += isDown ? 1 : -1;
		}
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			res.append(list.get(i).toString());
		}
		return res.toString();
	}
	
	
	// 找规律，字符下标为i，下一个字符为2 * numRows - 2 - i
	public String convert(String s, int numRows) {
		if (s == null || numRows < 2)
			return s;
		int len = s.length();
		StringBuilder sb = new StringBuilder();
		int step = 2 * numRows - 2;
		
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j + i < len; j += step) {
				sb.append(s.charAt(j + i));
				// 如果不是首行或最后一行，内部行有两个字符
				if (i != 0 && i != numRows - 1 && j + step - i < len) {
					sb.append(s.charAt(j + step - i));
				}
			}
		}
		return sb.toString();
	}
	
	
}
