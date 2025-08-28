package com.kgit.dsa.leetcode;

import java.util.Arrays;

/**
 * Uses binary search
 */
public class FirstAndLastPositionOfElementInSortedArray {

    void main() {
        int[] nums = {1, 1, 1, 2, 2, 3, 4, 4, 4, 4, 5, 6, 7, 7};
        System.out.println(Arrays.toString(searchRange(nums, 2)));
    }

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int foundIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                foundIndex = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (foundIndex == -1) {
            return new int[]{-1, -1};
        }

        int leftIndex = foundIndex;
        int rightIndex = foundIndex;

        for (int i = leftIndex - 1; i >= 0; i--) {
            if (nums[i] == target) {
                leftIndex--;
            } else {
                break;
            }
        }

        for (int i = rightIndex + 1; i < nums.length; i++) {
            if (nums[i] == target) {
                rightIndex++;
            } else {
                break;
            }
        }

        return new int[]{leftIndex, rightIndex};
    }
}
