package twopointerSlidingWindowProblems;

/*
1423. Maximum Points You Can Obtain from Cards

There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.



Example 1:

Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
Example 2:

Input: cardPoints = [2,2,2], k = 2
Output: 4
Explanation: Regardless of which two cards you take, your score will always be 4.
Example 3:

Input: cardPoints = [9,7,7,9,7,7,9], k = 7
Output: 55
Explanation: You have to take all the cards. Your score is the sum of points of all cards.

*/

/*
Explanation
We will begin with the first window of size K, starting from the beginning of the array.
Since we can select any window of size K either from the left or the right,
we will compute the total sum based on all possible combinations of left and right subarrays.

Step 1: Calculate the sum of the initial left window of size K.

Then, we will gradually reduce the size of the left window and add elements from the right side,
updating the total sum accordingly for each combination.
 */

public class MaximumPointsYouCanObtainFromCards {
    public static  int maxScore(int[] cardPoints, int k) {

        int leftSum=0 ,  rightSum=0 , maxSum = 0;

        for(int i = 0 ; i< k ; i++)
            leftSum+=cardPoints[i];

        maxSum = leftSum+rightSum;
        int rightIndex = cardPoints.length - 1;
        for(int i = k - 1 ; i >= 0 ; i--) {
            leftSum-=cardPoints[i];
            rightSum+=cardPoints[rightIndex];
            rightIndex--;
            maxSum = Math.max(maxSum,leftSum+rightSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {1,2,3,4,5,6,1};
        int[] nums = new int[] {9,7,7,9,7,7,9};
        int k = 7;
        System.out.println(maxScore(nums,k));
    }
}
