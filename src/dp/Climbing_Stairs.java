package dp;

//dp[i]代表到第i个台阶的数量 。  dp[i] = dp[i-1] + dp[i-2]    起始条件 dp[i]= 1 dp[2]=1
public class Climbing_Stairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 2;
        int b = 1;
        for (int i = 3; i <= n; i++) {
            int temp = a + b;
            b = a;
            a = temp;
        }
        return a;
    }
}
