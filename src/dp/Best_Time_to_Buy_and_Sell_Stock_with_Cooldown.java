package dp;

//hold[i] 代表第i天持有的收益 reset[i]表示第i天冷却时的收益.sell[i]表示第i天卖出的收益。
/*
hold[i] = Max(hold[i-1],reset[i-1] - prices[i])
reset[i] = Max(reset[i-1],sell[i-1])
sell[i] = hold[i-1] + prices[i]
 */
public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] hold = new int[prices.length];
        int[] reset = new int[prices.length];
        int[] sell = new int[prices.length];
        hold[0] = -1 * prices[0];
        sell[0] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            hold[i] = Math.max(reset[i - 1] - prices[i], hold[i - 1]);
            reset[i] = Math.max(reset[i - 1], sell[i - 1]);
            sell[i] = hold[i - 1] + prices[i];
        }
        return Math.max(sell[prices.length - 1], reset[prices.length - 1]);
    }

    public static void main(String[] args) {
        int[] prices = {1};
        System.out.println(new Best_Time_to_Buy_and_Sell_Stock_with_Cooldown().maxProfit(prices));
    }
}
