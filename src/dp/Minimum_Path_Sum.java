package dp;
//dp[i][j] 代表到i,j的最小和 。 dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j]      起始条件是dp[0][0] = grid[0][0]
public class Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < n; i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i = 1; i < m; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j]= Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] x = {{1,2},{5,6},{1,1}};
        Minimum_Path_Sum a = new Minimum_Path_Sum();
        a.minPathSum(x);
    }
}
