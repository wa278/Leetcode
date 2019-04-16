package Greedy;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int head = 0;
        int end = nums[0];
        while (head <= end) {
            end = Math.max(nums[head] + head, end);
            if (end >= nums.length - 1) {
                return true;
            }
            head = head + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame x = new JumpGame();
        int[] nums = {3,2,1,0,4};
        System.out.print(x.canJump(nums));
    }
}
