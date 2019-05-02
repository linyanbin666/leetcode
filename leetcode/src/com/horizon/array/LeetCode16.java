package com.horizon.array;

import java.util.Arrays;

import org.junit.Test;

/**
 * leetcode16. 
 * title: 最接近的三数之和
 * level: medium
 * @author Horizon
 *
 * @Date 2019年4月18日下午10:40:26
 */
public class LeetCode16 {
	
	public int threeSumClosest(int[] nums, int target) {
		// 从小到大排序
		Arrays.sort(nums);
		int res = -1, min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (Math.abs(target - sum) < min) {
					min = Math.abs(target - sum);
					res = sum;
				}
				if (sum > target) {
					right--;
				} else if (sum < target) {
					left++;
				} else {
					return sum;
				}
			}
		}
		return res;
	}
	
	@Test
	public void test() {
		int[] nums = {-1,2,1,-4};
		int target = 1;
		System.out.println(threeSumClosest(nums, target));
	}
}
