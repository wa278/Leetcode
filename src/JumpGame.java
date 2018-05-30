/**
 * Created by wa941 on 2018/5/29.
 */
public class JumpGame {
//    public static boolean canJump(int[] nums) {
//
//        return canJumpFromPosition(0,nums);
//    }
//    public static boolean canJumpFromPosition(int position, int[] nums) {
//        if (position == nums.length - 1) {
//            return true;
//        }
//        int furthestJump = Math.min(position + nums[position], nums.length - 1);
//        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
//            if (canJumpFromPosition(nextPosition, nums)) {
//                return true;
//            }
//        }
//        return false;
//    }
    /*
    贪心算法。
     */
    public static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.print(canJump(nums));
    }
}
