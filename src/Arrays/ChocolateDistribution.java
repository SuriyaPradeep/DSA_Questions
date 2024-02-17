package Arrays;

import java.util.Arrays;

/*
Given an array of N integers where each value represents the number of chocolates in a packet.
Each packet can have a variable number of chocolates. There are m students,
the task is to distribute chocolate packets such that:
Each student gets one packet.
The difference between the number of chocolates in the packet with maximum chocolates and the packet with minimum
chocolates given to the students is minimum.
 */
public class ChocolateDistribution {
    /*
Input : arr[] = {7, 3, 2, 4, 9, 12, 56} , m = 3
Output: Minimum Difference is 2
Explanation:
We have seven packets of chocolates and we need to pick three packets for 3 students
If we pick 2, 3 and 4, we get the minimum difference between maximum and minimum packet sizes.
     */
    /*
    We first sort the array then have variable min initialize to Integer.MAX_VALUE and min_diff to 0
    Start a loop where it continues till m-1+i<n where m is number of students
    check for difference between arr[m-1+i]-arr[i]
    if difference is less than min then min=min_diff
    else do nothing
    return min after loop ended
     */
    private static int minDifference(int[] chocolates,int m){
        //m number of students
        //Sort the Array
        sort(chocolates,0, chocolates.length-1);
        int min=Integer.MAX_VALUE,min_diff=0;
        for(int i=0;(i+m-1)<chocolates.length;i++){
            min_diff=chocolates[i+m-1]-chocolates[i];
            if(min_diff<min){
                min=min_diff;
            }
        }
        return min;
    }
    private static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private static int quickSort(int[] arr,int low,int high){
        int i=low,j=high+1;
        while (i<j){
            while (arr[low]>arr[++i]){
                if(i==high){
                    break;
                }
            }
            while (arr[low]<arr[--j]){
                if(j==low){
                    break;
                }
            }
            if (i >= j){
                break;
            }
            swap(arr,i,j);
        }
        swap(arr,low,j);
        return j;
    }
    public static void sort(int[] arr,int low,int high){
        if(high>low){
            int pivot=quickSort(arr,low,high);
            sort(arr,low,pivot-1);
            sort(arr,pivot+1,high);
        }
    }

    public static void main(String[] args) {
        int[] arr={7, 3, 2, 4, 9, 12, 56};
        sort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(minDifference(arr,3));
    }
}
