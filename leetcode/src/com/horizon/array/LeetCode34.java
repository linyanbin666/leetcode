package com.horizon.array;

/**
 * leetcode34. 
 * title: 在排序数组中查找元素的第一个和最后一个位置 
 * level: medium
 * 
 * @author Horizon
 *
 * @Date 2019年5月2日下午10:40:42
 */
public class LeetCode34 {

	public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0)
            return res;
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }
    
    // 二分查找找到第一个相等的位置
    private int findFirst(int[] nums, int target) {
        int low = 0, high = nums.length - 1; 
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                if (mid == 0 || nums[mid - 1] != target)
                    return mid;
                high = mid - 1;
            }
        }
        return -1;
    }
    
    // 二分查找找到最后一个相等的位置
    private int findLast(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] != target)
                    return mid;
                low = mid + 1;
            }
        }
        return -1;        
    }
}
