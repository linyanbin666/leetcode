package com.horizon.algorithm.dp;

import org.junit.Test;

/**
 * leetcode121. 买卖股票的最佳时机
 * @author Horizon
 *
 * 2019年4月2日下午11:37:30
 */
public class LeetCode121 {
	// 动态规划
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 初始化
        int max = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
        	// 第i天的收益 = max(前i-1天的最大收益, 第i天的价格 - 前i-1天的最小价格)，因当前状态
            // 的转移只依赖于前一个状态，用一个变量保存前一状态的值即可，不用数组来保存
        	if (prices[i] - min > max) {
        		max = prices[i] - min;
        	}
        	if (min > prices[i]) {
        		min = prices[i];
        	}
        }
        return max;
    }
	
	@Test
	public void test() {
		int[] arr = {7,1,5,3,6,4};
		System.out.println(maxProfit(arr));
	}
}
