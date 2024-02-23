package Arrays;

import java.util.HashSet;
/*
Given an array A[] of n numbers and another number x,
the task is to check whether or not there exist two elements in A[] whose sum is exactly x.
 */
public class CheckifpairwithgivenSumexistsinArray {
    //Two Sum using hashmap
    //Two pointers can also be used
    private static boolean chkPair(int[] nums, int sum){
        HashSet<Integer> hash=new HashSet<>();
        for (int num : nums) {
            int compliment = sum - num;
            if (hash.contains(compliment)) {
                return true;
            }
            hash.add(num);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr1={0, -1, 2, -3, 1};
        int sum1=2;
        int[] arr2={1, -2, 1, 0, 5};
        int sum2=0;
        System.out.println(chkPair(arr1,sum1));//true
        System.out.println(chkPair(arr2,sum2));//false
    }
}
