package com.horizon.shuxue;
/**
 * x的平方根
 * @author Horizon
 *
 * 2019年3月21日上午10:07:41
 */
import org.junit.Test;

public class LeetCode69 {
	// leetcode题
	public int mySqrt(int x) {
		if (x == 1) {
			return x;
		}
		double low = 0, high = x;
		double mid = (low + high) / 2;
		while (high - low > 1e-6) {
			if (mid * mid > x) {
				high = mid;
			} else if (mid * mid < x) {
				low = mid;
			} else {
				break;
			}
			mid = (low + high) / 2;
		}
		long intMid = (long) mid;
		if (intMid * intMid <= x && (intMid + 1) * (intMid + 1) > x) {
			return (int) intMid;
		} else {
			return (int) intMid + 1;
		}
		
	}

	/**
	 * @Title: 扩展leetcode的题
	 * @Description: 二分求x的平方根，要求精确到@param{precision}位
	 * @param x double类型，表示待求平方根的数
	 * @param precision 精度
	 */
	public double mySqrt(double x, double precision) {
		if (x < 0) {
			return Double.NaN;
		}
		double low = 0, high = x;
		if (x > 0 && x < 1) {
			low = x;
			high = 1;
		}
		double mid = (low + high) / 2;
		while (high - low > precision) {
			if (mid * mid > x) {
				high = mid;
			} else if (mid * mid < x) {
				low = mid;
			} else {
				return mid;
			}
			mid = (low + high) / 2;
		}
		return mid;
	}
	
	/**
	 * @Titile: 扩展
	 * @Description: 牛顿迭代法求x的平方根
	 * @param x 待求解的数
	 * @param precision 精度
	 * @return
	 */
	public double mySqrt2(double x, double precision) {
		if (x < 0) {
			return Double.NaN;
		}
		double res = 1.0;
		while (Math.abs(res * res - x) > 1e-6) {
			res = (res + x / res) / 2;
		}
//		double x1 = 0, x2 = 1;
//		while (Math.abs(x1 - x2) > 1e-6) {
//			x1 = x2;
//			x2 = x1 / 2 + x / (2 * x1);
//		}
//		return x1;
		return res;
	}

	@Test
	public void test() {
		System.out.println(mySqrt(2147483647));
		System.out.println(mySqrt(36, 1e-6));
		System.out.println(mySqrt2(0.25, 1e-6));
	}
}
