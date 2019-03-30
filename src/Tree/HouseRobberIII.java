package Tree;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] nums = dfs(root);
        return Math.max(nums[0],nums[1]);
    }

    private int[] dfs(TreeNode root){
        if(root == null){
            return new int[2];
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] result = new int[2];
        result[0] = root.val + left[1] + right[1];
        result[1] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        return result;
    }
}
