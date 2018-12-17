package dp;
//dp[i][j] 代表 走到（i，j）点的路径数        dp[i][j] = dp[i-1][j] + dp[i][j-1]      dp[0][0] = 1;
public class Unique_Paths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
