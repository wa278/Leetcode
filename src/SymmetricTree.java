import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    /*
    时间89ms 连排名都没有
     */
//    public boolean isSymmetric(TreeNode root) {
//        if(root == null){
//            return true;
//        }
//        Queue<TreeNode[]> myqueue = new LinkedList<>();
//        int i = 1;
//        TreeNode[] x = new TreeNode[1];
//        x[0] = root;
//        myqueue.add(x);
//        while (!myqueue.isEmpty()){
//            i *= 2;
//            boolean flag = false;
//            TreeNode[] a = myqueue.remove();
//            TreeNode[] b = new TreeNode[i];
//            for(int j = 0; j < a.length; j++){
//                if(a[j] == null){
//                    b[j*2] = null;
//                    b[j*2+1] = null;
//                }
//                else {
//                    flag = true;
//                    b[j*2] = a[j].left;
//                    b[j*2+1] = a[j].right;
//                }
//            }
//            if(!flag){
//                break;
//            }
//            int lo = 0;
//            int hi = i-1;
//            while (hi > lo){
//                if((b[lo]==null && b[hi] == null)){
//                    hi--;
//                    lo++;
//                }
//                else if(b[lo] != null && b[hi] != null && b[lo].val == b[hi].val){
//                    hi--;
//                    lo++;
//                }
//                else
//                    return false;
//            }
//            myqueue.add(b);
//        }
//        return true;
//    }
    /*
    比较是有顺序的 左边的左边 和右边的右边比 https://leetcode.com/problems/symmetric-tree/solution/
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        SymmetricTree x = new SymmetricTree();
        System.out.print(x.isSymmetric(null));
    }
}
