package com.example.demo.leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleTest {

    @Test
    @DisplayName("testOne")
    void testOne() {
        assertTrue(new CourseSchedule().canFinish(5, new int[][]{{1,4},{2,4},{3,1},{3,2}}));
    }

}