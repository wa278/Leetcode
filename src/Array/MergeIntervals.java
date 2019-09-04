package Array;

import java.util.*;

/**
 * Created by wa941 on 2018/5/30.
 * 排序 collections.sort()
 * 取右值要取两个区间的最大值，因为排序只按左值排列。
 */
public class MergeIntervals {

    private class myComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0] > o2[0]) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> result = new LinkedList<>();
        Arrays.sort(intervals, new myComparator());
        for (int i = 0; i < intervals.length; i++) {
            if (result.isEmpty()) {
                result.add(intervals[i]);
            } else {
                if (((LinkedList<int[]>) result).getLast()[0] <= intervals[i][0] &&
                        ((LinkedList<int[]>) result).getLast()[1] >= intervals[i][0]) {
                    int[] x = {((LinkedList<int[]>) result).getLast()[0],
                            Math.max(((LinkedList<int[]>) result).getLast()[1], intervals[i][1])};
                    ((LinkedList<int[]>) result).removeLast();
                    result.add(x);
                } else {
                    result.add(intervals[i]);
                }
            }
        }
        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}

