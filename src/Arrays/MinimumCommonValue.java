package Arrays;
/*
Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.
Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.
 */
public class MinimumCommonValue {
    public static int getCommon(int[] nums1, int[] nums2) {
        int i=0,j=0;
        int n1=nums1.length;
        int n2= nums2.length;
        if (nums1[n1-1] < nums2[0] || nums2[n2-1] < nums1[0])
            return -1;
        while(i<n1 && j<n2){
            if(nums1[i]==nums2[j]){
                return nums1[i];
            }else if(nums1[i]<nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1={1,2,3},arr2={2,4},arr3={5,6,7};
        System.out.println(getCommon(arr1,arr2));//2
        System.out.println(getCommon(arr1,arr3));//-1
    }
}
