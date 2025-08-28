package com.kgit.dsa.leetcode;

public class BinarySearch {

    public int search(int[] nums, int target) {
        return searchRecursive(nums, 0, nums.length - 1, target);
    }

    private int searchRecursive(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return searchRecursive(nums, mid + 1, right, target);
        } else {
            return searchRecursive(nums, left, mid - 1, target);
        }
    }


    public int searchIterative(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
