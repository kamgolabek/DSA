package com.kgit.dsa.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PalindromePartitioning {

    AtomicInteger counter = new AtomicInteger();

    void main() {
        PalindromePartitioning solver = new PalindromePartitioning();
        String s = "a";
        List<List<String>> partitions = solver.partition(s);
        System.out.println(partitions);
    }


    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), result, counter.incrementAndGet());
        return result;
    }

    private void dfs(String s, int start, List<String> path, List<List<String>> result, int callId) {
        log(callId, start, path, "invoked");
        // Base case: reached end of string → found one valid partition
        if (start == s.length()) {
            log(callId, start, path, "start == length , adding path to result");
            result.add(new ArrayList<>(path)); // copy of current path
            return;
        }

        // Try all substrings starting at `start`
        for (int end = start; end < s.length(); end++) {
            log(callId, start, path, "for loop, end = " + end);
            String substr = s.substring(start, end + 1);
            if (isPalindrome(substr)) {
                log(callId, start, path, "found palindrome: " + substr);
                path.add(substr);                 // choose
                log(callId, start, path, "calling dfs with end: " + (end + 1));
                dfs(s, end + 1, path, result, counter.incrementAndGet());    // explore deeper
                log(callId, start, path, "after dfs call, removing last result from path: " + path);
                path.remove(path.size() - 1);     // backtrack (undo choice)
            } else {
                log(callId, start, path, "not palindrome: " + substr);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    private void log(int callId, int start, List<String> path, String msg) {
        System.out.println(callId + " dfs(start: " + start + ", path: " + path + ")  - " + msg);
    }
}

/**
 * aab
 * a,a,b
 *
 */