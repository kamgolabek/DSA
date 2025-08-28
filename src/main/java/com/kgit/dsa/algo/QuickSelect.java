package com.kgit.dsa.algo;

public class QuickSelect {
    void main() {
        int[] arr = {3, 1, 7, 4, 9, 5};

        int result = quickSelect(arr, 0, arr.length - 1, 7);

        System.out.println(result);
    }

    private int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        int pivotIndex = partitionLomuto(arr, left, right);

        if (k == pivotIndex) {
            return arr[pivotIndex];
        } else if (k < pivotIndex) {
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }

    private int partitionLomuto(int[] arr, int left, int right) {
        int pivotValue = arr[right];
        int lePivotIndex = left - 1;

        for (int i = left; i < right; i++) {
            if (arr[i] <= pivotValue) {
                lePivotIndex++;
                int temp = arr[lePivotIndex];
                arr[lePivotIndex] = arr[i];
                arr[i] = temp;
            }
        }

        // swap pivot with lePivotIndex +1
        int temp = arr[lePivotIndex + 1];
        arr[lePivotIndex + 1] = arr[right];
        arr[right] = temp;

        return lePivotIndex + 1;
    }
}
