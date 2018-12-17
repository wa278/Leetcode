package dp;
//dp[i][j] 表示 从i到j是否是回文的      dp[i][j] = dp[i+1][j-1] && s[i]==s[j]       起始条件是 1 dp[i][i] == true 2 dp[i][i+1] = s[i] == s[i+1]
public class Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        //dp算法 o(n2) 54 ms
        if (s == null || s.length() == 0) {
            return s;
        }
        int min = 0;
        int max = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (j - i < 2) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
                if (dp[i][j]) {
                    if (j - i + 1 > max - min + 1) {
                        max = j;
                        min = i;
                    }
                }
            }
        }
        return s.substring(min, max + 1);
    }

    public static void main(String[] args) {
        String s = "bananas";
        Longest_Palindromic_Substring x = new Longest_Palindromic_Substring();
        System.out.println(x.longestPalindrome(s));
    }
}

//我第一次的做法 18 ms
//        if (s == null || s.length() == 0) {
//            return s;
//        }
//        int min = 0;
//        int max = 0;
//        int lo = 0;
//        int hi = 0;
//        while (hi < s.length()) {
//            if (lo == hi) {
//                while (hi + 1 < s.length() && s.charAt(hi) == s.charAt(hi + 1)) {
//                    hi++;
//                }
//            } else {
//                if (lo - 1 >= 0 && s.charAt(hi) == s.charAt(lo - 1)) {
//                    lo--;
//                } else {
//                    int mid = (hi + lo) / 2;
//                    while (mid + 1 < s.length() && s.charAt(mid) == s.charAt(mid + 1)) {
//                        mid++;
//                    }
//                    lo = mid + 1;
//                    hi = mid + 1;
//                    continue;
//                }
//            }
//            if (hi - lo + 1 > max - min + 1) {
//                max = hi;
//                min = lo;
//            }
//            hi++;
//        }
//        return s.substring(min, max + 1);


//Expand Around Center //21ms

//    public String longestPalindrome(String s) {
//        if (s == null || s.length() < 1) return "";
//        int start = 0, end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int len1 = expandAroundCenter(s, i, i);
//            int len2 = expandAroundCenter(s, i, i + 1);
//            int len = Math.max(len1, len2);
//            if (len > end - start) {
//                start = i - (len - 1) / 2;
//                end = i + len / 2;
//            }
//        }
//        return s.substring(start, end + 1);
//    }
//
//    private int expandAroundCenter(String s, int left, int right) {
//        int L = left, R = right;
//        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
//            L--;
//            R++;
//        }
//        return R - L - 1;
//    }



