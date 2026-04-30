package arrayAndTwoPointer;

import java.util.Arrays;

public class RotateArrayByK {
    private static void rotateArray(int[] nums, int start, int end) {
        end--; // make it inclusive
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void rotate(int[] nums, int k) {

        rotateArray(nums, 0, nums.length);

        rotateArray(nums, 0, k);
        rotateArray(nums, k, nums.length);

        System.out.println(Arrays.toString(nums));
    }


    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }
}
