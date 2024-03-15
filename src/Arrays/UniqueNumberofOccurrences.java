package Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 */
public class UniqueNumberofOccurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> count=new HashMap<>();
        for(int num:arr){
            count.put(num,count.getOrDefault(num,0)+1);
        }
        Set<Integer> occurrences = new HashSet<>(count.values());
        return count.size()==occurrences.size();
    }

    public static void main(String[] args) {
        int[] arr1={1,2,2,3,3,3},arr2={1,2};
        System.out.println(uniqueOccurrences(arr1));//true
        System.out.println(uniqueOccurrences(arr2));//false
    }
}
