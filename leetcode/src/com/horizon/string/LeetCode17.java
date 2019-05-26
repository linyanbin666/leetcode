package com.horizon.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * leetcode17.
 * title: 电话
 * level: medium
 * @author Horizon
 *
 * @Date 2019年5月24日下午11:23:08
 */
public class LeetCode17 {
	
	Map<Integer, String> map = new HashMap<>();
	
	{
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
	}
	
	// 递归实现
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits == null || digits.length() == 0)
			return res;
		letterCombinationsCore(digits, 0, "", res);
		return res;
	}

	private void letterCombinationsCore(String digits, int i, String temp, List<String> res) {
		if (i == digits.length()) {
			res.add(temp);
			return;
		}
		Integer key = digits.charAt(i) - '0';
		String s = map.get(key);
		for (int j = 0; j < s.length(); j++) {
			letterCombinationsCore(digits, i + 1, temp + s.charAt(j), res);
		}
	}
	
	@Test
	public void test() {
		String digits = "23";
		System.out.println(letterCombinations(digits));;
	}
}
