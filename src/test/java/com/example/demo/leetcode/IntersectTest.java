package com.example.demo.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class IntersectTest {

    @Test
    @DisplayName("testOne")
    void testOne() {
    	// Given
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

    	// When
        int[] intersect = new Intersect().intersect(nums1, nums2);

        // Then
        assertTrue(Arrays.equals(new int[]{2, 2}, intersect));
    }

}