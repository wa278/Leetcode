import java.util.LinkedList;
import java.util.List;

/**
 * Created by wa941 on 2018/5/15.                       我没有使用 FIFO      我真的是脑子有包
 */
public class LetterCombinationsofaPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        char[][] letter= {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        if(digits.length() > 0){
            for(int i = 0 ;i < letter[digits.charAt(0) - '0'].length; i++){
                result.add(letter[digits.charAt(0) - '0'][i] + "");
            }
        }
        for(int i = 1 ; i < digits.length();i++){
            int l = result.size();
            for(int j = 0; j < l;j++){
                String k = result.remove(0);
                for(int m = 0 ; m < letter[digits.charAt(i) - '0'].length;m++){
                    result.add(k+letter[digits.charAt(i) - '0'][m]);
                }
            }
        }
//        for(int i = 1; i < digits.length();i++){
//            LinkedList<String> dup = new LinkedList<>();
//            for(int j=0 ; j < letter[digits.charAt(i) - '0'].length ; j++){
//                LinkedList<String> aa = new LinkedList<>(result);
//                for(int m = 0 ; m < aa.size();m++){
//                    String k = aa.remove(m);
//                    k = k + letter[digits.charAt(i) - '0'][j];
//                    aa.add(m,k);
//                }
//                dup.addAll(aa);
//            }
//            result = dup;
//        }
        return result;
    }

    public static void main(String[] args) {
        letterCombinations("23");
    }
}
