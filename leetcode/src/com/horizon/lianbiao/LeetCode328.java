package com.horizon.lianbiao;

import org.junit.Test;

import com.horizon.ListNode;

/**
 * leetcode328. 奇偶链表
 * @author linyanbin
 *
 * 2019年3月16日下午8:45:30
 */
public class LeetCode328 {
	
	// 非递归解法
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }    
        ListNode odd = head;
        ListNode even = head.next;
        // 保存偶链表的头结点
        ListNode evenHead = even;
        // 初始化奇链表的尾结点
        ListNode oddTail = odd;
        while (odd != null && even != null) {
        	// 改变奇结点指向下一个奇结点
            odd.next = even.next;
            odd = even.next;
            // 如果后续还有结点，改变偶结点的指向
            if (odd != null) {
                even.next = odd.next;
                oddTail = odd;
            }
            even = even.next;
        }
        
        oddTail.next = evenHead;
        return head;
    }
	
    @Test
    public void test() {
    	ListNode head = new ListNode(1);
    	head.add(2).add(3).add(4).add(5);
    	System.out.println(head);
    	System.out.println(oddEvenList(head));
    }
	
}
