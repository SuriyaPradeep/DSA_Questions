package Arrays;
/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchinRotatedSortedArray {
    /*
    Need to perform an search operation on rotated array in O(log n)
    We use modified binary search to solve this problem
    initialize variables low=0 high=arr.length-1
    Start a while loop with condition low<=high
    Find mid by taking average of high and low
    if arr[mid]=target return mid
    if arr[low] is less than or equal to arr[mid].
        if arr[low] is less than and equal to target and target is less than arr[mid]
            then make high=mid-1
         else low=mid+1
     else(arr[low] is greater than arr[mid])
        if arr[high] is greater or equal to target and target greater than arr[mid]
            low=mid+1
         else high=mid-1
      if no mid-index is returned after the end of loop return -1 element not found
     */
    private static int search(int[] nums,int target){
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<nums[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(nums[high]>=target && nums[mid]<target){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2};
        int target=0;
        System.out.println(search(arr,target));//4
    }
}
