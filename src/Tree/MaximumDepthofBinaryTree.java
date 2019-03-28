package Tree;

import Tree.TreeNode;

public class MaximumDepthofBinaryTree {
//    public int maxDepth(TreeNode root) {
//        if(root == null){
//            return 0;
//        }
//        return max(root,1);
//    }
//    public int max(TreeNode x, int i){
//        int j = i;
//        if(x == null){
//            return i;
//        }
//        j = Math.max(max(x.left,i+1),max(x.right,i+1));
//        return j;
//    }
public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
}
}
