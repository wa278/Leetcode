package dp;
/*
dp[i][j] 代表第i个字符到第j个字符能否被分词。
递归公式  dp[i][j] = true  if contains s[i,j]
                   = true  if dp[i][k] &&dp[k+1][j]
                   = false else
 */

import java.util.ArrayList;
import java.util.List;

public class Word_break {
    public boolean wordBreak(String s, List<String> wordDict) {
        int m = s.length();
        boolean[][] dp = new boolean[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j + i < m; j++) {
                if (wordDict.contains(s.substring(j, j + i + 1))) {
                    dp[j][j + i] = true;
                } else {
                    for (int k = j; k < j + i; k++) {
                        if (dp[j][k] && dp[k + 1][j + i]) {
                            dp[j][j + i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][m - 1];
    }

    public static void main(String[] args) {
        Word_break x = new Word_break();
        List<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        System.out.println(x.wordBreak("ab", a));
    }
}
