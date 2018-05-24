/**
 * Created by wa941 on 2018/5/24.
 */
public class SearchForARange {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int lo = 0;
        int hi = nums.length-1;
        while (hi >= lo){
            int mid = (hi-lo) / 2 + lo;
            if(target > nums[mid]){
                lo = mid +1;
            }
            else if ( target < nums[mid]){
                hi = mid -1;
            }
            else {
                int a = mid;
                int b = mid;
                while (a+1 < nums.length && nums[a+1] == target ){
                    a++;
                }
                while (b-1 >=0 &&nums[b-1] == target  ){
                    b--;
                }
                result[0] = b;
                result[1] = a;
                return result;
            }
        }
        int[] none = {-1,-1};
        return none;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] x =searchRange(nums,8);
    }
}
