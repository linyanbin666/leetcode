package com.horizon.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * leetcode56.
 * title: 合并区间。面向对象编程，辅助空间都算是一个突破口，思维要放宽
 * level: medium
 * @author Horizon
 *
 * @Date 2019年4月28日下午8:25:22
 */
public class LeetCode56 {
	
	class Interval {
		int start;
		int end;
		public Interval(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}
	
	public int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return intervals;
		// 排序
		Arrays.sort(intervals, (o1, o2) -> o1[0] > o2[0] ? 1 : (o1[0] < o2[0] ? -1 : 0));
		ArrayList<Interval> list = new ArrayList<>();
		int start = intervals[0][0], end = intervals[0][1];
		list.add(new Interval(start, end));
		for (int i = 1; i < intervals.length; i++) {
			start = intervals[i][0];
			end = intervals[i][1];	
			Interval interval = list.get(list.size() - 1);
			if (interval.end < start) {
				list.add(new Interval(start, end));
			} else {
				// 重叠
				interval.end = Math.max(interval.end, end);
			}
		}
		int[][] res = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			Interval interval = list.get(i);
			res[i][0] = interval.start;
			res[i][1] = interval.end;
		}
		return res;
	}
	
}
