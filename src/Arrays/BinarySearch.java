package Arrays;
/*
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearch {
    private static int search(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            int value=nums[mid];
            if(value==target){
                return mid;
            }else if(value>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1={-1,0,3,5,9,12},arr2={-1,0,3,5,9,12};
        int target1=9,target2=2;
        System.out.println(search(arr1,target1));//4
        System.out.println(search(arr2,target2));//-1
    }
}
