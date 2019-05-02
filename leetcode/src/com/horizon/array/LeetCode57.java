package com.horizon.array;

import java.util.ArrayList;

import org.junit.Test;

/**
 * leetcode57.
 * title: 插入区间
 * level: hard
 * @author Horizon
 *
 * @Date 2019年4月28日下午8:56:32
 */
public class LeetCode57 {

	 public int[][] insert(int[][] intervals, int[] newInterval) {
			if (intervals == null || intervals.length == 0) {
				return new int[][] {newInterval};
			}
			// 二分查找找到最后一个intervals[i][0]小于newInterval[0]的位置
			int index = searchLastLessThan(intervals, newInterval);
			ArrayList<int[]> list = new ArrayList<>();
			// newInterval插入到头部
			if (index < 0) {
				list.add(new int[] {newInterval[0], newInterval[1]});
			} else {
				// 把前半部分加入list中
				for (int i = 0; i <= index; i++) {
					list.add(new int[] {intervals[i][0], intervals[i][1]});
				}
				// 将newInterval插入
				int[] inter = list.get(list.size() - 1);
				if (inter[1] < newInterval[0]) {
					list.add(new int[] {newInterval[0], newInterval[1]});
				} else {
					inter[1] = Math.max(inter[1], newInterval[1]);
				}
			}
			// 合并后半部分
			for (int i = index + 1; i < intervals.length; i++) {
				int[] inter = list.get(list.size() - 1);
				if (inter[1] < intervals[i][0]) {
					list.add(new int[] {intervals[i][0], intervals[i][1]});
				} else {
					inter[1] = Math.max(intervals[i][1], inter[1]);
				}
			}
			// 转换结果返回
			int[][] res = new int[list.size()][2];
			for (int i = 0; i < list.size(); i++) {
				res[i][0] = list.get(i)[0];
				res[i][1] = list.get(i)[1];
			}
			return res;
		}

		private int searchLastLessThan(int[][] intervals, int[] newInterval) {
			int left = 0, right = intervals.length - 1, res = -1, mid;
			while (left <= right) {
				mid = left + ((right - left) >> 1);
				if (intervals[mid][0] > newInterval[0]) {
					right = mid - 1;
				} else {
					if (mid == intervals.length - 1 || intervals[mid + 1][0] > newInterval[0]) {
						res = mid; 
						break;
					}
					left = mid + 1;
				}
			}
			return res;
		}
	
	@Test
	public void test() {
		int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int[] newInterval = {4,8};
		insert(intervals, newInterval);
	}
}
