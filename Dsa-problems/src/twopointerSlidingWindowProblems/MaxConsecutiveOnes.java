package twopointerSlidingWindowProblems;

/*
1004. Max Consecutive Ones III

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

* */

/*
Explanation:
To use the sliding window technique, we start with two pointers: left and right, both at position 0. This creates our initial window of size 1.
As we go through the array, we move the right pointer to the right to expand the window. If we see a 1, we just keep going. If we see a 0,
we increase our zero count. Since we are allowed to flip at most K zeros to 1, we need to make sure the number of zeros inside the window doesn’t go over K.

If the zero count becomes more than K, it means we’ve used too many flips. So, we start moving the left pointer forward to shrink the window from the left.
While doing this, if we move past a 0, we decrease the zero count as well. We keep shrinking until the zero count is back within the allowed limit.

Once we’re within the limit again, we can continue moving the right pointer and repeat this process until we reach the end of the array.
* */
public class MaxConsecutiveOnes {
    public static int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, maxLength = 0;
        int zeroCount = 0;
        while (right < nums.length) {

            if(nums[right] == 0){
                zeroCount++;
            }

            if(zeroCount > k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
                int len =  right - left + 1;
                maxLength = Math.max(maxLength, len);
                right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int []nums = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(nums,3));
    }
}
