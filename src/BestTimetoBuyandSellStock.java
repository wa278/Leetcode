//kadan 算法     dp 算法  max = 之前的dp 或者 dp[i]          dp[i] 即以i为结尾的子数组 = 之前的dp[i-1] + n(I) 或者n(i)
//构造收益数组
//(c - b) + (b - a) = c - a
//每段的收益累加起来 就是总的收益

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length <2){
            return 0;
        }
        int[] income = new int[prices.length];
        for(int i =1 ; i < prices.length;i++){
            income[i] = prices[i] - prices[i-1];
        }
        income[0] = 0;
        return maxSub(income);
    }
    public int maxSub(int[] income){
        int max = income[0];
        int sub = income[0];
        for(int i = 1; i < income.length;i++){
            sub = Math.max(sub+income[i],income[i]);
            max = Math.max(max,sub);
        }
        return max;
    }
}
