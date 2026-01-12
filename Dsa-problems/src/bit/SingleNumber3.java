package bit;

import java.util.Arrays;

/*
260. Single Number III

Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.



Example 1:

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.
Example 2:

Input: nums = [-1,0]
Output: [-1,0]
Example 3:

Input: nums = [0,1]
Output: [1,0]
* */
public class SingleNumber3 {
    public static int[] singleNumber(int[] nums) {
        long xor = 0;

        // removed all common and then xor will have only unique elements
        for (int num: nums)
            xor = xor ^ num;

        System.out.println(xor);
/*
        3 ^ 5
        xor value is 6
         0110

         xor & ~ (xor -1)
         0110 & 1010 = 0010

         find out the rightmost bit
*/


        long rightmost = xor & -xor;


        int b1 = 0, b2 = 0;
        for (int num: nums) {
            if((num & rightmost) != 0)
                b1 = b1 ^ num;
            else
                b2 = b2^ num;
        }

        return new int[]{b1,b2};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
