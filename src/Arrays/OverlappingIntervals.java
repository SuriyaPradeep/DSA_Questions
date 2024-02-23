package Arrays;

import java.util.Arrays;
import java.util.Comparator;

/*
Given a collection of Intervals, the task is to merge all of the overlapping Intervals.
Input:
Intervals = {{1,3},{2,4},{6,8},{9,10}}
Output: {{1, 4}, {6, 8}, {9, 10}}
Explanation: Given intervals: [1,3],[2,4]
[6,8],[9,10], we have only two overlapping
intervals here,[1,3] and [2,4]. Therefore
we will merge these two and return [1,4],
[6,8], [9,10].
 */
public class OverlappingIntervals {
    public static int[][] overlappedInterval(int[][] Intervals) {
        //Sort the array using comparator
        //Here Comparator.comparingInt(a -> a[0]) creates a comparator that compares elements based on the integer value of the first element (a[0]) of each interval (a).
        Arrays.sort(Intervals, Comparator.comparingInt(a->a[0]));
        int n=Intervals.length,index=0;
        for(int i=1;i<n;i++){
            if(Intervals[index][1]>=Intervals[i][0]){
                Intervals[index][0]=Math.min(Intervals[index][0],Intervals[i][0]);
                Intervals[index][1]=Math.max(Intervals[index][1],Intervals[i][1]);
            }else{
                index++;
                Intervals[index][0]=Intervals[i][0];
                Intervals[index][1]=Intervals[i][1];
            }
        }
        return Arrays.copyOf(Intervals,index+1);
    }
    public static void main(String[] args) {
        int[][] arr1={{1,3},{2,4},{6,8},{9,10}};
        System.out.println(Arrays.deepToString(overlappedInterval(arr1)));//[[1, 4], [6, 8], [9, 10]]
        int[][] arr2={{6,8},{1,9},{2,4},{4,7}};
        System.out.println(Arrays.deepToString(overlappedInterval(arr2)));//[[1, 9]]

    }
}
