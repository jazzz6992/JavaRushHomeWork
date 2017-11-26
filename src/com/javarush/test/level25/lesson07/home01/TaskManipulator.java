package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread t;

    @Override
    public void run() {
        if (!t.isInterrupted()) {
            while (!t.isInterrupted()) {
                try
                {
                    System.out.println(t.getName());
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    return;
                }
            }
        }
    }


    @Override
    public void start(String threadName)
    {
        t = new Thread(this, threadName);
        t.start();
    }

    @Override
    public void stop()
    {
    t.interrupt();
    }
}
