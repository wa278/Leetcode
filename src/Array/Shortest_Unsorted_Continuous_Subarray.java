package Array;

import java.util.Arrays;

public class Shortest_Unsorted_Continuous_Subarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int min = nums.length - 1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copy[i]) {
                min = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != copy[i]) {
                max = i;
                break;
            }
        }
        return max - min > 0 ? max - min + 1 : 0;
    }

    public static void main(String[] args) {
        Shortest_Unsorted_Continuous_Subarray x = new Shortest_Unsorted_Continuous_Subarray();
        int[] input = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(x.findUnsortedSubarray(input));
    }
}
