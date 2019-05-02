package com.horizon.lianbiao;

import java.util.Stack;

import com.horizon.ListNode;

/**
 * leetcode445.
 * title: 两数相加II
 * level: medium
 * @author Horizon
 *
 * @Date 2019年4月25日上午11:01:49
 */
public class LeetCode445 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode p = l1;
        while (p != null) {
            s1.push(p.val);
            p = p.next;
        }
        p = l2;
        while (p != null) {
            s2.push(p.val);
            p = p.next;
        }
        int carry = 0, sum = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            sum = s1.pop() + s2.pop() + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            node.next = dummy.next;
            dummy.next = node;
        }
        while (!s1.isEmpty()) {
            sum = s1.pop() + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            node.next = dummy.next;
            dummy.next = node;
        }
        while (!s2.isEmpty()) {
            sum = s2.pop() + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            node.next = dummy.next;
            dummy.next = node;
        }
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }
}
