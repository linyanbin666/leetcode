package com.horizon.contest.week132;

import org.junit.Test;

import com.horizon.tree.TreeNode;

/**
 * 节点与其祖先之间的最大值，No Pass
 * @author Horizon
 *
 * @Date 2019年4月14日上午11:09:49
 */
public class LeetCode5030 {

	public int maxAncestorDiff(TreeNode root) {
		if (root.left == null && root.right == null)
			return 0;
		int left = 0, right = 0;
		if (root.left != null) {
			left = root.val - root.left.val;
		}
		if (root.right != null) {
			right = root.val - root.right.val;
		}
		if (left > 0)
			left = left + maxAncestorDiff(root.left);
		else 
			left = maxAncestorDiff(root.left);
		if (right > 0)
			right = right + maxAncestorDiff(root.right);
		else 
			right = maxAncestorDiff(root.right);
		return Math.max(left, right);
	}
	
	@Test
	public void test() {
		
	}
	
}
