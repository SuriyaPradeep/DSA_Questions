package Arrays;

import java.util.Arrays;

/*
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.
 */
public class NextPermutation {
    private static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private static void reverse(int[] arr,int start,int end){
        while(start<end){
            swap(arr,start++,end--);
        }
    }
    /*
    To find next permutations
    Initialize variables n=n.length pivot=-1
    first we find pivot point such that arr[i]<arr[i+1] where i is n-2 n is length
    then i is pivot point then break pivot
    if pivot<0 then there is no pivot sequence is already the greatest then just reverse the array
    else
        find first number greater than pivot value in right side of pivot
        swap pivot and the least great number
        than reverse array from pivot+1 to end
     */
    private static void nextPermutation(int[] nums){
        int n= nums.length,pivot=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                pivot=i;
                break;
            }
        }
        if(pivot<0){
            reverse(nums,0,n-1);
        } else{
            for(int i=n-1;i>pivot;i--){
                if(nums[i]>nums[pivot]){
                    swap(nums,pivot,i);
                    break;
                }
            }
            reverse(nums,pivot+1,n-1);
        }
    }

    public static void main(String[] args) {
        int[] arr={3,2,1};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));//1,2,3
        arr= new int[]{1, 2, 3};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));//1,3,2
        arr= new int[]{1,3,5,4,2};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));//1,4,2,3,5
    }
}
