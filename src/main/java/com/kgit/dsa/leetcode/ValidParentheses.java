package com.kgit.dsa.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ValidParentheses {

    void main(){
        System.out.println(isValid("{[()]}"));
    }

    public boolean isValid(String s) {
        if (s.isEmpty()) return true;
        Map<Character, Character> pairs = Map.of(
                '(', ')',
                '[', ']',
                '{', '}'
        );

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (pairs.containsKey(c)) {
                stack.addFirst(pairs.get(c));
            } else {
                if (stack.isEmpty() || c != stack.poll()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}


/**
 * "()" -> true
 * "[()]" -> true
 * "{[()]}" -> true
 * <p>
 * curr: '{'  -> stack: ['}']
 * curr: '[' -> stack: [']', '}']
 * curr: '(' -> stack: [')', ']', '}']
 * <p>
 * if(openingBracket){
 * putClosingBracketOnStack
 * }else{
 * if(currentBracket != stack.poll()){
 * return false;
 * }
 * }
 */

