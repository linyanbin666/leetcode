package com.horizon.array;
/**
 * leetcode33.
 * title: 搜索旋转排序数组
 * level: medium
 * @author Horizon
 *
 * @Date 2019年5月2日下午10:11:15
 */
public class LeetCode33 {
	
	// 多举测试用例才能做全
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            // 相等
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) { 
                if (target == nums[high])
                    return high;
                // 如果中间值大于最后一个值且target小于最后一个值，则说明数组存在旋转，大数组的在前，小数组的在后
                if (nums[mid] > nums[high] && target < nums[high]) 
                    low = mid + 1;
                else
                    high = mid - 1; 
            } else {
                if (target == nums[low])
                    return low;
                // 如果中间值大于最后一个值且target大于第一个值，则说明数组存在旋转，小数组的在前，大数组的在后
                if (nums[mid] < nums[low] && target > nums[low])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }
    
}
