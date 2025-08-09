package twopointerSlidingWindowProblems;

/*
1358. Number of Substrings Containing All Three Characters

Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.



Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
Example 3:

Input: s = "abc"
Output: 1

* */

/*
Explanation:

Initialize a count variable to 0. This will keep track of the total number of valid substrings found.

Create an array of size 3, initialized to -1.
This array will store the latest (most recent) index where each of the characters 'a', 'b', and 'c' appeared.
Let’s call this array hash, where:
hash[0] is the last index of 'a'
hash[1] is the last index of 'b'
hash[2] is the last index of 'c'

Loop through each character in the string from left to right.
For each character at index i:

Update the corresponding position in the hash array to store the current index i.
For example, if the character is 'a', set hash[0] = i
If it's 'b', set hash[1] = i
If it's 'c', set hash[2] = i

After updating the array, check if all three characters have been seen at least once.
That means all three values in the hash array should not be -1.

If all three characters have been seen:
Find the minimum value among the three indices in hash.
(This represents the earliest position where all three characters have been seen.)
Add 1 + minimum index to the count.

minimum index indicates last possibility of substring.

(Because that many substrings ending at the current index contain all three characters.)

Repeat this for every character in the string.

Return the final count after the loop ends.

* */
public class NumberOfSubstringsContainingAllThreeCharacters {

    public static int numberOfSubstrings(String s) {

        int count = 0;

        int [] hash = new int[]{-1,-1,-1};

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a'] = i;

            if(hash[0] != -1 && hash[1] != -1 && hash[2] != -1){
                count = count + 1 + (Math.min(hash[0], Math.min(hash[2], hash[1])));
            }
        }
        return  count;
    }
    public static void main(String[] args) {

        System.out.println(numberOfSubstrings("abcabc"));
    }
}
