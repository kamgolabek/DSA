package com.kgit.dsa.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChar {

    public static void main(String[] args){
        String word = "aaabcdddd";
        int length = longestSubstring(word);

        System.out.println(length);
    }

    /**
     *
     * 'abcadef'
     *  'abcbdef
     *
     */
    private static int longestSubstring(String word){
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < word.length(); i++){
            Character c = word.charAt(i);
            if(map.containsKey(c) && map.get(c) >= left){
                left = map.get(c) + 1;
            }
            map.put(c, i);
            max = Integer.max(max, i - left);
        }

        return max;
    }
}
