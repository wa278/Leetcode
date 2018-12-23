package dp;

//dp[i] 代表第i个数字中1的个数。    dp[i] = dp[i-2(log2 (i))向下取整]+1
public class Counting_Bits {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        if (num == 0) {
            return dp;
        }
        int k = 0;
        int m = 2;
        dp[1] = 1;
        for (int i = 2; i <= num; i++) {
            dp[i] = 1 + dp[k++];
            if (k == m) {
                m *= 2;
                k = 0;
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        Counting_Bits x = new Counting_Bits();
        int[] dp = x.countBits(1);
    }
}
