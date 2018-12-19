package dp;

public class Perfect_Squares {
    public int numSquares(int n) {
        double x = Math.sqrt(n);
        int a = (int) Math.floor(x);
        int[] nums = new int[a];
        for (int i = 0; i < a; i++) {
            nums[i] = (i + 1) * (i + 1);
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < a; i++) {
            for (int j = nums[i]; j <= n; j++) {
                dp[j] = Math.min(dp[j - nums[i]] + 1, dp[j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Perfect_Squares x = new Perfect_Squares();
        System.out.println(x.numSquares(15));
    }
}
