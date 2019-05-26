package com.horizon.string;

import java.util.HashMap;

import org.junit.Test;

/**
 * 无重复字符的最长子串
 * @author Horizon
 *
 * @Date 2019年5月9日上午8:54:29
 */
public class LeetCode3 {

	/*// 思路不清晰的写法
	public int lengthOfLongestSubstring(String s) {
		if (s == null || "".equals(s)) 
			return 0;
		// 保存字符最后一次出现的位置
		int[] last = new int[128];
		for (int i = 0; i < last.length; i++) {
			last[i] = -1;
		}
		// 保存以当前字符结尾的子串长度
		int[] arr = new int[s.length()];
		arr[0] = 1; last[s.charAt(0)] = 0;
		int max = 1;
		for (int i = 1; i < s.length(); i++) {
			int index = s.charAt(i);
			// 该字符已经出现过了
			if (last[index] != -1) {
				arr[i] = Math.min(i - last[index], arr[i - 1] + 1);
			} else {
				// 如果当前字符与前一个字符相等则长度置为1
				arr[i] = arr[i] != arr[i - 1] ? arr[i - 1] + 1 : 1;
			}
			// 保留字符最后一次出现的位置
			last[index] = i;
			max = Math.max(max, arr[i]);
		}
		return max;
	}*/
/*
	// 利用滑动窗口求解
	public int lengthOfLongestSubstring(String s) {
		int n = s.length(), i = 0, j = 0, res = 0;
		Set<Character> set = new HashSet<>();
		while (i < n && j < n) {
			// 如果当前字符未出现则加入窗口中
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				res = Math.max(res, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return res;
	}*/
	
	// 利用优化后的滑动窗口求解
	public int lengthOfLongestSubstring(String s) {
		int n = s.length(), i = 0, j = 0, res = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		while (i < n && j < n) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			res = Math.max(res, j - i + 1);
			map.put(s.charAt(j), ++j);
		}
		return res;
	}
	
	@Test
	public void test() {
		System.out.println(lengthOfLongestSubstring("abba"));
	}
}
