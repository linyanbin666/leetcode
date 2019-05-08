package com.horizon.array;

/**
 * leetcode73.
 * title: 矩阵置零
 * level: medium
 * @author Horizon
 *
 * @Date 2019年5月8日上午10:29:59
 */
public class LeetCode73 {

	/*
    // O(m*n)空间复杂度解法
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int n = matrix.length, m = matrix[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    int k = 0;
                    while (k < i) {
                        res[k][j] = 0;
                        k++;
                    }
                    k = i + 1;
                    while (k < n) {
                        res[k][j] = 0;
                        k++;
                    }
                    k = 0;
                    while (k < j) {
                        res[i][k] = 0;
                        k++;
                    }
                    k = j + 1;
                    while (k < m) {
                        res[i][k] = 0;
                        k++;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = res[i][j]; 
            }
        }
    }
    */
    /*
    // O(m + n)空间复杂度解法
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int n = matrix.length, m = matrix[0].length;
        // 只要一行或一列中有一个0，则标记对应的行需要置0
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    if (!row[i])
                        row[i] = true;
                    if (!col[j])
                        col[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j])
                    matrix[i][j] = 0;
            }
        }
    }
    */
    // 常数空间复杂度解法, 利用数组的首行和首列来记录0值
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int n = matrix.length, m = matrix[0].length;
        boolean rowFlag = false, colFlag = false;
        // 先标记第一行和第一列是否有0值
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }            
        }
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }            
        }
        // 用首行首列来标记0值
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 判断首行元素是否有0值，有则将元素对应的列置0
        for (int i = 1; i < m; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        // 判断首列元素是否有0值，有则将元素对应的行置0
        for (int i = 1; i < n; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 判断首行和首列
        if (rowFlag){
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }
        if (colFlag){
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
