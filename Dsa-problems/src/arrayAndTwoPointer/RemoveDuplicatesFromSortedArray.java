package arrayAndTwoPointer;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int index = 1;
        int element = nums[0];
        for (int  i = 1 ; i < nums.length; i++){
            if(nums[i] != element) {
                nums[index++] = nums[i];
                element = nums[i];
            }
        }

        return index;
    }

    public static void main(String[] args) {

        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
