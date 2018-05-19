import java.util.Arrays;

/**
 * Created by wa941 on 2018/5/19.
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int num = 0;
        int closet = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length-1;i++){
            int lo = i+1;
            int hi = nums.length-1;
            while (hi > lo){
                if(nums[lo] + nums[hi] + nums[i] - target > closet ){
                    hi--;
                }
                else if(nums[lo] + nums[hi] + nums[i] - target < -1 * closet){
                    lo++;
                }
                else if(nums[lo] + nums[hi] + nums[i] - target == 0){
                    return target;
                }
                else if((nums[lo] + nums[hi] + nums[i] - target > -1* closet && nums[lo] + nums[hi] + nums[i] - target < closet )|| Math.abs(nums[lo] + nums[hi] + nums[i] - target) == closet){
                    if(nums[lo] + nums[hi] + nums[i] - target >0 && nums[lo] + nums[hi] + nums[i] - target <= closet ){
                        num = nums[lo] + nums[hi] + nums[i] - target;
                        closet = Math.abs(nums[lo] + nums[hi] + nums[i] - target);
                        hi--;
                    }
                    else if(nums[lo] + nums[hi] + nums[i] - target < 0 && nums[lo] + nums[hi] + nums[i] - target >= -1 * closet){
                        num = nums[lo] + nums[hi] + nums[i] - target;
                        closet = Math.abs(nums[lo] + nums[hi] + nums[i] - target);
                        lo++;
                    }
                }
            }
        }
        return num + target;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        System.out.println(threeSumClosest(nums,0));

    }
}
