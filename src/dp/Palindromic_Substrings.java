package dp;

//dp[i][j] 代表从i到j是不是回文的。   dp[i][j] = true  if dp[i+1][j-1]==true
//起始条件 dp[i][i] = true    dp[i][i+1] = true if s[i]==s[j]
public class Palindromic_Substrings {
    public int countSubstrings(String s) {
        int m = s.length();
        boolean[][] dp = new boolean[m][m];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            dp[i][i] = true;
            sum++;
        }
        for (int i = 0; i + 1 < m; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                sum++;
            }
        }
        for (int i = 2; i < m; i++) {
            for (int j = m - 1 - i; j >= 0; j--) {
                if (s.charAt(j) == s.charAt(j + i)) {
                    dp[j][j + i] = dp[j + 1][j + i - 1];
                    sum = dp[j][j + i] ? sum + 1 : sum;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Palindromic_Substrings().countSubstrings("abc"));
    }
}
