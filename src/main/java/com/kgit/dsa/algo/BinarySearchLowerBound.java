package com.kgit.dsa.algo;

public class BinarySearchLowerBound {

    void main() {
        int[] arr = {0, 1, 1, 1, 2, 2, 3, 4, 5, 6};

        int index = binarySearchLowerBound(arr, 0, arr.length - 1, 2);

        System.out.println(index);
    }

    private int binarySearchLowerBound(int[] arr, int leftIndex, int rightIndex, int target) {
        if (leftIndex >= rightIndex) {
            return leftIndex;
        }

        int mid = leftIndex + (rightIndex - leftIndex) / 2;

        if (arr[mid] < target) {
            return binarySearchLowerBound(arr, mid + 1, rightIndex, target);
        } else {
            return binarySearchLowerBound(arr, leftIndex, mid, target);
        }
    }
}
