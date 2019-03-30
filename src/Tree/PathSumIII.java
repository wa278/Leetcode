package Tree;

public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return sumPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int sumPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return (root.val == sum ? 1 : 0) + sumPath(root.left, sum - root.val) + sumPath(root.right, sum - root.val);
    }
}
