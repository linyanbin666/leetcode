package com.horizon.array;

import org.junit.Test;

/**
 * leetcode88.
 * title: 合并两个有序数组
 * level: easy
 * @author Horizon
 *
 * @Date 2019年5月7日上午9:54:16
 */
public class LeetCode88 {

	 /*
    // 从前往后比较，需辅助空间
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 考虑问题要周全
        if (nums2.length == 0)
			return;
        // 辅助空间
        int[] res = new int[nums1.length];
        int index = 0, i = 0, j = 0;
        while (j < n) {
            if (i == m) {
                break;
            }
            if (nums1[i] <= nums2[j]) {
                res[index++] = nums1[i++];
            } else {
                res[index++] = nums2[j++];
            }
        }
        while (j < n) {
            res[index++] = nums2[j++];
        }
        while (i < m) {
            res[index++] = nums1[i++];
        }
        for (i = 0; i < res.length; i++) {
            nums1[i] = res[i];
        }
    }
    */
    // 从后往前比较，直接在nums1数组上赋值
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            nums1[index--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n >= 0) {
            nums1[index--] = nums2[n--];
        }
    }
	
	@Test
	public void test() {
		int[] nums1 = {0}, nums2 = {1};
		int m = 0, n = 1;		
		merge(nums1, m, nums2, n);
	}
}
