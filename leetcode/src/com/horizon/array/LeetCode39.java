package com.horizon.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * leetcode39.
 * title: 组合总和
 * level: medium
 * @author Horizon
 *
 * @Date 2019年5月4日下午10:40:02
 */
public class LeetCode39 {
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> temp = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(candidates); // 排序，方便去重
		dfs(candidates, target, temp, res, 0);
		return res;
	}

	private void dfs(int[] candidates, int target, List<Integer> temp, List<List<Integer>>res, int index) {
		if (target < 0)
			return;
		if (target == 0) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			temp.add(candidates[i]);
			// 将i传递下去避免重复
			dfs(candidates, target - candidates[i], temp, res, i);
			temp.remove(temp.size() - 1);
		}
	}
	
	@Test
	public void test() {
		int[] candidates = {2,3,5};
		int target = 8;
		List<List<Integer>> list = combinationSum(candidates, target);
		list.stream().forEach(System.out::println);
	}
}
