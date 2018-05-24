import java.util.ArrayList;
import java.util.List;

/**
 * Created by wa941 on 2018/5/24.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;
        List<Integer> x = new ArrayList<>();
        find(result,candidates.length-1,sum,candidates,target,x);
        return result;
    }
    public void find(List<List<Integer>> result,int i,int sum,int[] candidates,int target,List<Integer> x){
        if(sum < target){
            for(int j = i; j>=0;j--){
                sum += candidates[j];
                x.add(candidates[j]);
                find(result,j,sum,candidates,target,x);
                int g = x.remove(x.size()-1);
                sum -= g;
            }
        }
        else if(sum == target){
            List<Integer> f =new ArrayList<>(x);
            result.add(f);
        }
    }
    public static void main(String[] args) {
        CombinationSum x = new CombinationSum();
        int[] can = {2,3,6,7};
        List<List<Integer>> b =x.combinationSum(can,7);
        int g =3;
    }
}
