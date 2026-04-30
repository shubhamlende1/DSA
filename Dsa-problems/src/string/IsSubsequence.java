package string;

/*
392. Is Subsequence
Easy

Topics
premium lock icon
Companies
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false

* */
public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        char [] sA = s.toCharArray();
        char [] tA = t.toCharArray();
        int j=0;

        if(sA.length == 0)
            return true;

        for(int i = 0 ; i< t.length() && j < s.length(); i++) {
            if(sA[j] == tA[i]) {
                j++;
            }

        }

        return j >= s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("axc","ahbgdc"));
    }
}
