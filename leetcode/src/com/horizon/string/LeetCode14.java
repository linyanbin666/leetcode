package com.horizon.string;

import org.junit.Test;

/**
 * 最长公共前缀
 * @author Horizon
 *
 * @Date 2019年5月12日下午9:36:32
 */
public class LeetCode14 {

	// 水平扫描法
	public String longestCommonPrefix1(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		// 找出前两个的最长公共前缀，再用最长公共前缀进行与后续的字符串比较
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}
		}
		return prefix;
	}
	
	// 纵向比较
	public String longestCommonPrefix2(String[] strs) {
		if (strs == null || strs.length == 0) 
			return "";
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != c) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}
	
	// 分治
	public String longestCommonPrefix3(String[] strs) {
		if (strs == null || strs.length == 0) 
			return "";
		return fengzhi(strs, 0, strs.length - 1);
	}

	private String fengzhi(String[] strs, int low, int high) {
		if (low == high)
			return strs[low];
		int mid = low + ((high - low) >> 1);
		String leftStr = fengzhi(strs, low, mid);
		String rightStr = fengzhi(strs, mid + 1, high);
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < Math.min(leftStr.length(), rightStr.length()); i++) {
			if (leftStr.charAt(i) != rightStr.charAt(i))
				break;
			sb.append(leftStr.charAt(i));
		} 
		return sb.toString();
	}
	
	// 二分查找法
	public String longestCommonPrefix4(String[] strs) {
		if (strs == null || strs.length == 0) 
			return "";
		int minLen = strs[0].length();
		for (int i = 1; i < strs.length; i++) {
			minLen = Math.min(minLen, strs[i].length());
		}
		int low = 1, high = minLen;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (isPrefix(strs, mid)) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return strs[0].substring(0, (low + high) / 2);
	}
	
	private boolean isPrefix(String[] strs, int mid) {
		String str = strs[0].substring(0, mid);
		for (int i = 1; i < strs.length; i++) {
			if (!strs[i].startsWith(str)) {
				return false;
			}
		}
		return true;
	}
	
	// Trie树实现
	public String longestCommonPrefix5(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];
		Trie trie = new Trie();
		for (int i = 1; i < strs.length; i++) {
			trie.insert(strs[i]);
		}
		return trie.searchLongestPrefix(strs[0]);
	}
	
	class Trie {
		private TrieNode root;
		
		public Trie() {
			root = new TrieNode();
		}
		
		// 插入字符串到Trie树中
		public void insert(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char currChar = word.charAt(i);
				if (!node.containsKey(currChar)) {
					node.put(currChar, new TrieNode());
				}
				node = node.get(currChar);
			}
			node.setEnd();
		}
		
		// 查找前缀，返回尾结点
		private TrieNode searchPrefix(String prefix) {
			TrieNode node = root;
			for (int i = 0; i < prefix.length(); i++) {
				char currChar = prefix.charAt(i);
				if (!node.containsKey(currChar)) 
					return null;
				node = node.get(currChar);
			}
			return node;
		}
		
		// 查找是否存在与前缀串相等的字符串
		public boolean search(String word) {
			TrieNode node = searchPrefix(word);
			return node != null && node.isEnd();
		}
		
		// 查找是否存在前缀串 
		public boolean startsWith(String word) {
			TrieNode node = searchPrefix(word);
			return node != null;
		}
		
		// 查找最长前缀
		public String searchLongestPrefix(String word) {
			TrieNode node = root;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < word.length(); i++) {
				char currChar = word.charAt(i);
				if (node.getSize() != 1 || !node.containsKey(currChar) || node.isEnd()) 
					break;
				sb.append(currChar);
				node = node.get(currChar);
			}
			return sb.toString();
		}
		
	}
	
	class TrieNode {
		private TrieNode[] links;
		private final int R = 26;
		private boolean isEnd;
		// 非空子节点的数量
	    private int size;

	    public TrieNode() {
			links = new TrieNode[R];
		}
		
		// 判断当前节点的孩子是否有ch
		public boolean containsKey(char ch) {
			return links[ch - 'a'] != null;
		}
		
		// 获取孩子节点
		public TrieNode get(char ch) {
			return links[ch - 'a'];
		}
		
		// 插入孩子节点
		public void put(char ch, TrieNode node) {
			links[ch - 'a'] = node;
			size++;
		} 

		public int getSize() {
			return size;
		}
		
		public void setEnd() {
			isEnd = true;
		}
		
		public boolean isEnd() {
			return isEnd;
		}
	}
	
	@Test
	public void test() {
		String[] strs = {"leets", "leetcode", "leetc", "leeds"};
//		String[] strs = {"aca","cba"};
		System.out.println(longestCommonPrefix5(strs));
	}
}
