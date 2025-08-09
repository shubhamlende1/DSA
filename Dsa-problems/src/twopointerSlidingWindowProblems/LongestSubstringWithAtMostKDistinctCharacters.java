package twopointerSlidingWindowProblems;

/*
In this problem, we are given a string s and an integer k. Our task is to find the length of the longest substring (which is a contiguous block of characters in the string) within s that contains at most k distinct characters.

A distinct character means that no matter how many times the character appears in the substring, it is counted only once. For example, if k = 2, the substring "aabbc" has 3 distinct characters ('a', 'b', and 'c'), thus, it does not meet the requirement.

The goal here is to achieve this while maximizing the length of the substring. A substring could range from containing a single character up to the length of the entire string, if k is sufficiently large to cover all distinct characters in the string s.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.

* */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

    public static int atMostKDistinct(String str, int k) {
        int left = 0, right = 0 , maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (right < str.length()) {
            map.put(str.charAt(right), map.getOrDefault(str.charAt(right), 0) + 1);

            if(map.size() > k) {
                int count = map.getOrDefault(str.charAt(left), 0) - 1;
                if(count == 0) {
                    map.remove(str.charAt(left));
                } else {
                    map.put(str.charAt(left), count);
                }
                left++;
            }

                int len = right - left + 1;
                maxLength = Math.max(maxLength, len);
            right++;
        }

        return maxLength;
    }
    public static void main(String[] args) {

        System.out.println(atMostKDistinct("eceba", 2));
    }
}
