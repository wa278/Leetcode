package dp;

//dp[i][j] 代表从i到j是不是回文的。   dp[i][j] = true  if dp[i+1][j-1]==true
//起始条件 dp[i][i] = true    dp[i][i+1] = true if s[i]==s[j]
public class Palindromic_Substrings {
    public int countSubstrings(String s) {
        int m = s.length();
        boolean[][] dp = new boolean[m][m];
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (j - i < 2) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                if (dp[i][j]) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Palindromic_Substrings().countSubstrings("aaa"));
    }
}
