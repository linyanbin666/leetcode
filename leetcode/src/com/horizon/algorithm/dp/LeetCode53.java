package com.horizon.algorithm.dp;

import org.junit.Test;

/**
 * leetcode53. 最大序列和，动态规划求法，时间复杂度O(n)
 * 
 * @author Horizon
 *
 *         2019年4月2日下午4:13:17
 */
public class LeetCode53 {
	
	public int maxSubArray(int[] nums) {
		int max = nums[0];
		int tempMax = nums[0];
		for (int i = 1; i < nums.length; i++) {
			tempMax = tempMax < 0 ? nums[i] : tempMax + nums[i];
			if (max < tempMax) {
				max = tempMax;
			}
		}
		return max;
	}
	
	@Test
	public void test() {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
}
