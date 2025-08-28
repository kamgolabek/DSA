package com.kgit.dsa.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        int wordStart = -1;
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            // char is not space
            if (s.charAt(i) != ' ') {
                // new word beginning
                if (wordStart == -1) {
                    wordStart = i;
                }
            } else {
                if (wordStart != -1) {
                    stack.addFirst(s.substring(wordStart, i)); // or i+1
                    wordStart = -1;
                }
            }
        }

        if (wordStart != -1) {
            stack.addFirst(s.substring(wordStart, s.length()));
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.poll());
            if (!stack.isEmpty()) {
                sb.append(" ");
            }
        }

        return sb.toString();

    }
}
