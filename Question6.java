import java.util.*;

class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] intervals) {
        ArrayList<int[]> merged = new ArrayList<>();
        if (intervals.length == 0) return merged;
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                merged.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        
        merged.add(new int[]{start, end});
        return merged;
    }
}
