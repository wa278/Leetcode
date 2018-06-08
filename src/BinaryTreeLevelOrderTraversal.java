import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> myqueue = new LinkedList<>();
        if(root == null){
            return result;
        }
        myqueue.add(root);
        while (!myqueue.isEmpty()){
            List<TreeNode> x =new LinkedList<>();
            while (!myqueue.isEmpty()){
                x .add(myqueue.poll());
            }
            List<Integer> a = new LinkedList<>();
            for(TreeNode e : x){
                a.add(e.val);
                if(e.left!=null){
                    myqueue.add(e.left);
                }
                if(e.right != null){
                    myqueue.add(e.right);
                }
            }
            result.add(a);
        }
        return result;
    }
}
