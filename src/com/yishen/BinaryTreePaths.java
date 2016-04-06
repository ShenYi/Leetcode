package com.yishen;

import java.util.ArrayList;
import java.util.List;

import com.yishen.model.TreeNode;

public class BinaryTreePaths {
	public static void main(String[] args) {
		System.out.println(new BinaryTreePaths().binaryTreePaths(new TreeNode(1)));
	}

	public List<String> binaryTreePaths(TreeNode root) {
		final List<String> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		String rootValue = String.valueOf(root.val);
		if (root.left == null && root.right == null) {
			result.add(rootValue);
		}

		final List<String> leftPaths = binaryTreePaths(root.left);
		for (String path : leftPaths) {
			result.add(rootValue + "->" + path);
		}

		final List<String> rightPaths = binaryTreePaths(root.right);
		for (String path : rightPaths) {
			result.add(rootValue + "->" + path);
		}

		return result;
	}

}
