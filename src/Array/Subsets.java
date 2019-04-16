package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wa941 on 2018/6/4.
 */
/*
子数组的所有个数 是 2的n次方。正好与二进制比特吻合。进行位操作判断所有可能结果。
i & (1<< j)) != 0 用不等式判断 因为一种情况是等于0 另一种情况是1，2，4，8，。。。。。。

 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < (int) Math.pow(2, nums.length); i++) {
            ArrayList<Integer> x = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    x.add(nums[j]);
                }
            }
            result.add(x);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        subsets(nums);
    }
}

/*package Array;

        import java.util.LinkedList;
        import java.util.List;

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> myList = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        subsets(nums, 0, myList, result);
        return result;
    }

    public void subsets(int[] nums, int index, LinkedList<Integer> myList, List<List<Integer>> result) {
        result.add(new LinkedList<>(myList));
        for (int i = index; i < nums.length; i++) {
            myList.add(nums[i]);
            subsets(nums, i + 1, myList, result);
            myList.remove(myList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subset x = new Subset();
        System.out.print(x.subsets(nums));
    }
}*/