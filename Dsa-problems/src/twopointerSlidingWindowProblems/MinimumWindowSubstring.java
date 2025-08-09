package twopointerSlidingWindowProblems;

/*
76. Minimum Window Substring

Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.

* */

/*
Explanation:

We will use the sliding window technique along with a array to track characters.
First, we'll populate the hash map with the characters from the target string.
 This will help us check whether a character exists in the target and how many times it should appear.

We'll initialize two pointers, left and right, to define the window, and start iterating through the main string using the right pointer.

As we move the right pointer, we'll decrease the count of characters in the hash map when they appear in the current window.
 We'll also keep track of how many characters have matched the required count.

Once all required characters are matched (i.e., the count matches the target length),
we'll try to shrink the window from the left to find the smallest possible window that still contains all required characters.
 During this shrinking process, we'll update the minimum length and starting index if a smaller valid window is found.
  If a character is removed from the window, we update the hash map accordingly.

We repeat this process until the right pointer reaches the end of the string. Finally,
we use the recorded starting index and minimum length to extract the desired substring.

* */
public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {

        int [] hash =  new int [256];
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]++;
        }

        int left = 0, right = 0, min = Integer.MAX_VALUE;
        int startingIndex =  -1;
        int k = t.length();
        while (right < s.length()) {

            if(hash[s.charAt(right)] > 0) {
                k--;
            }
            hash[s.charAt(right)]--;

            while(k == 0) {
                if(right-left+1 < min) {
                    min = right-left+1;
                    startingIndex = left;
                }
                hash[s.charAt(left)]++;
                if(hash[s.charAt(left)] > 0) {
                    k++;
                }
                left++;
            }

               right++;
        }
        return startingIndex == -1? "NO found": s.substring(startingIndex,startingIndex + min);
    }


    public static void main(String[] args) {
        System.out.println(minWindow("a", "aa"));
    }
}
