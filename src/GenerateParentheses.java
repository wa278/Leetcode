import java.util.ArrayList;
import java.util.List;

/**
 * Created by wa941 on 2018/5/16.
 */
/*
生成所有可能的序列，要用递归方法，递归有顺序，先左括号，后右括号。递归可以用于穷举。
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
}
