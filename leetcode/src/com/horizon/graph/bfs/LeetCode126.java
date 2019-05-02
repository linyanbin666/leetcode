package com.horizon.graph.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * leetcode126.
 * title: 单词接龙II
 * level: hard
 * @author Horizon
 *
 * @Date 2019年4月23日下午9:33:55
 */
public class LeetCode126 {

	// 结果
	List<List<String>> result = new ArrayList<>();
	// 保存当前节点到所有下一节点的对应关系
	Map<String, List<String>> nodeNeighbors = new HashMap<>();
	// 保存节点的最短序列长度
    Map<String, Integer> distance = new HashMap<>();
    Set<String> dictionary;
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        dictionary = new HashSet<>(wordList);
        if(!dictionary.contains(endWord))
            return result;
        
        List<String> solution = new ArrayList<>();
        
        dictionary.add(beginWord);
        // 广度优先搜索构建图模型
        bfs(beginWord, endWord);
        // 深度优先搜索获取所有路径
        dfs(beginWord, endWord, solution);
        
        return result;
    }
    
    // 获取当前字符串改变一个字符后且在字典中的字符串集合
    public List<String> getNeighbors(String current) {
        List<String> neighbors = new ArrayList<>();
        char ch[] = current.toCharArray();
        for(char c = 'a'; c <= 'z'; c++) {
            for(int i = 0; i < ch.length; i++) {
                if(ch[i] == c)
                    continue;
                char oldChar = ch[i];
                ch[i] = c;
                if(dictionary.contains(String.valueOf(ch)))
                    neighbors.add(String.valueOf(ch));
                ch[i] = oldChar;
            }
        }
        
        return neighbors;
    }
    
    public void bfs(String start, String end) {
        for(String str : dictionary)
            nodeNeighbors.put(str, new ArrayList<String>());
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);
        
        while(!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for(int i = 0; i < count; i++) {
                String current = queue.poll();
                int currentDistance = distance.get(current);
                List<String> neighbors = getNeighbors(current);
                
                for(String neighbor : neighbors) {
                    nodeNeighbors.get(current).add(neighbor);
                    if(!distance.containsKey(neighbor)) {
                        distance.put(neighbor, currentDistance + 1);
                        if(end.equals(neighbor))
                            foundEnd = true;
                        else
                            queue.offer(neighbor);
                    }
                }
            }
            
            if(foundEnd)
                break;
        }
    }
    
    public void dfs(String current, String end, List<String> solution) {
        solution.add(current);
        if(end.equals(current))
            result.add(new ArrayList<String>(solution));
        else {
            for(String neighbor : nodeNeighbors.get(current)) {
                if(distance.get(neighbor) == distance.get(current) + 1)
                    dfs(neighbor, end, solution);
            }
        }
        solution.remove(solution.size() - 1);
    }
}
