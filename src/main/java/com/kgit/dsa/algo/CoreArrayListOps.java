package com.kgit.dsa.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoreArrayListOps {
    void main() {
        // create an array with values
        int[] arr1 = {1, 2, 3};

        // create an array with capacity
        int[] arr2 = new int[26];

        // create immutable List from array - because collect(Collectors.toList()) gives mutable list
        List<Integer> mutableListFromArray1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());

        // but only in java 16+ (toList() is since 16)
        List<Integer> immutableListFromArray1 = Arrays.stream(arr1).boxed().toList();

        //List<Integer> immutableListFromArray1 = List.of(listFromAray1); // todo from small int to Integer

        // create an ArrayList with values - partially immutable,
        // we cannot add/remove elements from it (fixed size), but we can change elements
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        // list1.add(4);  --> UnsupportedOperationException
        // list1.remove(2); --> UnsupportedOperationException
        list1.set(0, -1); // works

        // fully immutable List -  add/remove/set throws UnsupportedOperationException
        List<Integer> list2 = List.of(1, 2, 3);
        // list2.add(4); --> UnsupportedOperationException
        // list2.remove(0); --> UnsupportedOperationException
        // list2.set(0, -1); --> UnsupportedOperationException

        // fully mutable list
        List<Integer> listMutable = new ArrayList<>(Arrays.asList(1, 2, 3));
        listMutable.add(4);
        listMutable.remove(1);
        listMutable.set(0, -1);
        System.out.println(listMutable);

        // fully mutable
        List<Integer> listMutable2 = new ArrayList<>(26);
        listMutable2.add(1);
        listMutable2.add(2);
        listMutable2.add(3);
        listMutable2.add(4);

        listMutable2.remove(1);
        listMutable2.set(0, -1);
        System.out.println(listMutable2);
    }


}
