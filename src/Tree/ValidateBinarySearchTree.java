package Tree;

public class ValidateBinarySearchTree {
    public boolean bool ;
    public TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        bool  = true;
        pre  = null;
        validHelper(root);
        return bool;
    }

    public void validHelper(TreeNode root) {
        if (root.left != null) {
            validHelper(root.left);
        }
        if (pre == null) {
            pre = root;
        } else {
            if (pre.val >= root.val) {
                bool = false;
            }
            pre = root;
        }
        if (root.right != null) {
            validHelper(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        ValidateBinarySearchTree x = new ValidateBinarySearchTree();
        System.out.print(x.isValidBST(root));
    }
}
