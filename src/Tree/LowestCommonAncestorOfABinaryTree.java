package Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return null;
        }
        queue.offer(root);
        parent.put(root,null);
        while (queue.size()!=0){
            TreeNode a = queue.poll();
            if(a.left != null){
                queue.offer(a.left);
                parent.put(a.left,a);
            }
            if(a.right != null){
                queue.offer(a.right);
                parent.put(a.right,a);
            }
        }
        HashSet<TreeNode> ancestor = new HashSet<>();
        ancestor.add(p);
        while (parent.get(p) != null){
            ancestor.add(parent.get(p));
            p = parent.get(p);
        }
        while (!ancestor.contains(q)){
            q = parent.get(q);
        }
        if (q == null){
            return  null;
        }
        return q;
    }
}
