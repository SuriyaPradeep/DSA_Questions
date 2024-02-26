package Strings;
/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.
Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while (i<=j){
            char c1=s.charAt(i);
            char c2=s.charAt(j);
            if(!Character.isLetterOrDigit(c1)){
                i++;
            } else if (!Character.isLetterOrDigit(c2)) {
                j--;
            }else{
                if(Character.toLowerCase(c1)!=Character.toLowerCase(c2)){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1="A man, a plan, a canal: Panama";
        String s2="race a car";
        String s3="";
        System.out.println(isPalindrome(s1));//true
        System.out.println(isPalindrome(s2));//false
        System.out.println(isPalindrome(s3));//true
    }
}
