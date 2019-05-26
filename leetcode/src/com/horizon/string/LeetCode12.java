package com.horizon.string;

/**
 * 整数转罗马数字
 * @author Horizon
 *
 * @Date 2019年5月11日下午10:05:10
 */
public class LeetCode12 {

	public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strArr = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(strArr[i]);
                num -= values[i];
            }
            if (num <= 0)
                break;
        }
        return sb.toString();
    }
	
}
