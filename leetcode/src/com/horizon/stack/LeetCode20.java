package com.horizon.stack;

import java.util.Stack;

import org.junit.Test;

/**
 * leetcode20.
 * title: 有效的括号
 * level: simple
 * @author Horizon
 *
 * @Date 2019年4月9日下午8:48:29
 */
public class LeetCode20 {
	public boolean isValid(String s) {
		if ("".equals(s)) {
			return true;
		}
		char[] chars = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < chars.length; i++) {
			switch (chars[i]) {
			case '(':
			case '{':
			case '[':
				stack.push(chars[i]);
				break;
			default:
				// 栈为空或者右括号与栈顶元素不匹配
				if (stack.isEmpty() || !check(stack.pop(), chars[i])) 
					return false;
				break;
			}
		}
		if (stack.isEmpty()) 
			return true;
		return false;
	}

	private boolean check(char left, char right) {
		return (left == '(' && right == ')') || 
			   (left == '{' && right == '}') ||
			   (left == '[' && right == ']') ;
	}
	
	@Test
	public void test() {
		String s = "())";
		System.out.println(isValid(s));
	}
}
