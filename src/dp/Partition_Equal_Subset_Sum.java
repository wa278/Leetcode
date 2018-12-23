package dp;

/*
dp[i][j] 代表前i个数能否组成j。
dp[i][j] = true if dp[i-1][j-nums[i]]==true
         = true if(dp[i-1][j] == true)
         = false;
         起始条件 dp[0][0] = true;
 */
public class Partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {
        int m = nums.length;
        int sum = 0;
        for (int e : nums) {
            sum += e;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum = sum / 2;
        boolean[][] dp = new boolean[m + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }
            }
        }
        return dp[m][sum];
    }

    public static void main(String[] args) {
        int[] nums = {2};
        System.out.println(new Partition_Equal_Subset_Sum().canPartition(nums));
    }
}
