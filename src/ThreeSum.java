import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3sum中hashTable对于复杂度的影响已经消失，使用双链表法更简单。时间复杂度O(n2)
 */
public class ThreeSum {
    public  List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2;i++){
            if(i ==0 || (i >0 && nums[i] != nums[i-1])){                //每次选择不重复的C值
                int c = nums[i] * -1;
                int lo = i+1;
                int hi = nums.length-1;
                while (hi > lo){
                    if(nums[hi] + nums[lo] == c){
                        ArrayList<Integer> myList = new ArrayList<>();
                        myList.add(nums[i]);
                        myList.add(nums[lo]);
                        myList.add(nums[hi]);
                        result.add(myList);
                        while (lo < hi && nums[lo] == nums[lo+1])         // 对于相同值跳过，题目要求同一解出现一次。
                            lo++;
                        while (lo< hi&& nums[hi] == nums[hi-1])
                            hi--;
                        lo++;
                        hi--;
                    }
                    else if(nums[hi] + nums[lo] < c){
                        lo++;
                    }
                    else {
                        hi--;
                    }
                }
            }
        }
        return result;
    }
}
