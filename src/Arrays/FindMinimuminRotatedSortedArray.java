package Arrays;
/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
Given the sorted rotated array nums of unique elements, return the minimum element of this array.
You must write an algorithm that runs in O(log n) time.
 */
public class FindMinimuminRotatedSortedArray {
    //Can be achieved using modifying binary search
    public static int findMin(int[] nums) {
        int n=nums.length;
        //If only single element present
        if(n==1){
            return nums[0];
        }
        int low=0,high=n-1;
        //While loop till high is greater
        while(low<high){
            int mid=(low+high)/2;
            if(mid>0 && nums[mid]<nums[mid-1]){
                //In Array [3,1,2]
                //1 is smaller than 3 return 1
                return nums[mid];
            }
            //Check if nums[mid]>=nums[low] && nums[mid]>nums[high] increase low to mid+1
            //Eg Array[3,4,5,1,2] mid is 5 condition true make low point to 1
            if(nums[mid]>=nums[low] && nums[mid]>nums[high]){
                low=mid+1;
            }//if condition is false then decrease high to mid-1
            //Eg Array[11,13,15,17] mid is 15 first condition is true 15>=13
            //Second is false 15>17 so make high point to 13
            else{
                high=mid-1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] arr1={3,4,5,1,2};
        int[] arr2={4,5,6,7,0,1,2};
        int[] arr3={11,13,15,17};
        int[] arr4={1};
        int[] arr5={3,1,2};
        System.out.println(findMin(arr1));//1
        System.out.println(findMin(arr2));//0
        System.out.println(findMin(arr3));//11
        System.out.println(findMin(arr4));//1
        System.out.println(findMin(arr5));//1
    }
}
