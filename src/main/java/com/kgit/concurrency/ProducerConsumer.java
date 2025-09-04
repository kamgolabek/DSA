package com.kgit.concurrency;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumer {

    private final Queue<Integer> queue = new ArrayDeque<>();
    private static final int LIMIT = 5;

    void main() {
        ProducerConsumer pc = new ProducerConsumer();
        ExecutorService es = Executors.newFixedThreadPool(2);

        es.submit(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    pc.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        es.submit(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        es.shutdown();
    }


    public synchronized void produce(Integer num) throws InterruptedException {
        while (queue.size() >= LIMIT) {
            log("producer waiting - queue is full");
            wait();
        }
        log("producer added: " + num);
        queue.add(num);
        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            log("consume waiting...");
            wait();
        }

        int result = queue.poll();
        log("consumer consumed: " + result);
        notifyAll();
        return result;
    }

    private void log(String message) {
        System.out.println(message);
    }


}
