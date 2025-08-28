package com.kgit.dsa.leetcode;

public class SortArrayWithMergeSort {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int[] mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return new int[]{nums[left]};
        }

        int mid = left + (right - left) / 2;
        int[] leftSorted = mergeSort(nums, left, mid);
        int[] rightSorted = mergeSort(nums, mid + 1, right);

        return merge(leftSorted, rightSorted);
    }

    private int[] merge(int[] left, int[] right) {
        int l = 0;
        int r = 0;
        int[] result = new int[left.length + right.length];
        int resultIndex = 0;

        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                result[resultIndex++] = left[l++];
            } else {
                result[resultIndex++] = right[r++];
            }
        }

        while (l < left.length) {
            result[resultIndex++] = left[l++];
        }

        while (r < right.length) {
            result[resultIndex++] = right[r++];
        }

        return result;
    }
}
