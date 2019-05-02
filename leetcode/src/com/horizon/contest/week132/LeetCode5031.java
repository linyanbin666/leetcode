package com.horizon.contest.week132;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.horizon.tree.TreeNode;

/**
 * leetcode5031. 
 * title: 从先序遍历还原二叉树
 * level: difficulty
 * @author Horizon
 *
 * @Date 2019年4月14日上午11:55:10
 */
public class LeetCode5031 {

	public TreeNode recoverFromPreorder(String S) {
		if (S == null || S.length() == 0)
			return null;
		return recoverFromPreorderCore(S, 1);
	}

	private TreeNode recoverFromPreorderCore(String S, int depth) {
		String[] strArr = split(S, depth);
		if (strArr.length == 0)
			return null;
		TreeNode node = new TreeNode(Integer.valueOf(strArr[0]));
		TreeNode left = null, right = null;
		for (int i = 1; i < strArr.length; i++) {
			if (i == 1) {
				left = recoverFromPreorderCore(strArr[i], depth + 1);
			} else if (i == 2) {
				right = recoverFromPreorderCore(strArr[i], depth + 1);
			}
		}
		node.left = left;
		node.right = right;
		return node;
	}
	// 切割字符串，例如split("1-2--3--4-5--6--7", 1)的结果为[1,2--3--4,5--6--7]
	private String[] split(String t, int count) {
		List<String> list = new ArrayList<>();
		int i = 0; // 标记每一部分的起始下标
		while (i < t.length()) {
			int start = i; 
			while (start < t.length() && t.charAt(start) != '-') {
				start++;
			}
			int end = start + 1;
			while (end < t.length()) {
				while (start < t.length() && t.charAt(start) != '-') {
					start++;
				}
				while (t.charAt(end) == '-') {
					end++;
				}
				if (end - start != count) {
					start = end;
					end = start + 1;
				} else {
					list.add(t.substring(i, start));
					break;
				}
			}
			// 切最后部分
			if (end >= t.length())
				list.add(t.substring(i));
			i = end;
		}
		return list.toArray(new String[] {});
	}

	@Test
	public void test() {
		String S = "1-2--3--4-5--6--7";
		TreeNode root = recoverFromPreorder(S);
		System.out.println();
	}
	
	@Test
	public void test1() {
		System.out.println(Arrays.toString(split("2--3--4", 2)));
	}
}
