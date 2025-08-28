package com.kgit.dsa.algo;

import java.util.Arrays;

public class BubbleSort {

    void main() {
        int[] values = {45, 77, 11, 4, 84};
//        bubbleSort(values);
        System.out.println(Arrays.toString(values));

        bubbleSortRecursive(values, values.length);
        System.out.println(Arrays.toString(values));
    }


    private void bubbleSortRecursive(int[] values, int n) {
        if(n == 1) {
            return;
        }

        for(int i = 0; i < n -1; i++){
            if (values[i] > values[i + 1]) {
                int temp = values[i];
                values[i] = values[i + 1];
                values[i + 1] = temp;
            }
        }

        bubbleSortRecursive(values, n-1);
    }


    private void bubbleSort(int[] values) {
        int n = values.length;

        for (int i = 0; i < n; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                System.out.println("compares " + i + " : " + j);
                if (values[j] > values[j + 1]) {
                    int temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
