/**
 * Created by wa941 on 2018/5/29.
 */
public class MaximumSubarray {
    /*
    kadan's algorithm          O(n)
    i 位置的最大子数组和要么是i为结尾的数组和 要么是不以i为结尾的数组和。
    以i 为结尾的数组和 是Max(num[i],以i-1为结尾的数组和 + num[i])
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i< nums.length ; i++){
            sum = Math.max(nums[i],sum + nums[i]); // 以i为结尾的最大子数组
            max = Math.max(max,sum); // 不以i为结尾 和以i为结尾 取最大值
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {8,-19,5,-4,20};
        maxSubArray(nums);
    }
}
