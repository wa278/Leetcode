package dp;
// 1-dp算法
//dp[i] 代表以第i个为结尾的最长括号数量。起始条件 dp[i<0] = 0;
// dp[i] = 0 if s[i] = '('
//         dp[i-2]+2 if s[i] = ')' && s[i-1] ='('
//         dp[i-dp[i-1]-2] +dp[i-1] +2 if s[i-dp[i-1] -1] ='(' && s[i] = ')'
public class Longest_Valid_Parentheses{
    public int longestValidParentheses(String s){
        int max = 0;
        int[] dp = new int[s.length()];
        for(int i = 1 ; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = i-2 >=0 ? dp[i-2] +2:2;
                }
                else {
                    if(i-1-dp[i-1] >=0 && s.charAt(i-1-dp[i-1]) == '(')
                        dp[i] = i-dp[i-1] -2 >=0 ? dp[i-dp[i-1]-2]+dp[i-1] +2 : dp[i-1]+2;
                }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
        public static void main(String[] args) {
        Longest_Valid_Parentheses x = new Longest_Valid_Parentheses();
        System.out.println(x.longestValidParentheses("()(())"));
    }
}






//2-dp 算法
////dp[i][j] 代表 i,j之内的括号是否匹配 。 起始条件dp[i][i] = false, dp[i][i+1] = true if(s[i] =="[" s[i+1] =="]")
//// dp[i][j] = dp[i+1][j-1] && s[i] == "[" s[i+1] == "]"
////            dp[i][k] && dp[k][j]   dp算法想法还可以 但是时间复杂度和空间复杂度都不够好
//public class Longest_Valid_Parentheses {
//
//    public int longestValidParentheses(String s) {
//        int max = 0;
//        int m = s.length();
//        boolean[][] dp = new boolean[m][m];
//        for(int i = m-1;i >=0;i--){
//            for(int j = i; j < m; j++){
//                if(((j-i)&1 )== 1){
//                    if(j -i == 1){
//                        if(s.charAt(i)=='(' && s.charAt(j) ==')'){
//                            dp[i][j] =true;
//                            if(j - i +1 >max){
//                                max = j -i +1;
//                            }
//                        }
//                    }else {
//                        if(dp[i+1][j-1]&& s.charAt(i) == '('&& s.charAt(j) ==')' ){
//                            dp[i][j] = true;
//                            if(j - i +1 >max){
//                                max = j -i +1;
//                            }
//                            continue;
//                        }
//                        for(int k = i+1; k < j-1;k++){
//                            if(dp[i][k] && dp[k+1][j]){
//                                dp[i][j] = true;
//                                if(j - i +1 >max){
//                                    max = j -i +1;
//                                }
//                                break;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return max;
//    }
//
//    public static void main(String[] args) {
//        Longest_Valid_Parentheses x = new Longest_Valid_Parentheses();
//        System.out.println(x.longestValidParentheses(")()())"));
//    }
//}
