/*
Given an array A of size N of integers.
Your task is to find the sum of minimum and maximum element in the array.
 */
public class MaxMin {
    public static int findSum(int[] arr,int N)
    {
        int min=arr[0],max=arr[0];
        for(int i=1;i<N;i++){
            //Find min and max in array using linear search
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min+max;
    }

    public static void main(String[] args) {
        int[] arr={-2, 1, -4, 5, 3};
        System.out.println(findSum(arr,5));//OP:1
    }
}
