package Arrays;
/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
 */
public class RemoveDuplicatesfromSortedArray {
    public  static int removeDuplicates(int[] nums) {
        int left=0,right=1,len=1;
        for (right=1;right<nums.length;right++){
            if(nums[right]!=nums[right-1]){
                nums[++left]=nums[right];
                len++;
            }
        }
        return len;
    }
    public static void arrayIteration(int[] nums,int len){
        for(int i=0;i<len;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr1={1,1,2},arr2={0,0,1,1,1,2,2,3,3,4};
        int k1=removeDuplicates(arr1),k2=removeDuplicates(arr2);
        arrayIteration(arr1,k1);
        arrayIteration(arr2,k2);
    }
}
