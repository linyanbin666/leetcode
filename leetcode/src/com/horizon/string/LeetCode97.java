package com.horizon.string;

import org.junit.Test;

/**
 * leetCode97.
 * title: 交错字符串
 * level: hard
 * @author Horizon
 *
 * @Date 2019年5月26日下午11:38:44
 */
public class LeetCode97 {

	/**
	 * 动态规划求解：
	 *     dp[i][j]表示s1[0~i-1]和s2[0~j-1]能否交错成s3[0~i+j-1]
	 * 转移方程：
	 *     dp[i][j] = true (i==j==0)
	 *              = dp[i-1][0] && s1[i-1]==s3[i-1] (j==0)
	 *              = dp[0][j-1] && s2[j-1]==s3[j-1] (i==0)
	 *              = (dp[i-1][j] && s1[i-1]==s3[i+j-1]) || (dp[i][j-1] && s2[j-1]==s3[i+j-1]) 
	 *                (1 <= i <= n && 1 <= j <= m) 
	 */
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length())
			return false;
		int n = s1.length(), m = s2.length();
		boolean[][] dp = new boolean[n + 1][m + 1];
		dp[0][0] = true;
		for (int i = 1; i <= n; i++) {
			dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1)); 
		}
		for (int j = 1; j <= m; j++) {
			dp[0][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1)); 
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = (dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)))
						|| (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)));
			}
		}
		return dp[n][m];
	}
	
	@Test
	public void test() {
		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
		System.out.println(isInterleave(s1, s2, s3));
	}
	
}
