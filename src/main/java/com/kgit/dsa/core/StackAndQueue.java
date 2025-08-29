package com.kgit.dsa.core;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * Stack methods:
 *  - push
 *  - pop
 *  - peek
 *
 *  Queue methods
 */
public class StackAndQueue {
    public static void main(String[] args){
        // Dequeue is th interface providing stack-like methods
        Deque<Integer> stack = new ArrayDeque<>();

        // in stack you add and read from first position
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(5);

        // it should be 3,2,1
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

        System.out.println();
        System.out.println("queue");
        System.out.println();

        // Queue provides queue-like methods
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(2);
        queue.offer(4);
        queue.offer(1);

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }
}
