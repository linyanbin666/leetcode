package com.horizon.lianbiao;

import org.junit.Test;

import com.horizon.ListNode;

/**
 * leetcode142. 环形链表II
 * @author linyanbin
 *
 * 2019年3月16日下午5:42:34
 */
public class LeetCode142 {
	// head
	//  1 -- 2 -- 3 -- 4 -- 5                   
	//            |         |
	//            7 --------6 fast和slow在6相遇
	// 设 2,3段为a, 4,5,6为b, 7,3为c
	// slow = a + b
	// fast = a + b + c + b
	// 2*slow = fast 
	// 所以 a = c		
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        // 注意起点会影响到后面
        ListNode slow = head;
        ListNode fast = head;
        // 快慢指针找到相遇点
        while (fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if (slow == fast) {
        		break;
        	}
        }
        
        fast = head;
        while (fast != null && slow != null) {
        	if (fast == slow) {
        		return fast;
        	}
        	slow = slow.next;
        	fast = fast.next;
        }
        
        return null;
    }
    
    @Test
    public void test() {
    	ListNode head = new ListNode(3);
    	ListNode tail = head.add(2).add(0).add(-4);
    	tail.next = head.search(2);
    	ListNode detectCycle = detectCycle(head);
    	System.out.println(detectCycle.val);
    }
}