/*Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N.
Find the missing element.*/
public class MissingNumberInArray {
    static int  missingNumber(int[] array, int n) {
        int arraySum=0;
        //Calculate the sum of the array
        for(int i=0;i<n-1;i++){
            arraySum+=array[i];
        }
        int sum=(n*(n+1))/2;//Calculates Sum of a Series
        return sum-arraySum;
        //Can find the missing Value by finding difference between them
    }

    public static void main(String[] args) {
        int[] arr={6,1,2,8,3,4,7,10,5};
        System.out.println(missingNumber(arr,10));
    }
}
