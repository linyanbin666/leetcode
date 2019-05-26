package com.horizon.string;

import org.junit.Test;

/**
 * leetcode5. title: 最长回文子串 level: medium
 * 
 * @author Horizon
 *
 * @Date 2019年5月10日上午9:26:12
 */
public class LeetCode5 {
	
	/*public String longestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return s;
		String t = new StringBuffer(s).reverse().toString();
		// dp[i][j]记录具有这样特点的子串长度 ---子串的结尾同时也为串s[0]...s[i]与串t[0]...t[j]的结尾
		int[][] dp = new int[s.length() + 1][t.length() + 1];
		// 记录最长公共子串长度
		int max = 0, index = 0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				// s[i-1] == s[j-1] --> dp[i][j] = dp[i-1][j-1] + 1
				// s[i-1] != s[j-1] --> dp[i][j] = 0
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if (max < dp[i][j]) {
						max = dp[i][j];
						index = i;
					}
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return s.substring(index - max, index);
	}*/

	// 暴力解法，时间复杂度为O(n^3)
	public String longestPalindrome1(String s) {
		if (s == null || s.length() == 0)
			return s;
		int len = s.length();
		String max = s.charAt(0) + "";
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				String subStr = s.substring(i, j + 1);
				String revSubStr = new StringBuilder(subStr).reverse().toString();
				if (subStr.equals(revSubStr) && max.length() < subStr.length()) {
					max = subStr;
				}
			}
		}
		return max;
	}
	
	/**
	 * 动态规划：
	 *	f(i, j) = true, 如果Si...Sj是回文子串
	 *	        = false, 其他情况
	 *	则：
	 *	f(i, j) = f(i + 1, j + 1) (Si == Sj)
	 *	        = true (i == j || (j = i + 1, Si == Sj))
	 */
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return s;
		char[] chars = s.toCharArray();
		int startIndex = 0, maxLen = 1;
		boolean dp[][] = new boolean[s.length()][s.length()];
		// 初始化 dp[i][i] = true; dp[i][i+1] = true(s[i] == [i+1])
		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = true;
			if (i < s.length() - 1 && chars[i] == chars[i + 1]) {
				dp[i][i + 1] = true;
				startIndex = i;
				maxLen = 2;
			}
		}
		// len表示子串长度
		for (int len = 3; len <= s.length(); len++) {
			// start表示子串的起始点,end表示子串的终点
			for (int start = 0, end = start + len - 1; end < s.length(); start++, end++) {
				// dp[i][j] = dp[i+1][j-1];(s[i] == s[j])
				if (chars[start] == chars[end] && dp[start + 1][end - 1]) {
					dp[start][end] = true;
					startIndex = start;
					maxLen = len;
				} 
			}
		}
		return s.substring(startIndex, startIndex + maxLen);
	}
	
	// 中心扩展法
	public String longestPalindrome3(String s) {
		if (s == null || s.length() == 0)
			return s;
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			// 奇数回文串
			int len1 = expandAroundCenter(s, i, i);
			// 偶数回文串
			int len2 = expandAroundCenter(s, i, i + 1);
			// 求最大回文串长度
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}
	
	private int expandAroundCenter(String s, int left, int right) {
		int l = left, r = right;
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		// 返回回文串的长度
		return r - l - 1;
	}
	
	// Manacher算法实现
	public String longestPalindrome4(String s) {
		// 先预处理字符串
		String str = preHandleString(s);
		// 处理后字符串的长度
		int len = str.length();
		// 右边界与右边界对应的回文中心
		int rb = 0, rbCenter = 0; 
		// 记录最长回文子串的中心和半长度
		int longestCenter = 0, longestHalf = 0;
		// 保存以每个字符为中心的回文长度的一半（向下取整）
		int[] halfLenArr = new int[len];
		
		for (int i = 0; i < len; i++) {
			// 记录是否需要进行中心扩展
			boolean needExpand = true;
			// 如果在右边界的范围内
			if (i < rb) {
				// 计算相对右边界的回文中心rbCenter对称的位置
				// (i - rbCenter == rbCenter - leftCenter)
				int leftCenter = 2 * rbCenter - i;
				// 如果小于右边界，直接得出结论
				if (i + halfLenArr[leftCenter] < rb) {
					halfLenArr[i] = halfLenArr[leftCenter];
					needExpand = false;
				} else {
					// 如果大于或等于右边界
					halfLenArr[i] = rb - i;
				} 
			} 
			// 进行中心扩展
			if (needExpand) {
				int start = i - halfLenArr[i] - 1;
				int end = i + halfLenArr[i] + 1;
				while (start >= 0 && end < len) {
					// 如果两侧不相等则直接返回
					if (str.charAt(start) != str.charAt(end))
						break;
					// 否则增加长度
					halfLenArr[i]++;
					start--; end++;
				}
				// 更新右边界和中心
				rb = i + halfLenArr[i];
				rbCenter = i;
				// 记录最长回文串长度
				if (halfLenArr[i] > longestHalf) {
					longestHalf = halfLenArr[i];
					longestCenter = i;
				}
			}
		}
		// 去掉之前添加的特殊字符#
		StringBuilder sb = new StringBuilder();
		for (int i = longestCenter - longestHalf + 1; i <= longestCenter + longestHalf; i += 2) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	
	// 对字符串进行预处理，首尾和字符间加入特殊字符，以消除中心扩展需判断奇偶中心的问题
	private String preHandleString(String s) {
		StringBuilder sb = new StringBuilder();
		sb.append("#");
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i)).append("#");
		}
		return sb.toString();
	}
	
	@Test
	public void test() {
		String s = "babad";
		System.out.println(longestPalindrome1(s));
		System.out.println(longestPalindrome(s));
		System.out.println(longestPalindrome3(s));
		System.out.println(longestPalindrome4(s));
	}
	
}
