/**
 * Created by wa941 on 2018/6/1.
 */
/*
Edit distance 又称 Levenshtein distance,是指两个字符串之间的最小距离。修改字符串有三种操作 替换，插入，删除。
此题目没有需要所有结果，只需要所有个数，应用DP解答，不是递归。
DP是通过记录数据 以及前后步骤的关系 确定出答案。
前后关系为 dp[i][j] 即从i变化到j 需要的步数和 dp[i-1][j],dp[i][j-1],dp[i-1][j]，有关。
最后得到dp[m][n]即为最小步数。
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++){
            dp[0][i] = i;
        }
        for (int i = 1; i<= m; i++){
            for(int j = 1; j <= n ; j++){
                dp[i][j] = Math.min(Math.min(dp[i-1][j] + 1,dp[i][j-1] + 1), word1.charAt(i-1) == word2.charAt(j-1)?dp[i-1][j-1]:dp[i-1][j-1] +1 );
            }
        }
        return dp[m][n];
    }
}
