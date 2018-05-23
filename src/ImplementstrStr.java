/**
 * Created by wa941 on 2018/5/23.KMP算法，构造DFA矩阵。时间复杂度O（m+n）,访问DFAm次，字符串n次。
 * x跟着 j 更新，相同就往前移，不同就往后退。
 */
public class ImplementstrStr {
    public static int strStr(String haystack, String needle) {
        int m = needle.length();
        if(m == 0){
            return 0;
        }
        int[][] dfa = new int[256][m];
        dfa[needle.charAt(0)][0] = 1;
        for(int x = 0,j =1; j< needle.length();j++){
            for(int i = 0; i< 256;i++){
                dfa[i][j] = dfa[i][x];
            }
            dfa[needle.charAt(j)][j] = j+1;
            x = dfa[needle.charAt(j)][x];
        }
        int j = 0;
        int i = 0;
        for(; i < haystack.length() && j < m;i++){
            j = dfa[haystack.charAt(i)][j];
        }
        if(j == m){
            return i - m +1;
        }
        else
            return -1;
    }

    public static void main(String[] args) {
        strStr("hello","ll");
    }
}
