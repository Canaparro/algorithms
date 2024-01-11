package com.example.demo.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubarraySumTest {

    private final SubarraySum subject = new SubarraySum();

    @Test
    @DisplayName("testOne")
    void testOne() {
    	// Given
        int[] nums = {1,1,1};

    	// When
        int result = subject.subarraySum(nums, 2);

        // Then
        assertEquals(2, result);
    }

    @Test
    @DisplayName("testTwo")
    void testTwo() {
        // Given
        int[] nums = {1,2,3};

        // When
        int result = subject.subarraySum(nums, 3);

        // Then
        assertEquals(2, result);
    }

    @Test
    @DisplayName("testThree")
    void testThree() {
    	// Given
        int[] nums = {1,-1,0};

        // When
        int result = subject.subarraySum(nums, 0);

        // Then
        assertEquals(3, result);
    }

    @Test
    @DisplayName("testFour")
    void testFour() {
        // Given
        int[] nums = {0,0};

        // When
        int result = subject.subarraySum(nums, 0);

        // Then
        assertEquals(3, result);
    }

    @Test
    @DisplayName("testFive")
    void testFive() {
    	// Given
        int[] nums = {2,3,-4,4,5,6};

        // When
        int result = subject.subarraySum(nums, 5);

        // Then
        assertEquals(4, result);
    }
}