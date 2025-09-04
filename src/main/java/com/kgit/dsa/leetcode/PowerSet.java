package com.kgit.dsa.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {

    void main() {
        List<Integer> nums = Arrays.asList(1, 2, 3);
        List<List<Integer>> result = new ArrayList<>();
        powerSet(nums, 0, new ArrayList<>(), result);

        System.out.println(result);
    }

    private static void powerSet(List<Integer> nums, int start, List<Integer> partial, List<List<Integer>> result) {
        if (start == nums.size()) {
            result.add(new ArrayList<>(partial));
            return;
        }

        int num = nums.get(start);
        powerSet(nums, start + 1, partial, result);

        partial.add(num);
        powerSet(nums, start + 1, partial, result);

        partial.remove(partial.size() - 1);

    }
}
