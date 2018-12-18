package dp;

//dp[i] 表示找零i元的最小硬币数量。 起始条件为dp[i] = 1 当i ：coins
//dp[i] = Min (dp[i-coins[j] +1) if i-coins[j] >0 && dp[i-coins[j]] >0
//      = 1  if i- coins[j] == 1
public class Coin_Change {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (coins == null || coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] == 0) {
                    dp[i] = 1;
                } else if (i - coins[j] > 0 && dp[i - coins[j]] > 0) {
                    dp[i] = dp[i] == 0 ? dp[i - coins[j]] + 1 : Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Coin_Change x = new Coin_Change();
        int[] coins = {83, 186, 408, 419};
        System.out.println(x.coinChange(coins, 6249));
    }
}
