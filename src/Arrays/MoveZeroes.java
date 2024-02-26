package Arrays;

import java.util.Arrays;

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
 */
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int n= nums.length,zero_index=0;
        for(int index=0;index<n;index++){
            if(nums[index]!=0){
                int temp=nums[index];
                nums[index]=nums[zero_index];
                nums[zero_index]=temp;
                zero_index++;
            }
        }
    }
    public static void moveZeroesOptimized(int[] nums) {
        int n= nums.length,zeros=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zeros++;
            }else if(zeros>0){
                int temp=nums[i];
                nums[i]=0;
                nums[i-zeros]=temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1={0,1,0,3,12},arr2={0};
        moveZeroes(arr1);
        moveZeroes(arr2);
        System.out.println(Arrays.toString(arr1));//[1,3,12,0,0]
        System.out.println(Arrays.toString(arr2));//[0]
        int[] arr3={0,1,0,3,12},arr4={0};
        moveZeroesOptimized(arr3);
        moveZeroesOptimized(arr4);
        System.out.println(Arrays.toString(arr3));//[1,3,12,0,0]
        System.out.println(Arrays.toString(arr4));//[0]
    }
}
