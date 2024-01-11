package com.example.demo.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthSmallestElementInBSTTest {

    @Test
    @DisplayName("test1")
    void test1() {
    	// Given
        KthSmallestElementInBST.TreeNode node = new KthSmallestElementInBST.TreeNode(5);
        node.right = new KthSmallestElementInBST.TreeNode(6);
        node.left = new KthSmallestElementInBST.TreeNode(3);
        node.left.left = new KthSmallestElementInBST.TreeNode(2);
        node.left.right = new KthSmallestElementInBST.TreeNode(4);
        node.left.left.left = new KthSmallestElementInBST.TreeNode(1);

        // When
        int kthSmallest = new KthSmallestElementInBST().kthSmallest(node, 3);

        // Should
        assertEquals(3, kthSmallest);
    }

    @Test
    @DisplayName("test2")
    void test2() {
    	// Given
        KthSmallestElementInBST.TreeNode node = new KthSmallestElementInBST.TreeNode(5);
        node.right = new KthSmallestElementInBST.TreeNode(6);
        node.left = new KthSmallestElementInBST.TreeNode(3);
        node.left.left = new KthSmallestElementInBST.TreeNode(2);
        node.left.right = new KthSmallestElementInBST.TreeNode(4);
        node.left.left.left = new KthSmallestElementInBST.TreeNode(1);

    	// When
        int kthSmallest = new KthSmallestElementInBST().kthSmallest(node, 4);

        // Should
        assertEquals(4, kthSmallest);
    }

}