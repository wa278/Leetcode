import java.util.LinkedList;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i < s.length()+1;i++){
            for(int j = i; j<dp.length && dp[i-1] ;j++){
                if(wordDict.contains(s.substring(i-1,j))){
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak x = new WordBreak();
        List<String> wordDict = new LinkedList<>();
//        wordDict.add("cats");
//        wordDict.add("dog");
//        wordDict.add("sand");
//        wordDict.add("and");
//        wordDict.add("cat");
        wordDict.add("a");
        boolean v = x.wordBreak("a",wordDict);
        System.out.println(v);
    }
}
