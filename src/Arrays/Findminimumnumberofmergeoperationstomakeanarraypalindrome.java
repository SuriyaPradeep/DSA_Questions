package Arrays;
/*
Given an array of positive integers. We need to make the given array a ‘Palindrome’. The only allowed operation is”merging” (of two adjacent elements). Merging two adjacent elements means replacing them with their sum.
The task is to find the minimum number of merge operations required to make the given array a ‘Palindrome’.
Input : arr[] = {15, 4, 15}
Output : 0
Array is already a palindrome. So we
do not need any merge operation.
Input : arr[] = {1, 4, 5, 1}
Output : 1
We can make given array palindrome with
minimum one merging (merging 4 and 5 to
make 9)
Input : arr[] = {11, 14, 15, 99}
Output : 3
We need to merge all elements to make
a palindrome.
 */
public class Findminimumnumberofmergeoperationstomakeanarraypalindrome {
    private static int findMinOps(int[] arr){
        int n= arr.length,ans=0;
        /*
        1, 4, 5, 1
        here i and j are pointer pointing to values in array from start and end
        Start of loop i=1,j=1,ans=0
        i==j i++ j--
        i=4,j=5
        i<j i++ arr[i]+=arr[i-1] ie 4+5=9 ans++
        i=9,j=9
        i==j i++ j--
        now i<=j false exit loop
        return ans
        */
        for(int i=0,j=n-1;i<=j;){
            if(arr[i]==arr[j]){
                i++;
                j--;
            } else if (arr[i]>arr[j]) {
                j--;
                arr[j]+=arr[j+1];
                ans++;
            }else{
                i++;
                arr[i]+=arr[i-1];
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1={15, 4, 15};
        int[] arr2={11, 14, 15, 99};
        int[] arr3={1, 4, 5, 1};
        System.out.println(findMinOps(arr1));//0
        System.out.println(findMinOps(arr2));//3
        System.out.println(findMinOps(arr3));//1
    }
}
