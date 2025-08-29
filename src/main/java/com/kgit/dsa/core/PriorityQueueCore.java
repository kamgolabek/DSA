package com.kgit.dsa.core;

import java.util.*;

public class PriorityQueueCore {
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(Arrays.asList(4, 7, 2));

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

        System.out.println();

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        pq2.addAll(Arrays.asList(4, 7, 2));

        while(!pq2.isEmpty()){
            System.out.println(pq2.poll());
        }

        System.out.println();
        System.out.println("pq with map");
        Map<String, Integer> map = new HashMap<>();
        map.put("Kamil", 32);
        map.put("Sylwia", 28);
        map.put("Roche", 1);

        PriorityQueue<Map.Entry<String,Integer>> pq3 = new PriorityQueue<>(Map.Entry.comparingByValue());
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            pq3.offer(entry);
            if(pq3.size() > 2){
                pq3.poll();
            }
        }
       // pq3.addAll(map.entrySet());

        while(!pq3.isEmpty()){
            System.out.println(pq3.poll());
        }



    }
}
