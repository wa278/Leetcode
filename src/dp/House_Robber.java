package dp;

/*
max[i] 代表抢劫以i为结尾的房子的最大收益。 max[i] = Math.max(max[i-2]+nums[i] , max[i-1])
起始条件 max[0] = nums[0] Math.max(nums[0], nums[1])
 */
public class House_Robber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] max = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        }
        max[0] = nums[0];
        max[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            max[i] = Math.max(max[i - 1], max[i - 2] + nums[i]);
        }
        return max[nums.length - 1];
    }

    public static void main(String[] args) {
        House_Robber x = new House_Robber();
        int[] nums = {6, 2,};
        System.out.println(x.rob(nums));
    }
}
