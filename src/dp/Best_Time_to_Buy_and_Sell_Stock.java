package dp;
//dp[i] 代表第i天卖出的收益  起始条件 dp[0] = 0   dp[i] = Math.max (dp[i-1] + ( p[i] - p[i-1]),0); 0就是不买卖。 如果非要一买一卖，Math.max (dp[i-1] + ( p[i] - p[i-1]),p[i] - p[i-1])
public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int max = 0;
        int profit = 0;
        for(int j = 1; j < prices.length;j++){
            profit = Math.max(profit+prices[j]-prices[j-1],0);
            max = Math.max(max,profit);
        }
        return max;
    }
}
