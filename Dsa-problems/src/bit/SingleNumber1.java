package bit;

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,1]

Output: 1

Example 2:

Input: nums = [4,1,2,1,2]

Output: 4

Example 3:

Input: nums = [1]

Output: 1
* */

/*
XOR Operator  (^)
XOR gives 1 when bits are different, 0 when bits are same
    Truth Table
    0 ^ 0 → 0
    0 ^ 1 → 1
    1 ^ 0 → 1
    1 ^ 1 → 0
    Example:
    a ^ 0 = a
    a ^ a = 0
    a ^ b ^ a = b
* */
public class SingleNumber1 {

    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num: nums){
            res ^=num;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,3,3,5,5,9}));
    }
}
