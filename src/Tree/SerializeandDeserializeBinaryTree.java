package Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeandDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        if (root != null) {
            return "" + root.val + " " + serialize(root.left) + serialize(root.right);
        } else {
            return "& ";
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tree = data.split(" ");
        List<String> list = new LinkedList<String>(Arrays.asList(tree));
        return Deserialize(list);
    }

    public TreeNode Deserialize(List<String> list) {
        if (list.get(0).equals("&")) {
            list.remove(0);
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(list.remove(0)));
            node.left = Deserialize(list);
            node.right = Deserialize(list);
            return node;
        }
    }
}
