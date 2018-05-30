/**
 * Created by wa941 on 2018/5/30.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int a = 1;
        int min = Math.min(m,n);
        int sum = m + n -2;
        for(int i = min -1 ; i > 0;i--){
            a = a * sum;
            sum--;
        }
        int b = 1;
        for(int i = min - 1 ; i > 0; i--){
            b = b * i;
        }
        return a/b;
    }
}
