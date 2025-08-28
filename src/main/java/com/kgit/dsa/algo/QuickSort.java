package com.kgit.dsa.algo;

import java.util.Arrays;

public class QuickSort {

    void main(){
        int[] arr = {4, 1, 9, 2, 6};
        quickSort(arr, 0 , arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    private void quickSort(int[] arr, int left, int right) {
        if(left < right){
            int pivot = partitionLomuto(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    /**
     * Initially all elemtns are assumed to be bigger than pivot -> thats why 'i' is kep at index low -1
     * If any elements is smaller than pivot, then we swapped that element with pivotIndex+1
     *
     It swaps elements in place, shifts "<= pivot" index - i, and finally place pivot at i+1 (swap)
     */
    private int partitionLomuto(int[] arr, int left, int right) {
        int pivotValue = arr[right];
        int lePivotIndex = left -1;

        for(int i = left; i < right; i++){
            if(arr[i] <= pivotValue){
                lePivotIndex++;
                int temp = arr[i];
                arr[i] = arr[lePivotIndex];
                arr[lePivotIndex] = temp;
            }
        }

        int temp = arr[right];
        arr[right] = arr[lePivotIndex + 1];
        arr[lePivotIndex + 1] = temp;

        return lePivotIndex + 1;
    }
}
