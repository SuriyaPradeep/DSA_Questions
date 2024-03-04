package Arrays;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.
 */
public class PermutationinString {
    public static boolean checkInclusion(String s1, String s2) {
        int l1=s1.length(),l2=s2.length();
        Map<Character,Integer> count=new HashMap<>();
        for(int i=0;i<l1;i++){
            char c=s1.charAt(i);
            count.put(c,count.getOrDefault(c,0)+1);
        }
        int matches=0;
        for(int i=0;i<l2;i++){
            char c=s2.charAt(i);
            if(count.containsKey(c)){
                count.put(c,count.get(c)-1);
                if(count.get(c)==0){
                    matches++;
                }
            }
            if(i>=l1){
                c=s2.charAt(i-l1);
                if(count.containsKey(c)){
                    if(count.get(c)==0){
                        matches--;
                    }
                    count.put(c,count.get(c)+1);
                }
            }
            if(matches==count.keySet().size()){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s1="ab",s2="eidboaoo";
        checkInclusion(s1,s2);
        System.out.println(checkInclusion(s1,s2));//false
        s1="ab";
        s2="eidbaooo";
        System.out.println(checkInclusion(s1,s2));//true
    }
}