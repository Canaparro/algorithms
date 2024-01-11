package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConstructBinaryTreeFromPreorderAndInorder {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) {
            return null;
        }
        List<Integer> inorderList = new ArrayList<>();
        for(int i : inorder){
            inorderList.add(i);
        }

        TreeNode root = new TreeNode(preorder[0]);

        int start = 0;
        int middle = inorderList.indexOf(root.val);
        int end = inorder.length - 1;


        return root;
    }
}
