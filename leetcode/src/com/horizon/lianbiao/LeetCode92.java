package com.horizon.lianbiao;

import org.junit.Test;

import com.horizon.ListNode;

/**
 * leetcode92. 反转链表II
 * @author linyanbin
 *
 * 2019年3月16日下午5:59:58
 */
public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode curr = head, prev = null;
        while (m > 1) {
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }
        
        // 保存前部分链表的尾结点，中间链表的尾结点
        ListNode fontTail = prev, midTail = curr;
        ListNode next;
        while (n > 0) {
            next = curr.next; // 暂存后一结点
            curr.next = prev; // 实现反转
            prev = curr;
            curr = next;
            n--;
        }
        
// 循环结束后prev位于原n的位置，curr位于n+1的位置，即prev为中间链表的头结点，curr为尾链表的头结点
        // 拼接链表，fontTail -> prev，midTail -> curr       
        if (fontTail != null) {
            fontTail.next = prev;
        } else {
            head = prev;  // 如果fontTail为空，头结点为中间链表的头结点，即prev
        }
        midTail.next = curr;
        return head;
    }
    
    @Test
    public void test() {
    	ListNode head = new ListNode(1);
    	head.add(2).add(3).add(4).add(5);
    	System.out.println(head);
    	System.out.println(reverseBetween(head, 2, 4));
    }
}