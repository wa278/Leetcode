package Tree;

public class ConvertBSToGreaterTree {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        BigFor(root);
        return root;
    }

    public void BigFor(TreeNode root) {
        if (root != null) {
            BigFor(root.right);
            int a = root.val;
            root.val = root.val + sum;
            sum = sum + a;
            BigFor(root.left);
        }
    }
}
