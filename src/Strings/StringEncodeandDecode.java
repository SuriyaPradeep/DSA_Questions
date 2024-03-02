package Strings;
import java.util.*;
/*
Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
Please implement encode and decode
 */
public class StringEncodeandDecode {
    public static String encode(List<String> strs){
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length()).append("#").append(str);
        }
        return encodedString.toString();
    }
    public static List<String> decode(String str){
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;

            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1 + length;
            list.add(str.substring(j + 1, i));
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> strs1 = new ArrayList<>(Arrays.asList("neet", "code", "love", "you"));
        String encoded=encode(strs1);
        System.out.println(encoded);
        List<String> decoded=decode(encoded);
        System.out.println(decoded);
    }
}
