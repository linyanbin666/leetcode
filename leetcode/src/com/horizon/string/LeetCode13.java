package com.horizon.string;

/**
 * 罗马数字转整数
 * @author Horizon
 *
 * @Date 2019年5月9日上午8:27:14
 */
public class LeetCode13 {

	public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            // 先加起来
            switch(chars[i]) {
                case 'I':
                    sum += 1;break;
                case 'V':
                    sum += 5;break;
                case 'X':
                    sum += 10;break;
                case 'L':
                    sum += 50;break;
                case 'C':
                    sum += 100;break;
                case 'D':
                    sum += 500;break;
                case 'M':    
                    sum += 1000;break;
                default: break;
            }
            // 对特殊规则进行处理，减去特定值
            if (i > 0) {
                if (((chars[i] == 'V') || (chars[i] == 'X')) && chars[i - 1] == 'I') 
                    sum -= 2;
                if (((chars[i] == 'L') || (chars[i] == 'C')) && chars[i - 1] == 'X')
                    sum -= 20;
                if (((chars[i] == 'D') || (chars[i] == 'M')) && chars[i - 1] == 'C')
                    sum -= 200; 
            }
        }
        return sum;
    }
	
}
