package Strings;

import java.util.HashMap;

/*
 Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.
 */
public class RomantoInteger {
    public static int romanToInt(String s) {
        HashMap<Character,Integer>hash=new HashMap<>();
        hash.put('I',1);
        hash.put('V',5);
        hash.put('X',10);
        hash.put('L',50);
        hash.put('C',100);
        hash.put('D',500);
        hash.put('M',1000);
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(i<s.length()-1 && hash.get(s.charAt(i))<hash.get(s.charAt(i+1))){
                ans-=hash.get(s.charAt(i));
            }else{
                ans+=hash.get(s.charAt(i));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String str1="III",str2="LVIII",str3="MCMXCIV";
        System.out.println(romanToInt(str1));//3
        System.out.println(romanToInt(str2));//58
        System.out.println(romanToInt(str3));//1994
    }
}
