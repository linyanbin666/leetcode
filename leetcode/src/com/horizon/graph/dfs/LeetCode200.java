package com.horizon.graph.dfs;
/**
 * leetcode200.
 * title: 岛屿的个数
 * level: medium
 * @author Horizon
 *
 * @Date 2019年4月13日下午9:59:41
 */
public class LeetCode200 {
	
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int n = grid.length, m = grid[0].length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1') {
					sum++;
					dfs(grid, i, j, n, m);
				}
			}
		}
		return sum;
	}

	// 深度遍历走掉所有相邻的1
	private void dfs(char[][] grid, int i, int j, int n, int m) {
		if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0')
			return;
		grid[i][j] = '0';
		dfs(grid, i - 1, j, n, m);
		dfs(grid, i + 1, j, n, m);
		dfs(grid, i, j - 1, n, m);
		dfs(grid, i, j + 1, n, m);
	}
}
