package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
 */
public class IntersectionofTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for(int num:nums1){
            set.add(num);
        }
        for(int num:nums2){
            if(set.contains(num)){
                intersect.add(num);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1={1,2,2,1},arr2={2,2};
        System.out.println(Arrays.toString(intersection(arr1,arr2)));//[2]
        int[] arr3={4,9,5},arr4={9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(arr3,arr4)));//[4, 9]
    }
}
