package com.horizon.tree;
/**
 * leetcode112.
 * title: 路径总和
 * level: simple
 * @author Horizon
 *
 * @Date 2019年4月12日下午11:43:11
 */
public class LeetCode112 {
		
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		// 到叶子节点
		if (root.left == null && root.right == null) 
			return sum - root.val == 0;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}
