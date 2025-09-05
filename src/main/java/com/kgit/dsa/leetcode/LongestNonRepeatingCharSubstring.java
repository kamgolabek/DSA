package com.kgit.dsa.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingCharSubstring {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;

        while (right < s.length()) {
            char c = s.charAt(right);

            // duplicate found
            if (lastIndex.containsKey(c) && lastIndex.get(c) >= left) {
                left = lastIndex.get(c) + 1;
            }

            lastIndex.put(c, right);
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}

/**
 * abcdafghib
 */
