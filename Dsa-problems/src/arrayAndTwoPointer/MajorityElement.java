package arrayAndTwoPointer;

/*

169. Majority Element

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2

* */
public class MajorityElement {

    public static  int majorityElement(int[] nums) {
        int count = 0;
        int element = nums[0];
        for(int i = 0 ; i< nums.length ; i++) {

            if(count == 0){
                count = 1;
                element = nums[i];
            } else if(nums[i] == element){
                count++;
            } else {
                count--;
            }
       }
        count  = 0;
        for(int i = 0 ; i< nums.length ; i++) {
            if(nums[i] == element){
                count++;
            }
        }

        if(count > nums.length/2){
            return element;
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
