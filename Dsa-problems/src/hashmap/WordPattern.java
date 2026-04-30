package hashmap;

import java.util.*;

/*
290. Word Pattern
Easy

Topics
premium lock icon
Companies
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.


Example 1:

Input: pattern = "abba", s = "dog cat cat dog"

Output: true

Explanation:

The bijection can be established as:

'a' maps to "dog".
'b' maps to "cat".
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"

Output: false

Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"

Output: false


* */
public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        String[] arr = s.split(" ");

        if(arr.length != pattern.length())
            return false;
        for (int i =0; i< pattern.length(); i++) {
            char current = pattern.charAt(i);

            if(!map.containsKey(current) && !set.contains(arr[i])) {
                map.put(current,arr[i]);
                set.add(arr[i]);
            } else if (!arr[i].equals(map.get(current))) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;
        char [] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);

        return String.valueOf(s1).equals(String.valueOf(s2));
    }
    public boolean isAnagram1(String s, String t) {

        int[] hash = new int[26];

        for (int i =0; i< s.length();i++)
            hash[s.charAt(i) - 'a']++;
        for (int i =0; i< t.length();i++)
            hash[t.charAt(i) - 'a']--;

        for (int j : hash)
            if (j > 1)
                return false;

        return true;
    }
    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat dog"));
    }
}
