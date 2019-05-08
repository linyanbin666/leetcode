package com.horizon.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * leetcode40.
 * title: 组合总数II
 * level: medium
 * @author Horizon
 *
 * @Date 2019年5月4日下午11:11:12
 */
public class LeetCode40 {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		Arrays.sort(candidates); // 排序，方便去重
		dfs(candidates, target, res, temp, 0);
		return res;
	}

	private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp,
			int index) {
		if (target < 0)
			return;
		if (target == 0) {
			List<Integer> list = new ArrayList<>(temp);
			res.add(list);
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			// 关键去重
			if (i != index && candidates[i] == candidates[i - 1]) 
				continue;
			if (candidates[i] <= target) {
				temp.add(candidates[i]);
				dfs(candidates, target - candidates[i], res, temp, i + 1);
				temp.remove(temp.size() - 1);
			}
		}
	}
	
	@Test
	public void test() {
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> res = combinationSum2(candidates, target);
		res.stream().forEach(System.out::println);
	}
}
