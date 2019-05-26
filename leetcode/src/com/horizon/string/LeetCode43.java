package com.horizon.string;

import org.junit.Test;

/**
 * leetcode43. title: 字符串相乘 level: medium
 * 
 * @author Horizon
 *
 * @Date 2019年5月26日下午11:00:29
 */
public class LeetCode43 {
	public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] resArr = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                mul += resArr[i + j + 1]; // 加上之前的进位数
                
                resArr[i + j] += mul / 10; // 进位
                resArr[i + j + 1] = mul % 10; // 个位赋值
            }
        }
        // 去掉前导0
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < resArr.length - 1 && resArr[i] == 0) i++;
        while (i < resArr.length) {
            sb.append(resArr[i++]);
        }
        return sb.toString();
    }
	
	@Test
	public void test() {
		String num1 = "123";
		String num2 = "456";
		System.out.println(multiply(num1, num2));
	}
	
}
