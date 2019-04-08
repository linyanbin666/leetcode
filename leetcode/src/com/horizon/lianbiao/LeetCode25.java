package com.horizon.lianbiao;

import org.junit.Test;

import com.horizon.ListNode;

/**
 * leetcode25. k个一组翻转链表
 * 
 * @author linyanbin
 *
 *         2019年3月16日下午9:43:31
 */
public class LeetCode25 {

	public ListNode reverseKGroup(ListNode head, int k) {
		// 统计链表结点个数
		int listCount = 0;
		ListNode p = head;
		while (p != null) {
			listCount++;
			p = p.next;
		}
		// 计算分组
		int m = listCount / k;
		// 遍历反转每一组的结点
		for (int i = 1; i <= m; i++) {
			head = reverseBetween(head, (i - 1) * k + 1, i * k);
		}
		return head;
	}
	/**
	 * 实现反转第[m, n]个结点
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = null;
		ListNode curr = head;
		while (m > 1) {
			pre = curr;
			curr = curr.next;
			m--;
			n--;
		}
		// 保存前链表的尾结点，中间结点链表的尾结点
		ListNode frontTail = pre, midTail = curr;
	    ListNode next = null;
		while (n > 0) {
			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
			n--;
		}
		if (frontTail == null) {
			head = pre;
		} else {
			frontTail.next = pre;
		}
		midTail.next = curr;

		return head;
	}
	
	// 递归实现
	public ListNode reverseKGroupRecursion(ListNode head, int k) {
		ListNode prev = null, curr = head, next = null;
		ListNode p = head;
		int count = 0;
		while (p != null && count < k) {
			p = p.next;
			count++;
		}
		if (count == k) {
			// 反转k个结点
			count = 0;
			while (count < k && curr != null) {
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
				count++;
			}
			if (next != null) {
				// head为反转后链表的尾结点
				head.next = reverseKGroupRecursion(next, k);
			}
			// prev为反转后链表的头结点
			return prev;
		} else {
			return head;
		}
	}
	
	@Test
	public void test() {
	 	ListNode head = new ListNode(1);
    	head.add(2).add(3).add(4).add(5);
    	System.out.println(head);
    	System.out.println(reverseKGroupRecursion(head, 2));
	}
}
