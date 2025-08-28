package com.kgit.dsa.leetcode;

public class SortColors3WayPartitioning {

    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low++, mid++);
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high--);
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

/**
 * #1 [2,0,1] -> [0, 1, 2]
 * #2 [2,0,2,1,1,0] -> [0,0,1,1,2,2]
 * <p>
 * <p>
 * low = 0, mid = 0, high = n-1
 * <p>
 * [0, low -1] -> 0s
 * [low, mid-1] -> 1s
 * [mid, high-1] -> unprocessed
 * [high, n-1] -> 2s
 * <p>
 * while(mid < high)
 */

