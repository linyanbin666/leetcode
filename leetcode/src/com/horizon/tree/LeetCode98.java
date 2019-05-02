package com.horizon.tree;

import java.util.Stack;

/**
 * leetcode98. 
 * title: 验证二叉搜索树
 * level: medium
 * @author Horizon
 *
 * @Date 2019年4月12日下午11:59:28
 */
public class LeetCode98 {
	
	public boolean isValidBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root, pre = null;
		boolean isFirst = true;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			p = stack.pop();
			if (isFirst) {
				pre = p;
				isFirst = false;
			} else {
				if (pre.val >= p.val) 
					return false;
				pre = p;
			}
			p = p.right;
		}
		return true;
	}
}
