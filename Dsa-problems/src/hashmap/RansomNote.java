package hashmap;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/*

383. Ransom Note
Easy

Topics
premium lock icon
Companies
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true

* */
public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        var map = Arrays.stream(ransomNote.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for(int  i= 0 ; i< magazine.length(); i++) {
            String current = String.valueOf(magazine.charAt(i));

            if(map.containsKey(current)) {
                int value = Math.toIntExact(map.get(current));
                if(value - 1 == 0) {
                    map.remove(current);
                } else {
                    map.put(current, (long) (value - 1));
                }
            }
        }
        return map.isEmpty();
    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        int [] hash = new int[26];

        if(ransomNote.length() > magazine.length())
            return false;

        for (int i=0; i< magazine.length(); i++) {
            hash[magazine.charAt(i) - 'a']++;
        }

        for (int i=0; i< ransomNote.length();i++) {
            int index = ransomNote.charAt(i) - 'a';
            hash[index]--;

            if(hash[index] < 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(canConstruct2("aa","aab"));
    }
}
