package com.horizon.array;

import java.util.Arrays;

/**
 * leetcode31.
 * title: 下一个排列
 * level: medium
 * @author Horizon
 *
 * @Date 2019年5月1日下午8:44:02
 */
public class LeetCode31 {
	
	public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int idx = nums.length - 1;
        while (idx - 1 >= 0 && nums[idx - 1] > nums[idx])
            idx--;
        // 降序
        if (idx == 0) {
            Arrays.sort(nums);
            return;
        }
        int j = idx + 1, temp = idx;
        while (j < nums.length - 1 && nums[idx - 1] < nums[j] && nums[temp] > nums[j]) {
            temp = j;
            j++;
        }
        swap(nums, temp, idx - 1);
        for (int i = 0; i < nums.length; i++) {
            swap(nums, i + idx, nums.length - i - 1);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        if (i == j)
            return;
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
	
}
