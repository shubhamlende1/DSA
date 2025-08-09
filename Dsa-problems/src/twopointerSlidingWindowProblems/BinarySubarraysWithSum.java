package twopointerSlidingWindowProblems;

/*
930. Binary Subarrays With Sum

Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.



Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15

* */
/**/

public class BinarySubarraysWithSum {
    public static  int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int left = 0, right = 0;
        int sum = 0;
        while (right < nums.length) {

            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            count = count + (right - left + 1);
            right++;

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
        System.out.println(numSubarraysWithSum(new int[]{1,0,1,0,1}, 2 - 1));

    }
}
