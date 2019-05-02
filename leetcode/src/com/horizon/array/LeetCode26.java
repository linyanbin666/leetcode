package com.horizon.array;

import org.junit.Test;

/**
 * leetcode26. 
 * title: 删除排序数组中的重复项 
 * level: simple
 * @author Horizon
 *
 * @Date 2019年4月8日下午9:15:34
 */
public class LeetCode26 {
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 1) {
			return nums.length;
		}
		int index = 1, temp = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (temp == nums[i]) {
				continue;
			} else {
				temp = nums[i];
				nums[index++] = nums[i];
			}
		}
		return index;
	}

	@Test
	public void test() {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		System.out.println(removeDuplicates(nums));
	}
}
