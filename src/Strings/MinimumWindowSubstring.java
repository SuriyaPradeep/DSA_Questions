package Strings;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
The testcases will be generated such that the answer is unique.
 */
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if(s==null || t==null || s.length()<t.length() || s.length()==0 || t.length()==0){
            return "";
        }
        Map<Character,Integer> count=new HashMap<>();
        for(char c:t.toCharArray()){
            count.put(c,count.getOrDefault(c,0)+1);
        }
        char[] cs=s.toCharArray();
        int start=0,startIndex=0,minLen=Integer.MAX_VALUE,match=0;
        for(int end=0;end<cs.length;end++){
            if(count.containsKey(cs[end])){
                count.put(cs[end],count.get(cs[end])-1);
                if(count.get(cs[end])==0){
                    match++;
                }
            }
            while(match==count.size()){
                if(end-start+1<minLen){
                    minLen=end-start+1;
                    startIndex=start;
                }
                char c=cs[start++];
                if(count.containsKey(c)){
                    if(count.get(c)==0){
                        match--;
                    }
                    count.put(c,count.get(c)+1);
                }
            }
        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(startIndex,minLen+startIndex);
    }

    public static void main(String[] args) {
        String s1="ADOBECODEBANC",s2="a",s3="aa";
        String t1="ABC",t2="aa",t3="aa";
        System.out.println(minWindow(s1,t1));//BANC
        System.out.println(minWindow(s2,t2));//
        System.out.println(minWindow(s3,t3));//aa
    }
}
