package com.kgit.dsa.leetcode;

import java.util.*;

public class GroupAnagrams {
    void main() {
        List<String> words = Arrays.asList("abc", "cab", "de", "ed", "gh");
        List<List<String>> groupedAnagrams = groupAnagrams(words);
        System.out.println(groupedAnagrams);
    }

    private List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> anagramKeyToWords = new HashMap<>();
        for (String word : words) {
            String key = anagramKey(word);
            anagramKeyToWords.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : anagramKeyToWords.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private String anagramKey(String word) {
        int[] charCount = new int[26];
        for (int i = 0; i < word.length(); i++) {
            charCount[word.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charCount.length; i++) {
            sb.append(charCount[i]);
        }
        return sb.toString();
    }
}
