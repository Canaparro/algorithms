package com.example.demo.leetcode;

public class BinaryTreeMaxPathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        int leftVal = Integer.MIN_VALUE;
        int rightVal = Integer.MIN_VALUE;

        if(node.left != null) {
            leftVal = dfs(node.left);
        }
        if(node.right != null) {
            rightVal = dfs(node.right);
        }


        int currentMax = node.val;

        if(node.left != null) {
            maxSum = Math.max(leftVal, maxSum);
            currentMax = Math.max(leftVal + node.val, currentMax);
        }
        if(node.right != null) {
            maxSum = Math.max(rightVal, maxSum);
            currentMax = Math.max(rightVal + node.val, currentMax);
        }
        if(node.left != null && node.right != null) {
            maxSum = Math.max(maxSum, leftVal + rightVal + node.val);
        }

        maxSum = Math.max(maxSum, currentMax);

        return currentMax;
    }
}
