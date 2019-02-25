package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {

            int lo = i + 1;
            int hi = nums.length - 1;

            while (lo < hi) {

                if (nums[lo] + nums[hi] < -1 * nums[i]) {

                    while (lo < nums.length - 1 && nums[lo] == nums[lo + 1])
                        lo++;
                    lo++;

                } else if (nums[lo] + nums[hi] > -1 * nums[i]) {

                    while (hi >= 1 && nums[hi] == nums[hi - 1])
                        hi--;
                    hi--;

                } else {

                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[lo]);
                    list.add(nums[hi]);

                    while (lo < nums.length - 1 && nums[lo] == nums[lo + 1])
                        lo++;
                    lo++;

                    while (hi >= 1 && nums[hi] == nums[hi - 1])
                        hi--;
                    hi--;

                    result.add(list);

                }
            }

            while (i < nums.length - 3 && nums[i] == nums[i + 1])
                i++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        List<List<Integer>> mylist = new ThreeSum().threeSum(nums);
        System.out.println(mylist);
    }
}
