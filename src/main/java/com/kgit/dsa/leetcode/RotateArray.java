package com.kgit.dsa.leetcode;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % nums.length] = nums[i];
        }

        System.arraycopy(result, 0, nums, 0, nums.length);
    }


/**
 [-1,-100,3,99] k=2 ===> [3, 99, -1, -100]


 [1, 2, 3]

 k = 2
 n = 3

 0: (0 + 2) % 3 = 2
 1: (1 + 2) % 3 = 0
 2: (2 + 2) % 3 = 1

 -> [2,3,1]
 */
}
