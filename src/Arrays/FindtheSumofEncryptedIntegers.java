package Arrays;
/*
You are given an integer array nums containing positive integers. We define a function encrypt such that encrypt(x) replaces every digit in x with the largest digit in x. For example, encrypt(523) = 555 and encrypt(213) = 333.
Return the sum of encrypted elements.
Example 1:
Input: nums = [1,2,3]
Output: 6
Explanation: The encrypted elements are [1,2,3]. The sum of encrypted elements is 1 + 2 + 3 == 6.
Example 2:
Input: nums = [10,21,31]
Output: 66
Explanation: The encrypted elements are [11,22,33]. The sum of encrypted elements is 11 + 22 + 33 == 66.
 */
public class FindtheSumofEncryptedIntegers {
    public static int sumOfEncryptedInt(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=encrypt(num);
        }
        return sum;
    }
    private static int encrypt(int num){
        String str=Integer.toString(num);
        char max='0';
        for(char c:str.toCharArray()){
            max=(char)Math.max(max,c);
        }
        return Integer.parseInt(new String(new char[str.length()]).replace('\0',max));
    }

    public static void main(String[] args) {
        int[] arr1={1,2,3},arr2={10,21,31};
        System.out.println(sumOfEncryptedInt(arr1));//6
        System.out.println(sumOfEncryptedInt(arr2));//66
    }
}
