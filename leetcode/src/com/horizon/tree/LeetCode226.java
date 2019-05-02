package com.horizon.tree;
/**
 * leetcode226.
 * title: 翻转二叉树
 * level: simple
 * @author Horizon
 *
 * @Date 2019年4月12日下午11:39:17
 */
public class LeetCode226 {
	
	public TreeNode invertTree(TreeNode root) {
		if (root == null) 
			return null;
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.right = left;
		root.left = right;
		return root;
	}
}
