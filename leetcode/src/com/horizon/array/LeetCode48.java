package com.horizon.array;
/**
 * leetcode48.
 * @author Horizon
 *
 * @Date 2019年5月7日下午9:51:00
 */
public class LeetCode48 {
	/*
	// 扣边界，找规律，麻烦
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;
		int rows = matrix.length - 1;
		int cols = matrix[0].length - 1;
		int col = cols, row = rows;
		for (int i = 0; i < row; i++) {
			for (int j = i; j < col; j++) {
				// 找规律
				int x1 = i, y1 = j;
				int x2 = rows - j, y2 = i;
				int x3 = rows - i, y3 = cols - j;
				int x4 = j, y4 = cols - i;
				swap(matrix, x1, y1, x2, y2);
				swap(matrix, x2, y2, x3, y3);
				swap(matrix, x3, y3, x4, y4);
			}
			row--;
			col--;
		}
	}
	 */
	
	private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
		int temp = matrix[x1][y1];
		matrix[x1][y1] = matrix[x2][y2];
		matrix[x2][y2] = temp;
	}
	
	// 先转置后镜像，清晰简单
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;
        int n = matrix.length;
        // 转置矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        // 矩阵镜像
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, n - j - 1);
            }
        }
    }
}
