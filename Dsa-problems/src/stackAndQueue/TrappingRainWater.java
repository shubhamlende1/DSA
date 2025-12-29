package stackAndQueue;

/*
42. Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9

* */
public class TrappingRainWater {
    // space O(2N)
    public static int trap1(int[] height) {
        int count = 0;
        int []leftMax = new int[height.length];
        int []rightMax = new int[height.length];

        leftMax[0] = height[0];
        for (int i=1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i -1]);
        }

        rightMax[height.length - 1] = height[height.length -1];
        for (int i= height.length -2;  i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i  + 1]);
        }

        for (int i = 0 ; i< height.length; i++) {
            if(height[i] < leftMax[i] && height[i] < rightMax[i]) {
                int val = Math.min(leftMax[i], rightMax[i]) - height[i];
                count+=val;
            }
        }

        return count;
    }

    // approach 2 with space O(1)
    public static int trap2(int[] height) {
        int count = 0;
        int left  = 0, right = height.length -1;
        int leftMax = 0 ; int rightMax = 0;

        while (left < right) {

            if(height[left] <= height[right]) {
                if(leftMax > height[left]) {
                    count+= leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if(rightMax > height[right]) {
                    count+=rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return count;
    }
    public static void main(String[] args) {

        System.out.println(trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}

