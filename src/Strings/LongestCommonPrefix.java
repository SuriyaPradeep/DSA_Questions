package Strings;

import java.util.Arrays;

/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        int n= strs.length;
        if(n==0){
            return "";
        }
        StringBuilder s=new StringBuilder();
        Arrays.sort(strs);
        String s1=strs[0],s2=strs[n-1];
        for(int i=0;i<Math.min(s1.length(),s2.length());i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            if(c1==c2){
                s.append(c1);
                continue;
            }
            break;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String[] s1={"flower","flow","flight"},s2={"dog","racecar","car"};
        System.out.println(longestCommonPrefix(s1));//"fl"
        System.out.println(longestCommonPrefix(s2));//""
    }
}
