package dp;

//dp[i][j] 代表再加入第i个数以后，和为j的种类。
public class Target_Sum {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int e : nums) {
            sum += e;
        }
        int[][] dp = new int[nums.length][2 * sum + 1];
        if (S > sum || S < -1 * sum) {
            return 0;
        }
        if (nums.length == 0) {
            if (S == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (nums[0] == 0) {
            dp[0][sum + nums[0]] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= 2 * sum; j++) {
                if (j - nums[i] >= 0) {
                    dp[i][j - nums[i]] += dp[i - 1][j];
                }
                if (j + nums[i] <= 2 * sum) {
                    dp[i][j + nums[i]] += dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][sum + S];
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,0,0,1};
        System.out.println(new Target_Sum().findTargetSumWays(nums, 1));
    }
}
