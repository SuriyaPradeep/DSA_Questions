package Strings;
/*
Given a string s consisting only of characters 'a', 'b', and 'c'. You are asked to apply the following algorithm on the string any number of times:

Pick a non-empty prefix from the string s where all the characters in the prefix are equal.
Pick a non-empty suffix from the string s where all the characters in this suffix are equal.
The prefix and the suffix should not intersect at any index.
The characters from the prefix and suffix must be the same.
Delete both the prefix and the suffix.
Return the minimum length of s after performing the above operation any number of times (possibly zero times).
 */
public class MinimumLengthofStringAfterDeletingSimilarEnds {
    public static int minimumLength(String s) {
        char[] cs=s.toCharArray();
        int left=0,right=cs.length-1;
        while (left<right){
            if(cs[left]!=cs[right]){
                break;
            }
            char c=cs[left];
            while (left<=right && cs[left]==c ){
                left++;
            }
            while (left<=right && cs[right]==c ){
                right--;
            }
        }
        return right-left+1;
    }

    public static void main(String[] args) {
        String s1="ca",s2="cabaabac",s3="aabccabba";
        System.out.println(minimumLength(s1));//2
        System.out.println(minimumLength(s2));//0
        System.out.println(minimumLength(s3));//3
    }
}
