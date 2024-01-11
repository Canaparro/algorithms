package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;

        List<Integer> ocurrences = new LinkedList<>();

        while (i < nums1.length && j < nums2.length) {

            if(nums1[i] > nums2[j]) {
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                ocurrences.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] result = new int[ocurrences.size()];
        for (int k = 0; k < result.length; k++) {
            result[k] = ocurrences.get(k);
        }
        return result;
    }
}
