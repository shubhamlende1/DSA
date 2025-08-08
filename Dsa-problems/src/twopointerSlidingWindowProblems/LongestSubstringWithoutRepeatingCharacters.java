package twopointerSlidingWindowProblems;

import java.util.Arrays;

/**
 3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

**/

public class LongestSubstringWithoutRepeatingCharacters {

    /*
    TC: O(n*n)
    SC:O(255)
    * */
    public static int lengthOfLongestSubstringWithoutSlidingWindow(String s) {
        int maxLength = 0;
        for (int i= 0 ; i < s.length() ; i++) {
            int [] hash = new int[255];
            for (int j = i ; j < s.length() ; j++) {
                if(hash[s.charAt(j)] == 1){
                    break;
                }
                hash[s.charAt(j)]++;
                int len = j - i + 1;
                maxLength = Math.max(maxLength, len);
            }
        }
        return maxLength;
    }

    /*
    TC: O(n)
    SC:O(255)

    Explanation:
    To use the sliding window technique, we first initialize two pointers, left and right, both starting at index 0.
    The initial window size is considered to be 1.
    We will use a hash map (or array) to track the last seen index of each character.
    This helps us detect if a character is repeating within the current window.

    We then start iterating through the string using the right pointer. For each character, we check if it has already been seen and whether
    its last seen index lies within the current window (i.e., between left and right). If it does, that means there's a repetition, and
    we need to move the left pointer to one position after the last seen index of that repeating character to form a new valid window.

    After handling duplicates, we update the character's latest index in the hash map and calculate the current window size (right - left + 1).
    We keep track of the maximum window size found during the iteration.

    This process continues until we've processed the entire string.
    * */
    public static int lengthOfLongestSubstringWithSlidingWindow(String s) {
        int l = 0 , r = 0, maxLength = 0;
        int [] hash = new int[255];
        Arrays.fill(hash, -1);
        while(r < s.length()) {
            if(hash[s.charAt(r)] != -1) {
                if(hash[s.charAt(r)] >= l) {
                    l = hash[s.charAt(r)] + 1;
                }
            }
            hash[s.charAt(r)] = r;
            int len = r - l + 1;
            maxLength = Math.max(maxLength, len);
            r++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringWithSlidingWindow("abcabcbb"));
    }
}
