package com.horizon.lianbiao;

import org.junit.Test;

import com.horizon.ListNode;

/**
 * leetcode24. 两两交换链表中的节点
 * @author linyanbin
 *
 * 2019年3月16日下午4:02:55
 */
public class LeetCode24 {
	
	 // 递归实现
    public ListNode swapPairs(ListNode head) {
        // 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        // 单次过程
        head.next = swapPairs(next.next);
        next.next = head;
        // 递归返回值
        return next;
    }
	
	@Test
	public void test() {
		ListNode head = new ListNode(1);
		head.add(2).add(3).add(4).add(5);
		System.out.println(head);
		System.out.println(swapPairs(head));
	}
}