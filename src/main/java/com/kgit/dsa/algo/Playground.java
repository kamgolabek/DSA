package com.kgit.dsa.algo;

import java.util.*;

public class Playground {

    public static void main(String[] args) {
        Deque<Integer> d = new ArrayDeque<>();
        d.addFirst(1);
        groupAnagrams();
    }

    private static void groupAnagrams(){
        List<String> words = new ArrayList<>(Arrays.asList("abc", "cba", "def", "ghi", "igh"));

        List<List<String>> anagramsGrouped = doGroupAnagrams(words);
        System.out.println(anagramsGrouped);
    }

    private static List<List<String>> doGroupAnagrams(List<String> words) {
        Map<String, List<String>> wordsByAnagramKey = new HashMap<>();

        for(String word : words){
            String key = anagramKey(word);
            wordsByAnagramKey.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        List<List<String>> result = new ArrayList<>(wordsByAnagramKey.values());

        return result;
    }

    private static String anagramKey(String word){
        int[] occur = new int[26];
        for(int i = 0; i < word.length(); i++){
            occur[word.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            sb.append(occur[i]);
        }

        return sb.toString();
    }

    private static void kThsLargestElement(){
        List<Integer> nums = new ArrayList<>(Arrays.asList(7, 2, 4, 9));
        int k = 2;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(nums);
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < k; i++){
            result.add(pq.poll());
        }

        System.out.println(result);
    }
}
