package Arrays;
/*
Given an array arr[] of distinct elements size N that is sorted and then rotated around an unknown point,
the task is to check if the array has a pair with a given sum X.
 */
public class FindifthereisapairwithagivensumintherotatedsortedArray {
    private static boolean findPair(int[] arr,int sum){
        /*
        11,15,6,8,9,10
        n=6
        pivot=2,left=2,right=1
        1st Iteration
        sum=15+6=21
        21>16
        right=(1-1+6)%6=0
        2nd Iteration
        sum=(11+6)=17
        17>16
        right=(0-1+6)=5%6=5
        3rd Iteration
        sum=10+6=16
        16==16
        */
        int n= arr.length,pivot=0;
        /*
1. Find the pivot element in the rotated sorted array. If the pivot element is greater than the first element of the array, then the pivot lies in the second half of the array; otherwise, it lies in the first half of the array.
2. After finding the pivot element, initialize two pointers left and right at the start and end of the array, respectively.
3. Loop through the array and check if the sum of the elements at the left and right pointers is equal to the given sum. If it is, then return true.
4. If the sum is less than the given sum, increment the left pointer, else decrement the right pointer.
5. If the loop completes and no pair is found, return false.
         */
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                pivot=i+1;
                break;
            }
        }
        int left=pivot,right=pivot-1;
        while (left != right) {
            int s=arr[left]+arr[right];
            if(s==sum){
                return true;
            }else if(s<sum){
                left=(left+1)%n;
            }else {
                right=(right-1+n)%n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {11, 15, 6, 8, 9, 10};
        int x = 16;
        System.out.println(findPair(arr, x));//true
        arr = new int[]{11, 15, 26, 38, 9, 10};
        x = 35;
        System.out.println(findPair(arr, x));//true
        arr = new int[]{11, 15, 26, 38, 9, 10};
        x = 45;
        System.out.println(findPair(arr, x));//false
    }
}
