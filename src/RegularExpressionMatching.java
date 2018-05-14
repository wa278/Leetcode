import java.util.HashSet;

/**
 * Created by wa941 on 2018/5/9.非确定的有限状态机 NFA 匹配转换 阿尔法转换 时间复杂度O(MN),对每一个字符n，只需要遍历不超过M的可能状态集合。
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p){
        if(p.length() == 0){
            if(s.length() == 0){
                return true;
            }
            else {
                return false;
            }
        }
        HashSet<Integer>[] adj = (HashSet<Integer>[]) new HashSet[p.length()+1];          // 多加了一个终止状态
        for(int i = 0 ; i < p.length()+1;i++){
            adj[i] = new HashSet<>();
        }
        for(int i = 0 ; i < p.length();i++){             // 计算i+1的可能状态
            if(i < p.length()-1){
                if(p.charAt(i+1) == '*'){
                    adj[i].add(i+1);
                    adj[i+1].add(i);
                }
            }
            if(p.charAt(i) == '*'){
                adj[i].add(i+1);
            }
        }
        boolean marked[] ;
        HashSet<Integer> pc = new HashSet<>();
        marked = new boolean[p.length()+1];
        dfs(adj,marked,0);
        for(int i = 0 ; i< p.length()+1;i++){
            if(marked[i]){
                pc.add(i);
            }
        }
        for(int i = 0 ; i< s.length();i++){
            HashSet<Integer> match = new HashSet<>();
            for(int v : pc){
                if(v < p.length()){
                    if(s.charAt(i) == p.charAt(v) || p.charAt(v) =='.'){
                        match.add(v+1);
                    }
                }
            }
            marked = new boolean[p.length()+1];
            dfs(adj,marked,match);
            pc = new HashSet<>();
            for(int m = 0; m < marked.length;m++){
                if(marked[m]){
                    pc.add(m);
                }
            }
        }
        for(int e : pc){                       // 检测有没有虚拟终止状态
            if(e == p.length()){
                return true;
            }
        }
        return false;
    }
    public void dfs(HashSet<Integer>[] adj,boolean[] marked,int v){           // 深度优先遍历
        marked[v] = true;
        for(int e : adj[v]){
            if(!marked[e]){
                dfs(adj,marked,e);
            }
        }
    }
    public void dfs(HashSet<Integer>[] adj,boolean[] marked,HashSet<Integer> match){
        for(int v : match){
            dfs(adj,marked,v);
        }
    }

    public static void main(String[] args) {
        RegularExpressionMatching x = new RegularExpressionMatching();
        boolean a = x.isMatch("ab",".*c");
        System.out.println(a);
    }
}
