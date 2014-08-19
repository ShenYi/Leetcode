import model.TreeNode;

/**
 * https://oj.leetcode.com/problems/path-sum/
 * 
 * @author yishen
 *
 */
public class PathSum {
    public static void main(String[] args) {
    }

    @SuppressWarnings("unused")
    public boolean hasPathSum(TreeNode root, int sum) {
        return root != null
                && ((sum == root.val && root.left == null && root.right == null) || hasPathSum(root.left, sum - root.val) || hasPathSum(root.right,
                        sum - root.val));

    }
}
