/*
正常的遍历是不可以的，因为正常遍历的顺序不是路径而且还包含很多边枝节点。
采用递归的思想 把任意节点当作根节点寻找根节点的最大Path.把这一根节点的子数看作一个整体，当作叶子节点。
那么次根节点的左右子树就必须选择一个当作路径，当然选择最大的。
在全局变量里保存结果，每计算出一个节点的最大路径，就去比较选出最大值。

 */
public class BinaryTreeMaximumPathSum {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        maxSubPath(root);
        return result;
    }
    public int maxSubPath(TreeNode root){
        int left = root.left == null? 0:Math.max(maxSubPath(root.left),0);
        int right = root.right == null? 0:Math.max(maxSubPath(root.right),0);
        result = Math.max(result,left + root.val+right);
        return Math.max(left + root.val,right+root.val);
    }
}
