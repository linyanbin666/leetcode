package com.horizon.array;

import java.util.Arrays;

import org.junit.Test;

/**
 * leetcode66. 
 * title: 加一 
 * level: simple
 * @author Horizon
 *
 * @Date 2019年4月8日下午9:44:14
 */
public class LeetCode66 {

	public int[] plusOne(int[] digits) {
		int carry = 1, tmp;
		for (int i = digits.length - 1; i >= 0; i--) {
			tmp = digits[i] + carry; 
			digits[i] = tmp % 10;
			carry = tmp / 10;
			if (carry == 0)
				break;
		}
		// 如果最高位还有进位，需进行处理
		if (carry == 1) {
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			for (int i = 0; i < digits.length; i++) {
				res[i + 1] = digits[i];
			}
			return res;
		} else {
			return digits;
		}
	}
	
	@Test
	public void test() {
		int[] digits = {9};
		System.out.println(Arrays.toString(plusOne(digits)));
	}
}
