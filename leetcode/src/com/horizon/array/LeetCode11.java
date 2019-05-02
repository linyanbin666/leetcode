package com.horizon.array;
/**
 * leetcode11.
 * title: 盛最多水的容器
 * level: medium
 * @author Horizon
 *
 * @Date 2019年4月8日下午10:19:57
 */

import org.junit.Test;

public class LeetCode11 {
	
	public int maxArea(int[] height) {
		int low = 0, high = height.length - 1, max = Integer.MIN_VALUE, volume;
		while (low < high) {
			// 计算容量
			volume = (high - low) * (height[high] > height[low] ? height[low] : height[high]);
			// 保存最大值
			if (max < volume)
				max = volume;
			// 移动高度较低的指针，那样容量才可能比原来的大
			if (height[high] > height[low])
				low++;
			else 
				high--;
		}
		return max;
    }
	
	@Test
	public void test() {
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
	}
	
}
