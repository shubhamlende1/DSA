package twopointerSlidingWindowProblems;

import java.util.HashMap;
import java.util.Map;

/*

992. Subarrays with K Different Integers

Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.



Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].

* */
public class SubarraysWithKDifferentIntegers {

    public static int subarraysWithKDistinct(int[] nums, int k) {
        int countArray = 0;
//        for (int i = 0; i < nums.length; i++) {
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int j = i; j < nums.length; j++) {
//                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
//
//                if(map.size() == k){
//                    count ++;
//                }
//                if(map.size() > k){
//                    break;
//                }
//            }
//        }

        int left =0; int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < nums.length){
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            while(map.size() >k ){
                int count = map.getOrDefault(nums[left], 0) - 1;
                if(count == 0) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], count);
                }
                left++;
            }
            countArray = countArray  + right - left + 1;
        right++;
        }
        return countArray;
    }

    public static void main(String[] args) {

        System.out.println(subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2) - subarraysWithKDistinct(new int[]{1,2,1,3,4}, 2 - 1));
    }
}
