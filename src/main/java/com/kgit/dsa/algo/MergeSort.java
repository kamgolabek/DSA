package com.kgit.dsa.algo;

import java.util.Arrays;

public class MergeSort {

    void main() {
//        int[] sortedA = {1, 3, 5};
//        int[] sortedB = {2, 4};
//
//        int[] merged = mergeStep(sortedA, sortedB);
//
//        System.out.println(Arrays.toString(merged));
        int[] arr = {4, 1, 9, 2, 22, 12, 11, 33, 23};

        int[] result = mergeSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(result));
    }

    int[] mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return new int[]{arr[left]};
        }

        int mid = (left + right) / 2;
        int[] leftSorted = mergeSort(arr, left, mid);
        int[] rightSorted = mergeSort(arr, mid + 1, right);

        return mergeStep(leftSorted, rightSorted);
    }

    int[] mergeStep(int[] left, int[] right) {
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
