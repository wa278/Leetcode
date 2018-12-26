package Binary_Search;

//分两种情况 如果 num[mid] 和target 属于的部分相同，就按二分查找
//如果num[mid] 和 target属于的部分不同，就在mid 的另一边查找。
public class Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (hi >= lo) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (isLeft(nums, target) ^ isLeft(nums, nums[mid])) {
                if (isLeft(nums, target)) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }

    public boolean isLeft(int[] nums, int target) {
        if (target >= nums[0]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4, 4, 6, 7, 0, 1, 2};
        System.out.print(new Search_in_Rotated_Sorted_Array().search(nums, 4));
    }
}
