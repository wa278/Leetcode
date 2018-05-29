import java.util.Arrays;

/**
 * Created by wa941 on 2018/5/29.排序后再比较。
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        for(int i = 0; i < s.length();i++){
            if(ss[i] != tt[i]){
                return false;
            }
        }
        return true;
    }
}
