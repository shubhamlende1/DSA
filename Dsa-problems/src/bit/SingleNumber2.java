package bit;

/*
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99

* */

/*
Solution
1. Time Complexity : O(32*N)

2. Time Complexity : O(N)
* */
public class SingleNumber2 {

    public static int singleNumberSolution1(int[] nums) {
        int res = 0;
        for (int i =0 ; i< 32; i++) {
            int count = 0;
            for (int num: nums) {
                count += num & (1 << i);
            }

            if(count % 3 != 0) {
                res = res | (1 << i);
            }
        }
        return res;
    }

    public static int singleNumberSolution2(int[] nums) {
        int ones = 0, twos = 0;

        for (int num: nums) {
            ones = ones ^ num &  ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        System.out.println(singleNumberSolution2(new int[]{0,1,0,1,0,1,99}));
    }
}
