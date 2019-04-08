package com.horizon.algorithm.dp;
/**
 * leetcode198. 打家劫舍
 * @author Horizon
 *
 * 2019年4月2日下午5:30:19
 */

import org.junit.Test;

public class LeetCode198 {
	
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0]; dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[n - 1];
    }
	
	@Test
	public void test() {
		int[] arr = {2,1,1,2};
		System.out.println(rob(arr));
	}
	
}
