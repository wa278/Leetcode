package dp;
//dp[i] = Math.max(dp[i-1]+num[i],num[i]) dp[i]为以I为结尾的数组    起始条件是dp[0] = num[i]
public class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum = Math.max(sum+nums[i],nums[i]);
            max = Math.max(max,sum);
        }
        return max;
    }
}
