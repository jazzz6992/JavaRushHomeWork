package com.javarush.test.level28.lesson06.home01;

/**
 * Created by vsevolodvisnevskij on 26.12.16.
 */
public class MyThread extends Thread {
    private static int priority = 0;

    public MyThread() {
        setPriority(getCurPriority());
    }

    public MyThread(Runnable target) {
        super(target);
        setPriority(getCurPriority());
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        int pr = getCurPriority();
        setPriority(pr <= group.getMaxPriority() ? pr : group.getMaxPriority());
    }

    public MyThread(String name) {
        super(name);
        setPriority(getCurPriority());
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        int pr = getCurPriority();
        setPriority(pr <= group.getMaxPriority() ? pr : group.getMaxPriority());
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority(getCurPriority());
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        int pr = getCurPriority();
        setPriority(pr <= group.getMaxPriority() ? pr : group.getMaxPriority());
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        int pr = getCurPriority();
        setPriority(pr <= group.getMaxPriority() ? pr : group.getMaxPriority());
    }

    private int getCurPriority() {
        priority++;
        priority %= 10;
        if (priority == 0) {
            priority = 10;
        }
        return priority;
    }
}
