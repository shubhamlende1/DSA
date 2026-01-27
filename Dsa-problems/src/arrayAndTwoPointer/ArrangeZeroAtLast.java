package arrayAndTwoPointer;

import java.util.Arrays;

public class ArrangeZeroAtLast {
    public static int[] arrangeZeroAtLast(int[] arr) {
        int i = 0 , j = 0;
        while (j <  arr.length) {
            if(arr[j] != 0){
                arr[i++] = arr[j];
            }
            j++;
        }

        while (i < arr.length) {
            arr[i++] = 0;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrangeZeroAtLast(new int[]{1, 0, 0, 2, 3, 4, 0, 0, 9, 0})));
    }
}
