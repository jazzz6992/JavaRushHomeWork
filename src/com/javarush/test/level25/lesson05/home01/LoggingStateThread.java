package com.javarush.test.level25.lesson05.home01;

/**
 * Created by vsevolodvisnevskij on 12.12.16.
 */
public class LoggingStateThread extends Thread {
    Thread t;

    public LoggingStateThread(Thread thread) {
        t = thread;
        setDaemon(true);
    }

    @Override
    public void run() {
        Thread.State state = t.getState();
        System.out.println(state);
        while (state != State.TERMINATED) {
            if (state != t.getState()) {
                state = t.getState();
                System.out.println(state);
            }
        }
    }
}
