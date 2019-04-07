package Tree;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        boolean a = false;
        a = isSubtree(s.left, t);
        if (a) {
            return true;
        }
        if (s.val == t.val) {
            if (isSameTree(s, t)) {
                return true;
            }
        }
        return isSubtree(s.right, t);
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.right = new TreeNode(1);
        a.right.right = new TreeNode(2);
        a.right.left = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(1);
        b.right = new TreeNode(2);
        System.out.print(new SubtreeOfAnotherTree().isSubtree(a, b));
    }
}
