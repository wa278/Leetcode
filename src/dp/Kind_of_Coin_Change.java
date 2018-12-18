package dp;
// dp[i][j] 代表在加入第i个硬币之后j有多少种找零方法 。 其实条件是 dp[i][0] = 1;dp[0][j]可以计算出来。
/*
dp[i][j] = if j-coins[i] >=0 dp[i][j] = dp[i-1][j] + (dp[i][j-coins[i]]+1)
           else dp[i][j] = dp[i-1][j]
 */
public class Kind_of_Coin_Change {
    public int coinChange(int[] coins, int amount) {
        if(amount < 0){
            return -1;
        }
        if(coins == null || coins.length == 0){
            return -1;
        }
        int m = coins.length;
        int n = amount+1;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for (int i = 1; i <= amount; i++) {
            if (amount % coins[0] == 0) {
                dp[0][i] = 1;
            }
        }
        for(int i = 1; i < m; i ++){
            for(int j = 1; j <= amount; j++){
                if(j -coins[i] >=0){
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i]];
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[m-1][amount] ==0 ? -1:dp[m-1][amount];
    }

    public static void main(String[] args) {
        Kind_of_Coin_Change x = new Kind_of_Coin_Change();
        int[] coins= {1,2,5};
        System.out.println(x.coinChange(coins,11));
    }
}
