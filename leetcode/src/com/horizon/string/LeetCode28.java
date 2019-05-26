package com.horizon.string;

/**
 * leetcode28. title: 实现strStr() level: easy
 * 
 * @author Horizon
 *
 * @Date 2019年5月23日下午11:58:49
 */
public class LeetCode28 {
	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return -1;
		if ("".equals(needle))
			return 0;
		// 原串长度和目标串长度
		int sourceLen = haystack.length(), targetLen = needle.length();
		// 原串起始下标和目标串起始下标
		int sourceOffest = 0, targetOffest = 0;
		// 获取目标串第一个字符
		char first = needle.charAt(targetOffest);
		// 计算原串最大查找下标
		int max = sourceLen - targetLen;
		for (int i = sourceOffest; i <= max; i++) {
			// 找到原串字符中与目标串第一个字符相等的下标
			if (haystack.charAt(i) != first) {
				while (++i <= max && haystack.charAt(i) != first)
					;
			}
			// 如果下标还未到达最大值，说明可能存在相等的目标串
			if (i <= max) {
				// 匹配后续的字符串看是否相等
				int start = i + 1, end = start + targetLen - 1;
				for (int k = targetOffest + 1; start < end; k++, start++) {
					if (haystack.charAt(start) != needle.charAt(k))
						break;
				}
				// 匹配到最后，说明匹配成功了
				if (start == end) {
					return i - sourceOffest;
				}
			}
		}
		return -1;
	}
}
