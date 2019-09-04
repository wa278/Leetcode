package dp;

//dp[i] 代表第i个数字中1的个数。    dp[i] = dp[i/2] + i%2;
public class Counting_Bits {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        if (num == 0) {
            return dp;
        }
        for(int i = 1; i < num+1; i++){
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

    public static void main(String[] args) {
        Counting_Bits x = new Counting_Bits();
        int[] dp = x.countBits(1);
    }
}

/*
public int[] countBits(int num) {
    int[] f = new int[num + 1];
    for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
    return f;
}
 */