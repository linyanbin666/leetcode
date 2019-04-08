package com.horizon.lianbiao;

import org.junit.Test;

import com.horizon.ListNode;

/**
 * leetcode61. 旋转链表
 * 
 * @author linyanbin
 *
 *         2019年3月19日下午4:40:09
 */
public class LeetCode61 {

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k < 0) {
			return head;
		}
		// 统计链表个数
		ListNode p = head;
		int count = 0;
		while (p != null) {
			count++;
			p = p.next;
		}
		// 将k降到一个循环周期内
		k %= count;
		// 如果k==0,不用移动直接返回
		if (k == 0) {
			return head;
		}
		// 按照寻找倒数第k个结点的思路，找到移动后的尾结点和头结点
		ListNode slow = head;
		for (int i = 0; i < k; i++) {
			slow = slow.next;
		}
		ListNode fast = head;
		while (slow.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		// fast最后指向旋转后链表的尾结点，它的下一个结点为旋转后链表的头结点
		ListNode newHead = fast.next;
		// 将尾结点指向置空
		fast.next = null;
		// 将原链表的尾结点连接到原链表的头结点
		slow.next = head;
		return newHead;
	}

	@Test
	public void test() {
		ListNode head = new ListNode(0);
		head.add(1).add(2);
		System.out.println(head);
		System.out.println(rotateRight(head, 4));
	}

}
