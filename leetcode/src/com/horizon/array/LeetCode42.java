package com.horizon.array;
/**
 * leetcode42.
 * title: 接雨水
 * level: hard
 * @author Horizon
 *
 * @Date 2019年5月6日上午8:59:45
 */
public class LeetCode42 {

	public int trap(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		// 找到最高点的下标
		int max = Integer.MIN_VALUE, maxIndex = 0;
		for (int i = 0; i < height.length; i++) {
			if (height[i] > max) {
				max = height[i];
				maxIndex = i;
			}
		}
		// 从两边遍历计算雨水总量
		int curr = 0, area = 0;
		max = height[curr++];
		while (curr < maxIndex) {
			//  如果当前的高度比左边最高的大，则不用计算雨水，反之则需要
			if (max < height[curr]) {
				max = height[curr];
			} else {
				area += max - height[curr];
			}
			curr++;
		}
		curr = height.length - 1;
		max = height[curr--];
		while (curr > maxIndex) {
			if (max < height[curr]) {
				max = height[curr];
			} else {
				area += max - height[curr];
			}
			curr--;
		}
		return area;
	}
	
}
