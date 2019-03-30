package Tree;

import Tree.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        else if(p == null || q == null){
            return false;
        }
        if(p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        else {
            return false;
        }
    }
    public boolean sameTree(TreeNode p,TreeNode q){
        if(p.val == q.val){
            if(p.left!=null&&p.right!=null && q.left!=null&&q.right!=null)
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            else if(p.left!=null && q.left != null && p.right == null && q.right ==null)
                return isSameTree(p.left,q.left);
            else if(p.left==null && q.left == null && p.right != null && q.right !=null){
                return isSameTree(p.right,q.right);
            }
            else if(p.left==null && q.left == null && p.right == null && q.right ==null){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
