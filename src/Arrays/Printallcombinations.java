package Arrays;
import java.util.Arrays;
public class Printallcombinations {
    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void printCombination(int[] arr, int r) {
        // A temporary array to store all combination one by one
        int[] data = new int[r];
        int n= arr.length;

        // Sort array to handle duplicate   s
        Arrays.sort(arr);

        // Print all combinations using temporary array 'data[]'
        combinationUtil(arr, n, r, 0, data, 0);
    }

    /* arr[]  ---> Input Array
       n      ---> Size of input array
       r      ---> Size of a combination to be printed
       index  ---> Current index in data[]
       data[] ---> Temporary array to store the current combination
       i      ---> Index of the current element in arr[] */
    static void combinationUtil(int[] arr, int n, int r, int index, int[] data, int i) {
        // Current combination is ready, print it
        if (index == r) {
            System.out.println(Arrays.toString(data));
            return;
        }

        // When no more elements are there to be put
        if (i >= n)
            return;

        // Current element is included, put the next element at the next location
        data[index] = arr[i];
        combinationUtil(arr, n, r, index + 1, data, i + 1);

        // Remove duplicates
        while (i < n - 1 && arr[i] == arr[i + 1])
            i++;

        // Current element is excluded, replace it with the next (Note that
        // i+1 is passed, but index is not changed)
        combinationUtil(arr, n, r, index, data, i + 1);
    }

    public static void main(String[] args) {
        int[] arr1={1,2,3,4};
        int r1=2;
        printCombination(arr1,r1);
        /*
        1 2
        1 3
        1 4
        2 3
        2 4
        3 4
         */
        System.out.println();
        int[] arr2={1, 2, 1, 3, 1};
        int r2=3;
        printCombination(arr2,r2);
        /*
        1 1 1
        1 1 2
        1 1 3
        1 2 3 
         */
    }
}
