package com.example.demo.leetcode;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0 || target < nums[0]) {
            return 0;
        }

        if(target > nums[nums.length - 1]) {
            return nums.length;
        }


        int result = 0;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {

            int middle = start + (end - start) / 2;

            int currentValue = nums[middle];
            if(currentValue == target) {
                return middle;
            } else if(currentValue < target) {
                start = middle + 1;
            } else {
                result = middle;
                end = middle - 1;
            }

        }

        return result;
    }
}
