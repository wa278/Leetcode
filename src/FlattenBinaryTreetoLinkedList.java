import java.util.LinkedList;

public class FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        LinkedList<TreeNode> cache = new LinkedList<>();
        helper(root,cache);
        cache.poll();
        while (cache.size()!=0){
            root.left = null;
            root.right = cache.poll();
            root = root.right;
        }
    }
    public void helper(TreeNode root,LinkedList<TreeNode> cache){
        cache.add(root);
        if(root.left!=null){
            helper(root.left,cache);
        }
        if(root.right != null){
            helper(root.right,cache);
        }
    }
}
