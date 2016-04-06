package com.yishen;

import com.yishen.model.TreeNode;

public class HouseRobberIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null) {
			if (root.right == null) {
				return root.val;
			} else {
				return Math.max(root.val + rob(root.right.left) + rob(root.right.right), rob(root.right));
			}
		} else {
			if (root.right == null) {
				return Math.max(root.val + rob(root.left.left) + rob(root.left.right), rob(root.left));
			} else {
				return Math.max(root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.left)
						+ rob(root.right.right), rob(root.left) + rob(root.right));
			}

		}
	}
}
