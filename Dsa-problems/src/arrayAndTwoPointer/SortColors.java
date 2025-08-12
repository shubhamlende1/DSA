package arrayAndTwoPointer;

/*

75. Sort Colors

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]

* */

/*
 Explanation :

To achieve a time complexity of O(n) instead of using any built-in sorting algorithm (which typically takes O(n log n)),
 we can solve the problem using the Dutch National Flag Algorithm with three pointers:
low – handles 0s
mid – handles 1s
high – handles 2s
Initialization:
low and mid both start at index 0
high starts at the last index of the array
Logic:
If arr[mid] == 1: just move the mid pointer forward (mid++)
If arr[mid] == 0: swap arr[mid] with arr[low], then increment both low and mid
If arr[mid] == 2: swap arr[mid] with arr[high], then decrement high (do not move mid)
This approach ensures all elements are sorted in a single traversal with linear time complexity.
* */
public class SortColors {

    public static void sortColors(int[] nums) {
        int low = 0 , mid = 0 , high = nums.length - 1;

        while (mid <= high) {
            if(nums[mid] == 0) {
                swap(nums, low++, mid++);
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, high--, mid);
            }
        }


        for(int i = 0 ; i< nums.length ; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {

        sortColors(new int[]{0,1,1,0,1,2,0,0,2});
    }
}
