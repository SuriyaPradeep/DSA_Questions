package Arrays;

import java.util.Arrays;

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int n=nums.length-1;
        k=k%nums.length;
        reverse(nums,0,n);
        reverse(nums,0,k-1);
        reverse(nums,k,n);

    }
    private static void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr1={1,2,3,4,5,6,7},arr2={-1};
        int k1=3,k2=2;
        rotate(arr1,k1);
        rotate(arr2,k2);
        System.out.println(Arrays.toString(arr1));//[5, 6, 7, 1, 2, 3, 4]
        System.out.println(Arrays.toString(arr2));//[-1]
    }
}
