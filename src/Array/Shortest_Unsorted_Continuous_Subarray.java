package Array;

import java.util.Stack;

public class Shortest_Unsorted_Continuous_Subarray {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int lo = nums.length;
        int hi = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[stack.peek()] > nums[i]) {
                lo = Math.min(lo, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int j = nums.length - 1; j >= 0; j--) {
            while (!stack.empty() && nums[stack.peek()] < nums[j]) {
                hi = Math.max(hi, stack.pop());
            }
            stack.push(j);
        }
        return hi - lo > 0 ? hi - lo + 1 : 0;
    }

    public static void main(String[] args) {
        Shortest_Unsorted_Continuous_Subarray x = new Shortest_Unsorted_Continuous_Subarray();
        int[] input = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(x.findUnsortedSubarray(input));
    }
}
