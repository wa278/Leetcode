package Array;

import java.util.LinkedList;
import java.util.List;

public class Find_All_Numbers_Disappeared_in_an_Array {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<>();
        int head = 0;
        while (head < nums.length) {
            if (nums[head] != head + 1)
                if (nums[nums[head] - 1] == nums[head]) {
                    head++;
                } else {
                    exch(nums, head, nums[head] - 1);
                }
            else {
                head++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Find_All_Numbers_Disappeared_in_an_Array x = new Find_All_Numbers_Disappeared_in_an_Array();
        int[] input = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(x.findDisappearedNumbers(input));
    }
}
