package dp;

//dp[i][j] 代表第i个w1和第j个w2之间的最小距离。
/*
dp[i][j] = if(w1[i] == w2[j])      Min(dp[i-1][j]+1, dp[i][j-1] +1, dp[i-1][j-1])
           if(w1[i] != w2[j])      Min(dp[i-1][j]+1, dp[i][j-1] +1, dp[i-1][j-1] +1)
 */
public class Edit_Distance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int j = 1; j <= m; j++) {
            dp[j][0] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
