import java.util.Hashtable;

/**
 * Created by wa941 on 2018/6/2.
 */
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }
        Hashtable<Character,Integer> thash = new Hashtable<>();
        Hashtable<Character,Integer> shash = new Hashtable<>();
        for(int i = 0; i < t.length(); i++){
            if(thash.containsKey(t.charAt(i))){
                thash.put(t.charAt(i),thash.get(t.charAt(i))+1);
            }
            else {
                thash.put(t.charAt(i),1);
            }
        }
        int start = 0;
        int end = 0;
        int found = 0;
        int length = Integer.MAX_VALUE;
        for(int i = 0; i < s.length();i++){
            if(thash.containsKey(s.charAt(i))){
                if(shash.containsKey(s.charAt(i))){
                    shash.put(s.charAt(i),shash.get(s.charAt(i))+1);
                    if(shash.get(s.charAt(i)) <= thash.get(s.charAt(i))){
                        found++;
                    }
                }
                else {
                    shash.put(s.charAt(i),1);
                    if(shash.get(s.charAt(i)) <= thash.get(s.charAt(i))){
                        found++;
                    }
                }
            }
            if(found == t.length()) {
                while (true){
                    if(!thash.containsKey(s.charAt(start))){          // contains 比较的是 value
                        start++;
                    }
                    else if(shash.get(s.charAt(start)) > thash.get(s.charAt(start))){
                        shash.put(s.charAt(start), shash.get(s.charAt(start))-1);
                        start++;
                    }
                    else {
                        break;
                    }
                }
                if(i - start + 1 < length){
                    end = i;
                    length = end - start +1;
                }
                shash.put(s.charAt(start), shash.get(s.charAt(start))-1);
                start++;
                found--;
            }
        }
        if(length > s.length()){
            return "";
        }
        return  s.substring(end +1 - length,end+1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBACN";
        String t = "ABC";
        System.out.print(minWindow(s,t));
    }
}
