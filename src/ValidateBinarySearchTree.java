import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        AtomicInteger x = new AtomicInteger(1);
        AtomicBoolean flag = new AtomicBoolean(false);
        return valid(root,flag,x);
    }
    public boolean valid(TreeNode root,AtomicBoolean flag,AtomicInteger x){
        if(root.left!= null &&!valid(root.left,flag,x) ){
            return false;
        }
        if(flag.get() == false){
            flag.set(true);
        }
        else if(root.val <= x.get()){
            return false;
        }
        x .set(root.val);
        if(root.right != null &&!valid(root.right,flag,x)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-1);
        ValidateBinarySearchTree x = new ValidateBinarySearchTree();
        System.out.print(x.isValidBST(root));
    }
}
