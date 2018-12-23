package dp;
//dp[i][j] 代表从i到j个气球的最大收益。
/*
dp[i][j] = Math.max(dp[i][k-1] + dp[k+1][j] + nums[i-1]*nums[k] * nums[j+1])
 */

public class Burst_Balloons {
    public int maxCoins(int[] nums) {
        int[] balloons = new int[nums.length + 2];
        balloons[0] = 1;
        balloons[nums.length + 1] = 1;
        for (int i = 1; i <= nums.length; i++) {
            balloons[i] = nums[i - 1];
        }
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j + i <= nums.length; j++) {
                for (int k = j; k <= j + i; k++) {
                    dp[j][j + i] = Math.max(dp[j][j + i], dp[j][k - 1] + dp[k + 1][j + i] + balloons[j - 1] * balloons[k] * balloons[j + i + 1]);
                }
            }
        }
        return dp[1][nums.length];
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(new Burst_Balloons().maxCoins(nums));
    }
}
