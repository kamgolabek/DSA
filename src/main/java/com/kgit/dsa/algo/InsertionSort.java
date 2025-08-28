package com.kgit.dsa.algo;

import java.util.Arrays;

public class InsertionSort {

    void main() {
        int[] nums = new int[]{6, 1, 4, 2};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * start at index 1, move element at index to left until correctly placed.. repeat
     * @param nums
     */
    private void insertionSort(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            int currentVal = nums[i];
            int compareIndex = i - 1;
            while(compareIndex >= 0 && currentVal < nums[compareIndex]){
                nums[compareIndex+1] = nums[compareIndex];
                compareIndex--;
            }
            nums[compareIndex+1] = currentVal;
        }
    }
}
// [2,3,4]
