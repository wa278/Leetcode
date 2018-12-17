package dp;
//dp[i][j] 表示 第i个s 和 第j个p匹配。 起始条件是dp[0][0] = 0。
// dp[i][j]= { 1 dp[i-1][j-1]     if p[j]== s[i]
//             2 dp[i][j-2]       if p[j] == '*'
//             3 dp[i-1][j]       if p[j] == '*' && p[j-1] == s[i]

public class Regular_Expression_Matching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] =true;
        for(int i = 1; i <= n; i++){
            if(p.charAt(i-1) =='*'){
                dp[0][i] = dp[0][i-2];
            }
        }
        for(int i = 1;i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) =='.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-2];
                    if(p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.'){
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a";
        Regular_Expression_Matching x = new Regular_Expression_Matching();
        x.isMatch(s,p);
    }
}
