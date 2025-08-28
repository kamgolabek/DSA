package com.kgit.dsa.algo;

public class BinarySearchUpperBound {

    void main() {
        int[] arr = {1, 3, 5, 5, 5, 7, 9};

        int index = upperBoundBinary(arr, 0, arr.length - 1, 3);

        System.out.println(index);
    }

    // Goal is to return FIRST index with value bigger than target
    private int upperBoundBinary(int[] arr, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
