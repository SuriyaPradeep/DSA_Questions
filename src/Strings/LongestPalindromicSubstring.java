package Strings;
/*
Given a string s, return the longest palindromic substring in s.
 */
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0, start = 0;

        for (int i = 0; i < n; i++) {
            int len1 = expandAroundCenter(s, i, i);//odd palindrome
            int len2 = expandAroundCenter(s, i, i + 1);//even palindrome
            int len = Math.max(len1, len2);

            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLen);
        // we add start to maxLen is to retrieve the end index of the longest palindromic substring.
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while ((L >= 0 && R < s.length()) && (s.charAt(L) == s.charAt(R))) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        String s1="babad",s2="cbbd",s3="abcd",s4="adlwlbbbbq";
        System.out.println(longestPalindrome(s1));//bab or aba
        System.out.println(longestPalindrome(s2));//bb
        System.out.println(longestPalindrome(s3));//"a"
        System.out.println(longestPalindrome(s4));//"bbbb"
    }
}
