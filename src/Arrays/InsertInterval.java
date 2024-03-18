package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
Return intervals after the insertion.
Note that you don't need to modify intervals in-place. You can make a new array and return it.
Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

 */
public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]>results=new ArrayList<>();
        for(int[] interval:intervals){
            if(newInterval[1]<interval[0]){
                results.add(newInterval);
                newInterval=interval;
            }else if(interval[1]<newInterval[0]){
                results.add(interval);
            }else{
                newInterval[0]=Math.min(newInterval[0],interval[0]);
                newInterval[1]=Math.max(newInterval[1],interval[1]);
            }
        }
        results.add(newInterval);
        return results.toArray(new int[results.size()][]);
    }

    public static void main(String[] args) {
        int[][]intervals1={{1,3},{6,9}},intervals2={{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval1={2,5},newInterval2={4,8};
        System.out.println(Arrays.deepToString(insert(intervals1,newInterval1)));//[[1,5],[6,9]]
        System.out.println(Arrays.deepToString(insert(intervals2,newInterval2)));//[[1,2],[3,10],[12,16]]
    }
}
