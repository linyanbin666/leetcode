package com.horizon.array;
/**
 * leetcode45.
 * title: 跳跃游戏II
 * level: hard
 * @author Horizon
 *
 * @Date 2019年5月7日上午8:20:29
 */

import org.junit.Test;

public class LeetCode45 {
	
	// 容易理解的
	public int jump(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;
        int len = nums.length;
        //i-坐标，r-走ans步最远可以走到的坐标，temp-储存暂时的最大r
        int i = 0, temp = nums[0], r = 0, ans = 0;
        while(i < len){
            r = temp;
            if(r >= len-1) return ans + 1;
            // 往前走一步
            ans++;
            temp = 0;
            // 求往前走一步后，下一步能走到的最远位置
            while(i <= r){
                temp = Math.max(temp, i + nums[i]);
                i++;
            }
        }
        return 0;
    }
	
	@Test
	public void test() {
		int[] nums = {2,3,1,1,4};
		System.out.println(jump(nums));
	}
}
