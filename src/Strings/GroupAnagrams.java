package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        int n= strs.length;
        HashMap<String, ArrayList<String>> hash=new HashMap<>();
        for(String word:strs){
            char[] c=word.toCharArray();
            Arrays.sort(c);
            String sortWord=new String(c);
            if(!hash.containsKey(sortWord)){
                hash.put(sortWord,new ArrayList<>());
            }
            hash.get(sortWord).add(word);
        }
        return new ArrayList<>(hash.values());
    }

    public static void main(String[] args) {
        String[] str1={"eat","tea","tan","ate","nat","bat"},str2={""},str3={"a"};
        System.out.println(groupAnagrams(str1));//[["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(groupAnagrams(str2));//[[""]]
        System.out.println(groupAnagrams(str3));//[["a"]]
    }
}
