package stackAndQueue;

import java.util.Arrays;

/*
Problem Description

You're at a party with n people labeled from 0 to n - 1. Among these people, there might be exactly one celebrity. A celebrity is defined as someone who:

Is known by all other n - 1 people at the party
Does not know any of the other people
Your task is to identify who the celebrity is, or determine that no celebrity exists at the party.

You can only gather information by asking questions in the form: "Does person A know person B?" This is done through a helper function knows(a, b) which returns true if person a knows person b, and false otherwise.

The goal is to minimize the number of questions asked (in terms of asymptotic complexity) while finding the celebrity.

The function should return:

The celebrity's label (a number from 0 to n - 1) if a celebrity exists
-1 if there is no celebrity at the party
Note that you don't have direct access to the underlying relationship graph. You can only use the knows(a, b) function to query relationships between people.

* */
public class CelebrityProblem {

    // approach  1 Time complexity : O(n*n) and Space O(2N)
    public static int findCelebrity(int [][] matrix) {
        int [] knwMe = new int[4];
        int [] iKnow = new int[4];

        for (int i=0 ; i< matrix.length; i++) {
           int count = 0;
            for (int j = 0 ; j < matrix.length; j++) {
                if(matrix[i][j] == 1){
                    knwMe[j]++;
                    count++;
                }
            }
            iKnow[i] = count;
        }

        System.out.println(Arrays.toString(knwMe));

        System.out.println(Arrays.toString(iKnow));

        for (int i = 0 ;i < matrix.length; i++) {
            if(iKnow[i] == 0 && knwMe[i] == matrix.length - 1) {
                return i;
            }
        }
        return -1;
    }

    // approach  2 Time complexity : O(n) and Space O(1)

    // simple approach
    /*
     who can be a celebrity
     everybody knows him, but he doesn't know anyone
     [top][down] can't be one if it's 1 mean top or down can't be celebrity
    * */
    public static int findCelebrity1(int [][] matrix) {
        int top = 0;
        int down = matrix.length - 1;

        while (top < down) {

            if(matrix[top][down] == 1)
                top++;
            else if (matrix[down][top] == 1) {
                down--;
            } else {
                top--;
                down--;
            }
        }

        if(top > down)
            return -1;

        return top;
    }
    public static void main(String[] args) {
        int [][] matrix = new int[][] {
                {0,1,1,1},
                {0,0,1,1},
                {0,0,0,0}, // celebrity = 2
                {0,0,1,0}
        };

        System.out.println(findCelebrity(matrix));
    }
}
