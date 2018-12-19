package dp;

/*
dp[i]代表以i为结尾的连续数组的最大乘积。 dp[i] = Math.max(max*nums[i],nums[i],min*nums[i])
 */
public class Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int mulmax = nums[0];
        int mulmin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = mulmax;
            int y = mulmin;
            mulmax = Math.max(nums[i], Math.max(x * nums[i], y * nums[i]));
            mulmin = Math.min(nums[i], Math.min(x * nums[i], y * nums[i]));
            max = Math.max(max, mulmax);
            min = Math.min(min, mulmin);
        }
        return max;
    }

    public static void main(String[] args) {
        Maximum_Product_Subarray x = new Maximum_Product_Subarray();
        int[] nums = {-4, -3, -2};
        System.out.println(x.maxProduct(nums));
    }
}
