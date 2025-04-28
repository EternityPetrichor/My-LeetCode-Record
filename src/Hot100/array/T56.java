package Hot100.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class T56 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 9}, {2, 5},{19,20},{10,11},{0,3},{0,1}})));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        int n = intervals.length;
        int i = 0;
        List<int[]> ranges = new ArrayList<>(n);
        while(i < n){
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j = i + 1;
            while(j < n && intervals[j][0] <= end){
                end = Math.max(end, intervals[j++][1]);
            }
            ranges.add(new int[]{start, end});
            i = j;
        }
        return ranges.toArray(new int[ranges.size()][]);
    }
}
