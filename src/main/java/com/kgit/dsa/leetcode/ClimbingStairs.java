package com.kgit.dsa.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    void main() {
        System.out.println(climbStairsRecursive(5));
        System.out.println(climbStairsBottomUp(5));
    }


    //-------------- ITERATIVE -----------
    public int climbStairsBottomUp(int n) {
        if (n <= 1) {
            return 1;
        }

        int prev1 = 1;
        int prev2 = 1;

        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }

        return prev2;
    }

    // --------- RECURSIVE BELOW -------

    public int climbStairsRecursive(int n) {
        return climbStep(n, new HashMap<Integer, Integer>());
    }

    private int climbStep(int n, Map<Integer, Integer> mem) {
        if (n <= 1) {
            return 1;
        }

        if (mem.containsKey(n)) {
            return mem.get(n);
        }

        int result = climbStep(n - 1, mem) + climbStep(n - 2, mem);
        mem.put(n, result);
        return result;
    }
}
