package Strings;

import java.util.HashMap;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Example 1:
Input: s = "anagram", t = "nagaram"
Output: true
 */
public class ValidAnagram {
    private static boolean isAnagramHash(String a,String b){
        HashMap<Character,Integer> hash=new HashMap<>();
        for(char x:a.toCharArray()){
            hash.put(x,hash.getOrDefault(x,0)+1);
        }
        for(char x:b.toCharArray()){
            hash.put(x,hash.getOrDefault(x,0)-1);
        }
        for(int value: hash.values()){
            if(value!=0){
                return false;
            }
        }
        return true;
    }
    private static boolean isAnagramArray(String a,String b){
        int[] record=new int[26];
        for(int i=0;i<a.length();i++){
            record[a.charAt(i)-'a']++;
        }
        for(int i=0;i<b.length();i++){
            record[b.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(record[i]!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "anagram", t1 = "nagaram",s2 = "rat", t2 = "car";
        System.out.println(isAnagramHash(s1,t1));//true
        System.out.println(isAnagramHash(s2,t2));//false
        System.out.println(isAnagramArray(s1,t1));//true
        System.out.println(isAnagramArray(s2,t2));//false
    }
}
