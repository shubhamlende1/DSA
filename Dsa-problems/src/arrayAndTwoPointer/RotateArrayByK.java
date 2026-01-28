package arrayAndTwoPointer;

import java.util.Arrays;

public class RotateArrayByK {
    private static void rotateArray(int[] nums, int i , int  j) {
        while(i < j/2){
            int temp = nums[i];
            nums[i] = nums[j-1-i];
            nums[j-1-i] = temp;
            i++;
        }

    }
    public static void rotate(int[] nums, int k) {
        rotateArray(nums, 0, nums.length);

        rotateArray(nums, 0, k);
        rotateArray(nums, k, nums.length+k);

        System.out.println(Arrays.toString(nums));
    }


    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }
}
