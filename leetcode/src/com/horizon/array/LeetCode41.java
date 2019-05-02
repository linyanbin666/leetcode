package com.horizon.array;

/**
 * leetcode41.
 * title: 缺失的第一个正数
 * level: difficulty
 * @author Horizon
 * 2019年4月8日下午4:56:51
 */
public class LeetCode41 {

	public int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0) 
			return 1;
		int n = nums.length;
		// 思考：排序 --> 时间复杂度O(n)的排序 --> 桶排序 --> 空间复杂度需要O(m) --> 基于交换的空间复杂度O(1)的原地散列
		for (int i = 0; i < n; i++) {
			// 将大于0的数存放到以该数为下标-1的位置
			while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
				// 交换
				swap(nums, i, nums[i] - 1);
			}
		}
		for (int i = 0; i < n; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return n + 1;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
}
