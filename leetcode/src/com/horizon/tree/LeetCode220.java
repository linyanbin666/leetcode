package com.horizon.tree;

import java.util.TreeSet;

import org.junit.Test;
/**
 * leetcode220. 存在重复元素 III
 * @author Horizon
 *
 * 2019年3月26日下午10:11:33
 */
public class LeetCode220 {
	
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 返回集合中大于等于给定元素的最小元素
            Integer ele = set.ceiling(nums[i]);
            // 如果ele存在，并且与当前数的差值小于等于t
            if (ele != null && ele - nums[i] <= t) {
                return true;
            }
            // 返回集合中小于等于给定元素的最大元素
            ele = set.floor(nums[i]);
            if (ele != null && nums[i] - ele <= t) {
                return true;
            }
            // 将当前元素加入集合，同时控制滑动窗口大小最大为k
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }          
        }
        return false;
    }
    
    @Test
    public void test() {
    	int[] arr = {1,2,3,1};
    	int t = 0, k = 3;
    	System.out.println(containsNearbyAlmostDuplicate(arr, k, t));
    }
}