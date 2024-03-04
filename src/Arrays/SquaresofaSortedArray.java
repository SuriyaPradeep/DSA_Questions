package Arrays;

import java.util.Arrays;
/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
 */
public class SquaresofaSortedArray {
    public static int[] sortedSquares(int[] nums) {
        int n= nums.length,l=0,r=n-1,index=n-1;
        int[] arr=new int[n];
        while (l<=r){
            int lNum=Math.abs(nums[l]),rNum=Math.abs(nums[r]);
            if(lNum>=rNum){
                arr[index--]=(int)Math.pow(lNum,2);
                l++;
            }else{
                arr[index--]=(int)Math.pow(rNum,2);
                r--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr1={-4,-1,0,3,10},arr2={-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(arr1)));//[0,1,9,16,100]
        System.out.println(Arrays.toString(sortedSquares(arr2)));//[4,9,9,49,121]
    }
}
