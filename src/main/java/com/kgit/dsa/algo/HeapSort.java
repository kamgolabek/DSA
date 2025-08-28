package com.kgit.dsa.algo;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSort {

    void main() {
        int[] arr = {6, 2, 4, 1, 9, 23, 12};


        int result = kThSmallest(arr, 2);

        System.out.println(result);

    }

    private int kThSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays.stream(arr).boxed().toList());

        for (int i = 0; i < k; i++) {
            pq.poll();
        }

        return pq.poll();
    }
}
