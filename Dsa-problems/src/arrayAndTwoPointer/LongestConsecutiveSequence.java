package arrayAndTwoPointer;

import java.util.HashSet;
import java.util.Set;

/*

128. Longest Consecutive Sequence

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Example 3:

Input: nums = [1,0,1,2]
Output: 3


* */
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
           if(!set.contains(num-1)) {
               int cnt = 1;
               int temp = num;
               while (set.contains(temp + 1)) {
                   temp++;
                   cnt++;
               }
               longest = Math.max(longest, cnt);
           }
        }

        return  longest;
    }

    public static void main(String[] args) {

        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
