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
/*
Explanation:

To solve this problem efficiently, we need to use a clever approach.
Instead of directly trying to find all subarrays whose sum is exactly equal to the goal, which can be difficult to manage with just a sliding window (especially when the array contains zeros), we'll use a different strategy.

We'll count:

The number of subarrays with a sum less than or equal to the goal.
The number of subarrays with a sum less than or equal to (goal - 1).
By subtracting the second count from the first, we'll get the number of subarrays whose sum is exactly equal to the goal.
This trick allows us to avoid edge cases and works well with a sliding window approach.

how will get it the sub-array count

101
10
101
01

3 count

we can get direct from length of window
right-left + 1;

* */

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
