package com.kgit.dsa.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int diff = target - val;
            if (valueToIndexMap.containsKey(diff)) {
                return new int[]{i, valueToIndexMap.get(diff)};
            }
            valueToIndexMap.put(val, i);
        }

        return new int[]{};
    }
}
