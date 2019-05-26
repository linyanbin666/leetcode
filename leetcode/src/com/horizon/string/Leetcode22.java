package com.horizon.string;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * leetcode22. title: 括号生成 level: medium
 * 
 * @author Horizon
 *
 * @Date 2019年5月23日下午11:03:31
 */
public class Leetcode22 {
	/*
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		generateParenthesisCore("", 0, 0, n, res);
		return res;
	}

	/**
	 * @param str 当前字符串
	 * @param lb 左括号数
	 * @param rb 右括号数
	 * @param n 括号组数
	 * @param res 结果
	 *//*
	private void generateParenthesisCore(String str, int lb, int rb, int n, List<String> res) {
		if (lb > n || rb > n)
			return;
		if (lb == n && rb == n)
			res.add(str);
		// 当左括号大于等于右括号数时才继续扩展
		if (lb >= rb) {
			if (lb < n) {
				generateParenthesisCore(str + "(", lb + 1, rb, n, res);
			}
			if (rb < n) {
				generateParenthesisCore(str + ")", lb, rb + 1, n, res);
			}
		}
	}*/
	
	/*
    To generate all n-pair parentheses, we can do the following:
		Generate one pair: ()
		Generate 0 pair inside, n - 1 afterward: () (...)...
		Generate 1 pair inside, n - 2 afterward: (()) (...)...
		...
		Generate n - 1 pair inside, 0 afterward: ((...))
	*/
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		if (n == 0) {
			res.add("");
		}
		for (int i = 0; i < n; i++) {
			for (String inside : generateParenthesis(i)) 
				for (String outside : generateParenthesis(n - i - 1))
					res.add("(" + inside + ")" + outside);
		}
		return res;
	}
	
	@Test
	public void test() {
		generateParenthesis(3).stream().forEach(System.out::println);;
	}
}
