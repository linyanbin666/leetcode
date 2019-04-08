package com.horizon;
public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}
	
	public ListNode add(int val) {
		ListNode node = new ListNode(val);
		this.next = node;
		return node;
	}
	
	public ListNode search(int val) {
		ListNode p = this;
		while (p != null) {
			if (p.val == val) {
				return p;
			}
			p = p.next;
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListNode p = this;
		while (p != null) {
			sb.append(p.val + "-->");
			p = p.next;
		}
		sb.append("null");
		return sb.toString();
	}
}