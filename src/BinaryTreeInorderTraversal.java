import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null){
            return result;
        }
        inorder(root,result);
        return result;
    }
    public void inorder(TreeNode root,List<Integer> result){
        if(root.left != null){
            inorder(root.left,result);
        }
        result.add(root.val);
        if(root.right != null){
            inorder(root.right,result);
        }
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
