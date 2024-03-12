package Strings;
/*
You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.
Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.
Return any permutation of s that satisfies this property.
 */
public class CustomSortString {
    public static String customSortString(String order, String s) {
        int[] count=new int[26];
        for(char c:s.toCharArray()){
            count[c-'a']++;
        }
        StringBuilder str=new StringBuilder();
        for(char c:order.toCharArray()){
            //use var it is a local variable that doesn't need data type
            var idx=c-'a';
            var letter_count=count[idx];
            count[idx]=0;
            if(letter_count>0){
                str.append(String.valueOf(c).repeat(letter_count));
            }
        }
        for (int i=0;i<26;i++) {
            if (count[i] > 0) {
                var ch =(char)(i+'a');
                str.append(String.valueOf(ch).repeat(Math.max(0, count[i])));
            }
        }
        return str.toString();
    }
    public static void main(String[] args) {
        String order1="cba",order2="bcafg";
        String s1="abcd",s2="abcd";
        System.out.println(customSortString(order1,s1));//cbad
        System.out.println(customSortString(order2,s2));//bcad
    }
}
