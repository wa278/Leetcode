import java.util.*;

/**
 * Created by wa941 on 2018/5/29.
 */
/*
hashmap 要用到hashcode 和equal .String的equal被覆盖过，逐个比较字母.char[]的equal没有被重写，比较的是对象是不是一个（==）。
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> table = new HashMap<>();
        for (int i = 0; i < strs.length;i++){
            char[] x = strs[i].toCharArray();
            Arrays.sort(x);
            String s = String.valueOf(x);
            if(!table.containsKey(s)){
                ArrayList<String> index = new ArrayList<>();
                index.add(strs[i]);
                table.put(s,index);
            }
            else {
                table.get(s).add(strs[i]);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(ArrayList<String> x :table.values()){
            result.add(x);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] aaa = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(aaa);
    }
}
