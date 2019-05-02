package com.horizon.contest.week132;
/**
 * leetcode5024.
 * title: 除数博弈
 * level: simple
 * @author Horizon
 *
 * @Date 2019年4月14日上午10:39:10
 */
import org.junit.Test;

public class LeetCode5024 {
	
	public boolean divisorGame(int N) {
		if (N == 2) {
			return true;
		}
		boolean flag = true;
		for (int i = 1; i < N; i++) {
			if (N % i == 0) {
				flag = divisorGame(N - i);
				break;
			}
		}
		return !flag;
	}
	
	@Test
	public void test() {
		System.out.println(divisorGame(4));
	}
}
