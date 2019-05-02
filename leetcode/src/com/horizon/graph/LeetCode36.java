package com.horizon.graph;
/**
 * leetcode36.
 * title: 有效的数独
 * level: medium
 * @author Horizon
 *
 * @Date 2019年4月13日下午10:43:32
 */
public class LeetCode36 {

	public boolean isValidSudoku(char[][] board) {
		boolean[][] rows = new boolean[9][10];
		boolean[][] cols = new boolean[9][10];
		boolean[][] block = new boolean[9][10];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int num = board[i][j] - '0';
					if (rows[i][num] ||
							cols[j][num] ||
							block[i / 3 * 3 + j / 3][num]) {
						return false;
					}
					rows[i][num] = true;
					cols[j][num] = true;
					block[i / 3 * 3 + j / 3][num] = true;
				}
			}
		}
		return true;
	}
}
