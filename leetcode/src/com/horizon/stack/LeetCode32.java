package com.horizon.stack;

import org.junit.Test;

/**
 * leetcode32. 
 * title: 最长有效括号 
 * level: difficulty
 * 
 * @author Horizon
 *
 * @Date 2019年4月9日下午9:07:11
 */
public class LeetCode32 {
	/*// 用栈实现
	public int longestValidParentheses(String s) {
		if (s == null || s.length() <= 1) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();
		int max = 0, start = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else if (s.charAt(i) == ')') {
				if (stack.isEmpty()) {
					// 记录栈中第一个'('开始的位置
					start = i + 1;
				} else {
					// 如果栈不为空，把栈顶的'('弹出
					stack.pop();
					// 如果弹出栈顶后栈变为空，表示前面括号匹配成功，
					// 具体匹配成功的字符串数等于当前位置i减去栈中第一个'('出现的位置
					if (stack.isEmpty()) {
						max = Math.max(max, i - start + 1);
					} else {
						// 否则表示原栈中有两个或两个以上的'('
						max = Math.max(max, i - stack.peek());
					}
				}
			}
		}
		return max;
	}*/
	
	// 动态规划实现
	public int longestValidParentheses(String s) {
		if (s == null || s.length() <= 1) {
			return 0;
		}
		int n = s.length(), max = 0;
		int[] dp = new int[n];
		for (int i = 1; i < n; i++) {
			if (s.charAt(i) == ')') {
				// 寻找该')'之前的最大匹配
				if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + 2;
				}
				// 将前面不间断的匹配加起来。如"()(())"
				if (i - dp[i] >= 0) {
					dp[i] += dp[i - dp[i]];
				}
				if (max < dp[i])
					max = dp[i];
			}
		}
		return max;
	}
	
	@Test
	public void test() {
		String s = "())(())";
		System.out.println(longestValidParentheses(s));
	}
}
