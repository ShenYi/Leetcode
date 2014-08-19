import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 * @author yishen
 * 
 */
public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode[] nodes = new TreeNode[7];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new TreeNode(i);
        }

        nodes[3].left = nodes[1];
        nodes[1].left = nodes[0];
        nodes[1].right = nodes[2];
        nodes[5].left = nodes[4];
        nodes[5].right = nodes[6];
        nodes[3].right = nodes[5];

        System.out.println(new BinaryTreeInorderTraversal().inorderTraversal(nodes[3]));

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        while (!stack.isEmpty()) {
            node = stack.pop();
            result.add(node.val);
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        return result;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
