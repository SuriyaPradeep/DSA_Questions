package Strings;

import java.util.HashMap;
//Given a string S, the task is to print all the duplicate characters with their occurrences in the given string.

public class Printalltheduplicatecharactersinastring {
    private static void printDups(String str){
        HashMap<Character,Integer> hash=new HashMap<>();
        int n=str.length();
        for(int i=0;i<n;i++){
            char c=str.charAt(i);
            hash.put(c, hash.getOrDefault(c,0)+1);
        }
        for (HashMap.Entry<Character,Integer> mapElement : hash.entrySet()) {   //iterating through the unordered map
            if (mapElement.getValue() > 1)   //if the count of characters is greater than 1 then duplicate found
                System.out.println(mapElement.getKey() + ", count = " + mapElement.getValue());
        }
    }

    public static void main(String[] args) {
        String s1="geeksforgeeks",s2="test string";
        printDups(s1);
        /*
        e, count = 4
        g, count = 2
        k, count = 2
        s, count = 2
         */
        System.out.println();
        printDups(s2);
        /*
        t, count = 3
        s, count = 2
         */
    }
}
