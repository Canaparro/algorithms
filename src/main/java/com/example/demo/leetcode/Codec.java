package com.example.demo.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Codec {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        int counter = 0;
        while (counter < nodes.size()) {
            TreeNode currentNode = nodes.get(counter);
            if (currentNode != null) {
                nodes.add(currentNode.left);
                nodes.add(currentNode.right);
            }
            counter++;
        }

        return nodes.stream()
                .map(n -> n == null ? "null" : String.valueOf(n.val))
                .reduce("", (accumulated, current) -> accumulated + current + ",");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] splitted = data.split(",");

        // single element
        if (splitted.length == 1) {
            if ("null".equals(splitted[0])) {
                return null;
            } else {
                return new TreeNode(Integer.parseInt(splitted[0]));
            }
        }

        TreeNode root = new TreeNode(Integer.parseInt(splitted[0]));

        // multiple elements
        buildTreeFromNode(splitted, 0, root);

        return root;
    }

    private void buildTreeFromNode(String[] values, int index, TreeNode node) {
        if (node != null) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            if (left < values.length) {
                if ("null".equals(values[left])) {
                    node.left = null;
                } else {
                    node.left = new TreeNode(Integer.parseInt(values[left]));
                    buildTreeFromNode(values, left, node.left);
                }
            }

            if (right < values.length) {
                if ("null".equals(values[right])) {
                    node.right = null;
                } else {
                    node.right = new TreeNode(Integer.parseInt(values[right]));
                    buildTreeFromNode(values, right, node.right);
                }
            }
        }
    }
}
