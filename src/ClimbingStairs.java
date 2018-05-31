/**
 * Created by wa941 on 2018/5/31.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 0){
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        else if(n == 2){
            return 2;
        }
        int[] step = new int[n+1];
        step[1] = 1;
        step[2] = 2;
        for(int i = 3; i <= n; i++){
            step[i] = step[i-1] + step[i-2];
        }
        return step[n];
    }
}
