package Tree;

import Tree.TreeNode;

public class FlattenBinaryTreetoLinkedList {
    TreeNode pre = null;

    public TreeNode flatten(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        inOrder(pRootOfTree);
        while (pre.left != null) {
            pre = pre.left;
        }
        return pre;
    }

    public void inOrder(TreeNode pRootOfTree) {
        if (pRootOfTree.left != null) {
            inOrder(pRootOfTree.left);
        }
        pRootOfTree.left = pre;
        if (pre != null) {
            pre.right = pRootOfTree;
        }
        pre = pRootOfTree;
        if (pRootOfTree.right != null) {
            inOrder(pRootOfTree.right);
        }
    }
}
