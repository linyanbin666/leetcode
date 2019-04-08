package com.horizon.algorithm.sort;

import java.util.LinkedList;
import java.util.List;

/**
 * leetcode315. 计算右侧小于当前元素的个数，采用二分插入排序计算
 * 
 * @author Horizon
 *
 *         2019年3月31日下午8:16:28
 */
public class LeetCode315 {
	
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new LinkedList<>();
		if (nums == null)
			return res;
		binaryInsertSort(nums, res);
		return res;
	}

	private void binaryInsertSort(int[] nums, List<Integer> res) {
		int j = 1, n = nums.length;
		while (j < n) {
			
		}
	}
	
}
