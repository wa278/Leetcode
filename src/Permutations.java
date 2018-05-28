import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wa941 on 2018/5/28.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        int j = 1;
        for(int i = nums.length; i >= 1; i--){
            j = j * i;
        }
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0 ;i < j; i++){
            result.add(nextPermute(nums));
        }
        return result;
    }
    public List<Integer> nextPermute(int[] nums){
        for(int i = nums.length-2; i >=0; i--){
            if(nums[i] < nums[i+1]){
                   for(int j = nums.length-1;j >= i+1;j--){
                       if(nums[j] > nums[i]){
                          int temp = nums[i];
                           nums[i] = nums[j];
                           nums[j] = temp;
                           Arrays.sort(nums,i+1,nums.length);
                           List<Integer> x =new LinkedList<>();
                           for(int k = 0; k < nums.length;k++){
                               x.add(nums[k]);
                           }
                           return x;
                       }
                   }
            }
        }
        Arrays.sort(nums);
        List<Integer> x =new LinkedList<>();
        for(int k = 0; k < nums.length;k++){
            x.add(nums[k]);
        }
        return x;
    }
}
