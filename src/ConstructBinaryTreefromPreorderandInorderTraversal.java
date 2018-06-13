/*
前序遍历的第一个节点是根节点。
在中序遍历中，根节点左侧是根节点的左子树，根节点右侧是根节点的右子树。
递归循环就可以构造出树。
前序遍历和中序遍历可以构造一棵树
后序遍历和中序遍历可以构造一棵树。
中序遍历可以使二叉排序树输出有序。
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(0);
        build(root,preorder,inorder,0,inorder.length-1,0,inorder.length-1);
        return root;
    }
    public void build(TreeNode x,int[] preorder,int[] inorder,int start, int end,int lo, int hi){
        x.val = preorder[lo];
        int i = start;
        for(; i <= end; i++){
            if(inorder[i] == x.val){
                break;
            }
        }
        if(i-1 >= start){
            x.left = new TreeNode(0);
            build(x.left,preorder,inorder,start,i-1,lo+1,lo+1+i-1-start);
        }
        if(end >= i+1){
            x.right = new TreeNode(0);
            build(x.right,preorder,inorder,i+1,end,lo+ i - start +1,end);
        }
    }

    public static void main(String[] args) {
        ConstructBinaryTreefromPreorderandInorderTraversal x = new ConstructBinaryTreefromPreorderandInorderTraversal();
        int[] preorde = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        x.buildTree(preorde,inorder);
    }
}
