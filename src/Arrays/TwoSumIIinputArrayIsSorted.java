package Arrays;

import java.util.Arrays;
import java.util.NoSuchElementException;

/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.
 */
public class TwoSumIIinputArrayIsSorted {
    public static int[] twoSum(int[] numbers, int target) {
        int n=numbers.length,l=0,r=n-1;
        while (l<r){
            int sum=numbers[l]+numbers[r];
            if(sum==target){
                return new int[]{l+1,r+1};
            } else if (sum>target) {
                while (numbers[r]!=numbers[r--]){
                    r--;
                }
            }else {
                while (numbers[l]!=numbers[l++]){
                    l++;
                }
            }
        }
        throw new NoSuchElementException("Their are no such pairs that add to give sum of "+target);
    }
    public static void main(String[] args) {
        int[] arr1={2,7,11,15},arr2={2,3,4},arr3={-1,0},arr4={1,2,3};
        int target1=9,target2=6,target3=-1,target4=6;
        System.out.println(Arrays.toString(twoSum(arr1, target1)));//[1,2]
        System.out.println(Arrays.toString(twoSum(arr2, target2)));//[1,3]
        System.out.println(Arrays.toString(twoSum(arr3, target3)));//[1,2]
        System.out.println(Arrays.toString(twoSum(arr4, target4)));//Error
    }
}
