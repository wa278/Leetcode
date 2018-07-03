import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        /*
        时间复杂度O(NLOGN)
         */
//        if (nums.length == 0){
//            return 0;
//        }
//        Arrays.sort(nums);
//        int result = 1;
//        int c = 1;
//        for(int i = 1; i < nums.length ; i++){
//            if(nums[i] - nums[i-1] == 1){
//                c++;
//                result = Math.max(c,result);
//            }
//            else if(nums[i] == nums[i-1]){
//                continue;
//            }
//            else {
//                c = 1;
//            }
//        }
//        return result;
        /*
        时间复杂度最差O(n2)最好O(N) 查找某一个特定的数字时，哈希表最快
         */
        int result = 0;
        HashSet<Integer> myset = new HashSet<>();
        for(int i= 0; i < nums.length ; i++){
            myset.add(nums[i]);
        }
        for(int i = 0; i < nums.length;i++){
            if(!myset.contains(nums[i]-1)){
                int number = nums[i];
                int c = 1;
                while (myset.contains(number+1)){
                    number = number+1;
                    c++;
                }
                result = Math.max(result,c);
            }
        }
        return result;
    }
}
