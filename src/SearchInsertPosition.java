/**
 * Created by wa941 on 2018/5/27.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int lo = 0,hi = nums.length-1;
        while (hi >= lo){
            int mid = (hi - lo) / 2 + lo ;
            if(nums[mid] > target){
                hi = mid-1;
            }
            else if(nums[mid] < target){
                lo = mid +1;
            }
            else {
                return mid;
            }
        }
        return lo;
    }
}
