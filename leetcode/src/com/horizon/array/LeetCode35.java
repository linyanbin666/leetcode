package com.horizon.array;
/**
 * leetcode35.
 * title: 搜索插入位置
 * level: easy
 * @author Horizon
 *
 * @Date 2019年5月2日下午11:05:06
 */
public class LeetCode35 {

	public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        int low = 0, high = nums.length - 1, res = -1;
        // 二分查找最后一个小于等于target的位置
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    res = mid;
                    break;
                }
                low = mid + 1;          
            }
        }
        if (res >= 0 && nums[res] == target) {
            return res;
        }
        return res + 1;
    }
}
