package Array;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        int left = search(nums, target, true);
        int right = search(nums, target, false);
        return new int[]{left, right};
    }

    public int search(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (target < nums[mid])
                hi = mid - 1;
            else if (target > nums[mid])
                lo = mid + 1;
            else {
                if (left && (mid - 1 >= -0 && nums[mid - 1] == nums[mid]))
                    hi = mid - 1;
                else if (!left && (mid + 1 < nums.length && nums[mid + 1] == nums[mid]))
                    lo = mid + 1;
                else {
                    return mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] result = new Find_First_and_Last_Position_of_Element_in_Sorted_Array().searchRange(nums, 5);
        System.out.print(result[0] + " " + result[1]);
    }
}
