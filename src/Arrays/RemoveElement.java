package Arrays;
/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.
 */
public class RemoveElement {
    public static void printArray(int[] arr,int k){
        for(int i=0;i<k;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static int removeElement(int[] nums, int val){
        int l=0;
        for(int r=0;r< nums.length;r++){
            if(nums[r]!=val){
                swap(l++,r,nums);
            }
        }
        return l;
    }
    private static void swap(int i,int j,int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args) {
        int[] arr1={3,2,2,3},arr2={0,1,2,2,3,0,4,2};
        int val1=3,val2=2;
        int k1=removeElement(arr1,val1),k2=removeElement(arr2,val2);
        System.out.println(k1);//2
        System.out.println(k2);//5
        printArray(arr1,k1);//[2,2,_,_]
        printArray(arr2,k2);//[0,1,4,0,3,_,_,_]
    }
}
