package dp;

import javax.annotation.processing.SupportedSourceVersion;

//dp[i] 代表i个数的二叉搜索树的种类。 起始条件 dp[1] = 1.
// 递推公式  dp[i] = 2dp[i-1] + dp[j]dp[i-j-1] j = 1, 2,...,i-2
public class Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] += 2 * dp[i - 1];
            for (int j = 1; i - j - 1 > 0; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Unique_Binary_Search_Trees x = new Unique_Binary_Search_Trees();
        System.out.println(x.numTrees(4));
    }
}
/*
选择1到n中一节点作为根节点，计算左边有多少二叉树，右边有多少二叉树。
public class Solution {
  public int numTrees(int n) {
    int[] G = new int[n + 1];
    G[0] = 1;
    G[1] = 1;

    for (int i = 2; i <= n; ++i) {
      for (int j = 1; j <= i; ++j) {
        G[i] += G[j - 1] * G[i - j];
      }
    }
    return G[n];
  }
}
 */