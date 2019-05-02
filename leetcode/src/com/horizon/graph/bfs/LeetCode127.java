package com.horizon.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * leetcode127. 
 * title: 单词接龙
 * level: medium
 * 
 * @author Horizon
 *
 * @Date 2019年4月23日下午8:44:34
 */
public class LeetCode127 {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (wordList == null || wordList.size() == 0) {
			return 0;
		}
		Queue<String> queue = new LinkedList<>();
		// 保存转换序列的长度
		Queue<Integer> lenQueue = new LinkedList<>();
		Set<String> set = new HashSet<>(); 
		queue.offer(beginWord);
		lenQueue.offer(1);
		set.addAll(wordList);
		while (!queue.isEmpty()) {
			String word = queue.poll();
			int curLen = lenQueue.poll();
			if (word.equals(endWord)) {
				return curLen;
			}
			char[] array = word.toCharArray();
			for (int i = 0; i < word.length(); i++) {
				// 替换一个不同的字符
				for (char c = 'a'; c <= 'z'; c++) {
					if (c == array[i])
						continue;
					char temp = array[i];
					array[i] = c;
					String str = String.valueOf(array);
					// 如果替换后的字符串在字典中存在，则加入表示可转换，加入队列中
					if (!set.isEmpty() && set.contains(str)) {
						queue.offer(str);
						lenQueue.offer(curLen + 1);
						set.remove(str);
					}
					// 还原
					array[i] = temp;
				}
			}
		}
		return 0;
	}
}
