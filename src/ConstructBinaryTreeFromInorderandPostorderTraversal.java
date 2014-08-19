import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 
 * @author yishen
 * 
 */
public class ConstructBinaryTreeFromInorderandPostorderTraversal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ConstructBinaryTreeFromInorderandPostorderTraversal instance = new ConstructBinaryTreeFromInorderandPostorderTraversal();
        instance.pre(instance.buildTree(new int[] {2, 1}, new int[] {2, 1}));

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        final int index = find(inorder, root.val);
        if (index < 0) {
            return null;
        }

        root.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        root.right = buildTree(
                index >= inorder.length - 1 ? null :
                        Arrays.copyOfRange(inorder, index + 1, inorder.length),
                index > postorder.length - 1 ? null :
                        Arrays.copyOfRange(postorder, index, postorder.length - 1));

        return root;
    }

    public int find(int[] a, int n) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == n) {
                return i;
            }
        }

        return -1;
    }

    public void pre(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + "  ");
        pre(node.left);
        pre(node.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
