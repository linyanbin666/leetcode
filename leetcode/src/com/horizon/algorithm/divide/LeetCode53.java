package com.horizon.algorithm.divide;
/**
 * leetcode53. 最大序列和，分治求法，时间复杂度O(nlogn)
 * @author Horizon
 *
 * 2019年4月2日下午4:44:08
 */

import org.junit.Test;

public class LeetCode53 {
	
	public int maxSubArray(int[] nums) {
		return maxSubArray(nums, 0, nums.length - 1);
	}
	// 分治解法
	public int maxSubArray(int[] nums, int low, int high) {
		if (low >= high) {
			return nums[low];
		}
		int mid = low + ((high - low) >> 1);
		int leftMax = maxSubArray(nums, low, mid);
		int rightMax = maxSubArray(nums, mid + 1, high);

		int leftBonderMax = nums[mid], sum = nums[mid];
		// 求左半部分的最大子序列和，必须逆序遍历，才能包括左半部分的最后一个元素
		for (int i = mid - 1; i >= low; i--) {
			sum += nums[i];
			leftBonderMax = leftBonderMax < sum ? sum : leftBonderMax;
		}
		int rightBonderMax = nums[mid + 1];
		sum = nums[mid + 1];
		// 求右半部分的最大子序列和
		for (int i = mid + 2; i <= high; i++) {
			sum += nums[i];
			rightBonderMax = rightBonderMax < sum ? sum : rightBonderMax;
		}
		
		return Math.max(leftBonderMax + rightBonderMax, Math.max(leftMax, rightMax));
	}
	
	@Test
	public void test() {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
}
