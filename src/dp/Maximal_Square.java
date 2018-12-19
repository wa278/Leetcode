package dp;

/*
dp[i][j]代表以i为右下角的正方形对角线长度。   dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) + 1 if  dp[i][j] == 1

 */
public class Maximal_Square {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            max = dp[i][0] > max ? dp[i][0] : max;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            max = dp[0][i] > max ? dp[0][i] : max;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (dp[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
