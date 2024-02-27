package Strings;

import java.util.HashMap;
/*
Given a sentence in the form of a string in uppercase, convert it into its equivalent mobile numeric keypad sequence. Please note there might be spaces in between the words in a sentence and we can print spaces by pressing 0.
 */
public class Convertasentenceintoitsequivalentmobilenumerickeypadsequence {
    private static String printSequence(String S) {
        HashMap<Character,String> hash=new HashMap<>();
        hash.put('A', "2");
        hash.put('B', "22");
        hash.put('C', "222");
        hash.put('D', "3");
        hash.put('E', "33");
        hash.put('F', "333");
        hash.put('G', "4");
        hash.put('H', "44");
        hash.put('I', "444");
        hash.put('J', "5");
        hash.put('K', "55");
        hash.put('L', "555");
        hash.put('M', "6");
        hash.put('N', "66");
        hash.put('O', "666");
        hash.put('P', "7");
        hash.put('Q', "77");
        hash.put('R', "777");
        hash.put('S', "7777");
        hash.put('T', "8");
        hash.put('U', "88");
        hash.put('V', "888");
        hash.put('W', "9");
        hash.put('X', "99");
        hash.put('Y', "999");
        hash.put('Z', "9999");
        hash.put(' ', "0");
        StringBuilder s=new StringBuilder();
        for(char c:S.toCharArray()){
            s.append(hash.get(c));
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String s1="GFG",s2="HEY U";
        System.out.println(printSequence(s1));//43334
        System.out.println(printSequence(s2));//4433999088
    }
}
