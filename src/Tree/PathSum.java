package Tree;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        return currentSum(root,0,sum);
    }
    public boolean currentSum(TreeNode x,int a,int sum){
        if(a + x.val == sum && x.left == null && x.right == null)
            return true;
        else
            return (x.left!=null&&currentSum(x.left,a + x.val,sum) )|| (x.right!=null && currentSum(x.right,a+x.val,sum));
    }

    public static void main(String[] args) {
        PathSum o = new PathSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.left = new TreeNode(4);
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//        root.right= new TreeNode(8);
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.right.right.right = new TreeNode(1);
        System.out.println(o.hasPathSum(root,1));

    }
}
