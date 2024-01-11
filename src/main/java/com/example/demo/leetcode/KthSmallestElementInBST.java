package com.example.demo.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class KthSmallestElementInBST {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int result = root.val;
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if(node.left != null && !visited.contains(node.left.val)) {
                stack.push(node.left);
            } else {
                visited.add(node.val);
                stack.pop();
                k--;
                if(k == 0) {
                    result = node.val;
                    break;
                } else if(node.right != null && !visited.contains(node.right.val)) {
                    stack.push(node.right);
                }
            }
        }
        return result;
    }

}
