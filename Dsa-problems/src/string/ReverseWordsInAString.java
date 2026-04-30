package string;

import java.util.Arrays;

/*
151. Reverse Words in a String
Medium

Topics
premium lock icon
Companies
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.



Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

* */
public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
                res.append(arr[i]).append(" ");
        }

        return res.toString().trim();
    }

    public static String reverseWords2(String s) {
        StringBuilder res = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // skip spaces
            while (i >= 0 && s.charAt(i) == ' ') i--;

            if (i < 0) break;

            int j = i;

            // find start of word
            while (i >= 0 && s.charAt(i) != ' ') i--;

            // append the word
            res.append(s, i + 1, j + 1).append(" ");
        }

        return res.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
}
