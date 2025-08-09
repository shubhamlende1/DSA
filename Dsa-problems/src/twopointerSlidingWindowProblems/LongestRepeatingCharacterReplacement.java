package twopointerSlidingWindowProblems;

/*

424. Longest Repeating Character Replacement

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.



Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.

* */
/*
A frequency array count[26] to store the frequency of each uppercase English letter in the current window.
Two pointers: left = 0, right = 0 to represent the sliding window.
A variable maxFreq = 0 to keep track of the maximum frequency of a single character in the window.
A variable maxLength = 0 to store the result.

While right is less than the length of the string:

a. Include character at right in the window:

Increment the frequency of s[right] in the count array.
Update maxFreq as the maximum of maxFreq and count[s[right]].
b. Check window validity:
Calculate windowLength = right - left + 1.
If windowLength - maxFreq <= k, it means we can replace at most k characters to make all characters in the window the same → valid window.
c. If the window is valid:
Update maxLength = max(maxLength, windowLength).
d. If the window is invalid:
Shrink the window from the left by:
Decrementing the frequency of s[left] in the count array.
Moving left one step to the right.
e. Move right pointer one step to the right.


Return maxLength after the loop ends.

* */
public class LongestRepeatingCharacterReplacement {
    public static  int characterReplacement(String s, int k) {
        int maxLength = 0;

        int left = 0, right = 0;
        int maxFreq = 0;
        int [] arr = new int[26];
        while (right < s.length()) {

            arr[s.charAt(right)-'A']++;
            maxFreq = Math.max(maxFreq, arr[s.charAt(right)-'A']);

            int len = right - left + 1;

            if((len - maxFreq) <= k){
                maxLength = Math.max(maxLength, len);
            } else {
                maxFreq = 0;
                arr[s.charAt(left)-'A']--;
                left++;
            }
            right++;
        }
        return  maxLength;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABABBAAAA", 2));
    }
}
