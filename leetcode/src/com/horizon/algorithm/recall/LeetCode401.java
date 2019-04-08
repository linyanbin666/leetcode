package com.horizon.algorithm.recall;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.horizon.StdOut;

/**
 * leetcode401. 二进制手表
 * 
 * @author Horizon
 *
 *         2019年4月1日下午11:02:39
 */
public class LeetCode401 {

	public List<String> readBinaryWatch(int num) {
		List<String> res = new LinkedList<String>();
		if (num >= 9) {
			return res;
		}
		int[] items = new int[6]; 
		getItems(items);
		dfs(items, res, 0, 0, 0, num);
		return res;
	}	

	private void dfs(int[] items, List<String> res, int index, int h, int m, int num) {
		if (num == 0) {
			if (h >= 12 || m >= 60)
				return;	
			res.add(h + ":" + String.format("%02d", m));
		} else {
			for (int i = index; i < 10; i++) {
				// 分钟
				if (i < 6) {
					m += items[i];
					dfs(items, res, i + 1, h, m, num - 1);
					// 回溯
					m -= items[i];
				} else {
					// 小时
					h += items[i - 6];
					dfs(items, res, i + 1, h, m, num - 1);
					// 回溯
					h -= items[i - 6];
				}
			}
		}
	}

	private void getItems(int[] items) {
		for (int i = 0; i < items.length; i++) {
			items[i] = 1 << i;
		}
	}

	@Test
	public void test() {
		StdOut.printListOrSet(readBinaryWatch(2));
	}
}
