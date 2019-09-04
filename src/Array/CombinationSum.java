package Array;

import java.util.LinkedList;
import java.util.List;
//递归 + 回溯法
public class CombinationSum {
    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        addResult(candidates, target, new LinkedList<>(), 0);
        return result;
    }

    public void addResult(int[] candidates, int target, LinkedList<Integer> list, int index) {
        if (target == 0) {
            result.add(new LinkedList<>(list));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            addResult(candidates, target - candidates[i], list, i);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum x = new CombinationSum();
        int[] can = {2, 3, 5};
        System.out.print(x.combinationSum(can, 8));
    }
}
