/**
 * Created by wa941 on 2018/5/15.
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        for(int i = 0; i < strs.length;i++){
            if(strs[i] == null || strs[i].equals("")){
                return "";
            }
        }
        String result = "";
        int len = strs[0].length();
        for(int i = 0 ; i < strs.length; i++){
            if(strs[i].length() < len){
                len = strs[i].length();
            }
        }
        for(int j = 0; j < len; j++){
            char x = strs[0].charAt(j);
            boolean tag = false;
            for(int i = 1; i < strs.length;i++){
                if(strs[i].charAt(j) != x){
                    tag = true;
                    break;
                }
            }
            if(tag){
                break;
            }
            else {
                result += x;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] st = new String[2];
        st[0] = "aa";
        st[1] = "a";
        longestCommonPrefix(st);
    }
}
