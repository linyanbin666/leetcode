package com.horizon.array;
/**
 * leetcode4.
 * title: 寻找两个有序数组的中位数
 * level: difficulty
 * @author Horizon
 *
 * @Date 2019年4月8日下午10:39:26
 */

import org.junit.Test;

public class LeetCode4 {
	// 以空间换时间，将两个有序数组合并，再输出新数组的中位数，时间复杂度为O(m+n)，不符合题目要求的O(log(m+n))
	/*public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n = nums1.length, m = nums2.length;
		int[] arr = new int[n + m];
		int index = 0, i = 0, j = 0;
		// 合并两个有序数组
		while (i < n && j < m) {
			if (nums1[i] < nums2[j]) {
				arr[index++] = nums1[i++];
			} else {
				arr[index++] = nums2[j++];
			}
		}
		while (i < n) {
			arr[index++] = nums1[i++];
		}
		while (j < m) {
			arr[index++] = nums2[j++];
		}
		int mid = index / 2;
		return (index & 1) == 1 ? arr[mid] * 1.0 : (arr[mid] + arr[mid - 1]) / 2.0;
    }*/
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		return 0.0;
    }
	
	@Test
	public void test() {
		int[] nums1 = {1, 2}, nums2 = {3, 4};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
