package com.kgit.dsa.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueChar {

    public int firstUniqueCharOptimized(String s) {
        int[] chars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public int firstUniqueCharLOWPerf(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }

        Character match = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                match = entry.getKey();
                break;
            }
        }

        if (match == null) {
            return -1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == match) {
                return i;
            }
        }

        return -1;
    }
}
