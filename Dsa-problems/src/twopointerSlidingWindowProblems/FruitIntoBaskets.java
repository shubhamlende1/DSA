package twopointerSlidingWindowProblems;

import java.util.HashMap;
import java.util.Map;

/*

904. Fruit Into Baskets

You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.



Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].

* */

/*
* Explanation
We have two baskets that can each hold only one type of fruit, meaning we can store at most two distinct types of fruits at a time.
* To keep track of the fruits in each basket, we'll use a map (or hash map) to record the count of each fruit type in the current window.
We'll apply the sliding window technique using two pointers: left and right, both starting at index 0, with an initial window size of one.

As we move the right pointer forward, we'll add the current fruit to the basket (i.e., update the map).
*  If the number of distinct fruits (i.e., the size of the map) exceeds two, we'll shrink the window from the left side—removing fruits and
* updating the map—until the basket contains only two types again.

We'll update the maximum window size during each iteration, and continue this process until the right pointer reaches the end of the array.
* */
public class FruitIntoBaskets {

    public static int totalFruit(int[] fruits) {
        int left = 0, right = 0 , maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            if(map.size() > 2) {
                int count = map.getOrDefault(fruits[left], 0) - 1;
                if(count == 0) {
                    map.remove(fruits[left]);
                } else {
                    map.put(fruits[left], count);
                }
                 left++;
            }

                int len = right - left + 1;
                maxLength = Math.max(maxLength, len);
                right++;

        }
        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println(totalFruit(new int[]{2,3,2,2}));
    }
}
