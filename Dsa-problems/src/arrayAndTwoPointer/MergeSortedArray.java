package arrayAndTwoPointer;

import java.util.Arrays;

public class MergeSortedArray {
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int[] res = new int[m+n];
        int index = 0;

        int num1Index = 0, num2Index=0;

        while (num1Index < m && num2Index < n) {

            if(nums1[num1Index] <= nums2[num2Index]) {
                res[index++] = nums1[num1Index++];
            } else {
                res[index++] = nums2[num2Index++];
            }
        }
        while (num1Index < m) {
            res[index++] = nums1[num1Index++];
        }

        while (num2Index < n) {
            res[index++] = nums2[num2Index++];
        }
        return res;
    }

    // without extra space
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {

        int finalIndex = nums1.length -1;
        int num1Index = m -1;
        int nums2Index = n -1;

        while (num1Index >=0 && nums2Index>=0) {

            if(nums1[num1Index] < nums2[nums2Index]) {
                nums1[finalIndex--] = nums2[nums2Index--];
            } else {
                nums1[finalIndex--] = nums1[num1Index--];
            }
        }

        while (nums2Index >= 0) {
            nums1[finalIndex--] = nums2[nums2Index--];
        }
    }
    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3,0,0,0};
        int [] arr2 = new int[]{2,5,6};
//        System.out.println(Arrays.toString(merge(arr, 3, arr2, 3)));
        merge2(arr, 3, arr2, 3);
        System.out.println(Arrays.toString(arr));
    }
}
