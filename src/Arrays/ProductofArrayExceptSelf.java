package Arrays;

import java.util.Arrays;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the
elements of nums except nums[i].The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
public class ProductofArrayExceptSelf {
    public static int[] productExceptSelf1(int[] nums){
        int n= nums.length,cur=1;
        int[] ans=new int[n];
        Arrays.fill(ans,1);//Fill the array with 1
        //Forward Pass
        //Start with index 0
        //Start with multiplying cur with ans[i] with cur
        //Then multiply cur with nums[i]
        //Prefix
        for(int i=0;i<n;i++){
            ans[i]*=cur;
            cur*=nums[i];
        }
        cur=1;
        //Backward Pass
        //Start with index n-1
        //Start with multiplying cur with ans[i] with cur
        //Then multiply cur with nums[i]
        //Suffix
        for(int i=n-1;i>=0;i--){
            ans[i]*=cur;
            cur*=nums[i];
        }
        return ans;
    }
    //Calculating total product and dividing by the number to give the product excluding it
    public static int[] productExceptSelf2(int[] nums){
        int zero_count=0,prod=1,n= nums.length;
        int[] ans=new int[n];
        for(int num:nums){
            //Count Zero and calculate if only it's not zero
            if(num==0){
                zero_count++;
            }else{
                prod*=num;
            }
        }
        if(zero_count>1){
            //If there are more than one zero then entire array is zero
            return ans;
        }else if(zero_count==1){
            //If only 1 zero every value except index with 0 will be zero
            for(int i=0;i<n;i++){
                if(nums[i]==0){
                    ans[i]=prod;
                    break;
                }
            }
        }else{
            for(int i=0;i<n;i++){
                ans[i]=prod/nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1={1,1,0,-3,3};
        int[] arr2={1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf1(arr1)));//[0,0,9,0,0]
        System.out.println(Arrays.toString(productExceptSelf1(arr2)));//[24,12,8,6]
        System.out.println(Arrays.toString(productExceptSelf2(arr1)));//[0,0,9,0,0]
        System.out.println(Arrays.toString(productExceptSelf2(arr2)));//[24,12,8,6]
    }
}
