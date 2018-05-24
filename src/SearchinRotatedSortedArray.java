/**
 * Created by wa941 on 2018/5/24.
 * 成环之后在某一点分开，总是部分有序的。1左边升序，2右边升序。判断那边有序验证target是否在范围内，是的话在范围内搜索，不是在另一边搜索。。
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        while (hi >= lo){
            int mid = (hi - lo)/2 + lo;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[lo] <= nums[mid]){
                if(target >= nums[lo] && target < nums[mid]){
                    hi = mid-1;
                }
                else {
                    lo = mid +1;
                }
            }
            else {
                if(target > nums[mid] && target <= nums[hi]){
                    lo = mid +1;
                }
                else {
                    hi = mid-1;
                }
            }
        }
        return -1;
    }
}
