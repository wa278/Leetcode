import java.util.Hashtable;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;;

/**
 * Created by wa941 on 2018/5/4. 第一次接触滑动窗口
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /*我的算法 时间复杂度O（n) 至多2n; 离最厉害的算法就差一步
    public static int lengthOfLongestSubstring(String s) {
        Hashtable<Character,Integer> myTable = new Hashtable<>();
        if(s.equals("")){
            return 0;
        }
        else if(s == null){
            return 0;
        }
        else if(s.length() == 1){
            return 1;
        }
        int lo = 0;
        myTable.put(s.charAt(lo),lo);
        int result = 1;
        for(int hi =1 ;hi < s.length();hi++){
            if(myTable.containsKey(s.charAt(hi))){
                for(int i = lo; i<myTable.get(s.charAt(hi));i++){
                    myTable.remove(s.charAt(i));
                }
                lo = myTable.get(s.charAt(hi))+1;
                myTable.put(s.charAt(hi),hi);
            }
            else {
                myTable.put(s.charAt(hi),hi);
                if(hi - lo +1 > result){
                    result = hi- lo + 1;
                }
            }
        }
        return result;
    }
    */
    /*滑动窗口法 O(n)
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    */
    //时间复杂度o(n) 用hashmap保存索引，窗口就不用滑动了，直接到指定位置。
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j))+1, i);// 如果找到的值比左区间小，就不动。比左区间大则变动左区间。
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
