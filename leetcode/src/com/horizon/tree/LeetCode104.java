package com.horizon.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode104. 
 * title: 二叉树的最大深度
 * level: simple
 * @author Horizon
 *
 * @Date 2019年4月12日下午11:14:14
 */
public class LeetCode104 {

	/*// 递归实现
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}*/
	
	// 非递归层次实现
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		int res = 0;
		queue.offer(root);
		while (!queue.isEmpty()) {
			res++;
			int n = queue.size();
			while (n > 0) {
				TreeNode p = queue.poll();
				if (p.left != null)
					queue.offer(p.left);
				if (p.right != null)
					queue.offer(p.right);
				n--;
			}
		}
		return res;
	}
}
