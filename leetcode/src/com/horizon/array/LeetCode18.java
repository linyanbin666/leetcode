package com.horizon.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode18.
 * title: 四数之和
 * level: medium
 * @author Horizon
 *
 * @Date 2019年4月18日下午11:26:20
 */
public class LeetCode18 {
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length < 4) 
			return res;
		if (nums.length == 4) {
			if (nums[0] + nums[1] + nums[2] + nums[3] == target) {
				res.add(Arrays.asList(nums[0] , nums[1] , nums[2] , nums[3]));
			} 
			return res;
		}
		for (int i = 0; i < nums.length - 3; i++) {
			// 如果头4个数之和大于目标值，直接退出循环
			if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) 
				break;
			// 如果后三个数和等i个数之和小于目标值，则循环下一个i值
			if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target)
				continue;
			// 过滤重复
			if (i > 0 && nums[i - 1] == nums[i])
				continue;
			for (int j = i + 1; j < nums.length - 2; j++) {
				if(nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) 
					break;  
                if(nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target)
                	continue;
				if (j > i + 1 && nums[j - 1] == nums[j])
					continue;
				// 将问题转换为三数之和为0
				int newTarget = target - nums[i] - nums[j];
				int left = j + 1, right = nums.length - 1;
				while (left < right) {
					if (nums[left] + nums[right] == newTarget) {
						res.add(Arrays.asList(nums[i] , nums[j] , nums[left] , nums[right]));
						while (left < right && nums[left + 1] == nums[left])
							left++;
						while (left < right && nums[right - 1] == nums[right])
							right--;
						left++;
						right--;
					} else if (nums[left] + nums[right] < newTarget) {
						left++;
					} else {
						right--;
					}
				}
			}
		}
		return res;
	}
}
