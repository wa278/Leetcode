package Array;

import java.util.Arrays;
//全排列问题 从后至前找到不按递减排序的数字，与其后 比其稍大的数字交还， 对其后所有数字排序。
public class Next_Permutation {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                for (int j = nums.length - 1; j > i - 1; j--) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        Arrays.sort(nums, i, nums.length);
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 5};
        Next_Permutation x = new Next_Permutation();
        x.nextPermutation(nums);
        for (int e : nums) {
            System.out.print(e + " ");
        }
    }
}
