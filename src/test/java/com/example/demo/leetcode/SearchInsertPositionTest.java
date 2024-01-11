package com.example.demo.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInsertPositionTest {

    private final SearchInsertPosition subject = new SearchInsertPosition();

    @Test
    void testOneTest() {
        int[] input = {1,3,5,6};
        int target = 5;
        int result = subject.searchInsert(input, target);

        assertEquals(2, result);
    }

    @Test
    void testTwoTest() {
        int[] input = {1,3,5,6};
        int target = 2;
        int result = subject.searchInsert(input, target);

        assertEquals(1, result);
    }

    @Test
    void testThreeTest() {
        int[] input = {1,3,5,6};
        int target = 7;
        int result = subject.searchInsert(input, target);

        assertEquals(4, result);
    }

    @Test
    @DisplayName("TestFour")
    void testFour() {
        int[] input = {1,3};
        int target = 2;
        int result = subject.searchInsert(input, target);

        assertEquals(1, result);
    }

}