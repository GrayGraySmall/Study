package zephyr.leetcode.record;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * LeetCode 435
 *
 * 区间问题
 */
public class EraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= right) {
                ans ++;
                right = intervals[i][1];
            }
        }
        return n-ans;
    }
}
