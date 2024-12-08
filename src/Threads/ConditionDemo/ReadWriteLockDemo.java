package Threads.ConditionDemo;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    private int counter = 0;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void increment() {
        lock.writeLock().lock();
        try {
            counter++;
            System.out.println(Thread.currentThread().getName() + " - Write: " + counter);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void readValue() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " - Read: " + counter);
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockDemo shared = new ReadWriteLockDemo();

        // Reader Threads
        for (int i = 0; i < 2; i++) {
            Thread readerThread = new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    shared.readValue();
                }
            });
            readerThread.setName("Reader Thread " + (i + 1));
            readerThread.start();
        }

        // Writer Thread
        Thread writerThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shared.increment();
            }
        });
        writerThread.setName("Writer Thread");
        writerThread.start();
    }
}
