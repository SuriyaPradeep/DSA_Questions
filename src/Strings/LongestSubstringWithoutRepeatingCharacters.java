package Strings;

import java.util.HashMap;

/*
Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
       int len=0;
       HashMap<Character,Integer> hash=new HashMap<>();
       for(int i=0,j=0;i<s.length();i++){
           if(hash.containsKey(s.charAt(i))){
               j=Math.max(j, hash.get(s.charAt(i))+1);
           }
           hash.put(s.charAt(i),i);
           len=Math.max(len,i-j+1);
       }
       return len;
    }

    public static void main(String[] args) {
        String s1="abcabcbb",s2="pwwkew",s3="bbbbb",s4="";
        System.out.println(lengthOfLongestSubstring(s1));//3
        System.out.println(lengthOfLongestSubstring(s2));//3
        System.out.println(lengthOfLongestSubstring(s3));//1
        System.out.println(lengthOfLongestSubstring(s4));//0
    }
}
