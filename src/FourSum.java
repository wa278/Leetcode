import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wa941 on 2018/5/21.
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length-3;i++){
            if(i!= 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i+1 ; j < nums.length - 2;j ++){
                if(j != i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int lo = j+1;
                int hi = nums.length-1;
                while (hi > lo){
                    if(nums[lo] + nums[hi] + nums[j] + nums[i] < target){
                        lo++;
                    }
                    else if(nums[lo] + nums[hi] + nums[j] + nums[i] > target){
                        hi--;
                    }
                    else {
                        LinkedList<Integer> a = new LinkedList<>();
                        a.add(nums[i]);
                        a.add(nums[j]);
                        a.add(nums[lo]);
                        a.add(nums[hi]);
                        result.add(a);
                        while (nums[lo] == nums[lo+1] && lo +1 < hi){
                            lo++;
                        }
                        while (nums[hi] == nums[hi - 1] && hi-1 >lo){
                            hi--;
                        }
                        lo++;
                        hi--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-3,-4,-5,0,-5,-2,5,2,-3};
        List<List<Integer>> result = fourSum(nums,3);
        int a = 6;
    }
}
