package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alex on 16.12.2016.
 */
public class Producer implements Runnable
{
    ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map)
    {
        this.map = map;
    }

    @Override
    public void run()
    {
        int i = 1;
        try
        {
            while (true) {
                map.put(String.valueOf(i), "Some text for " + i);
                Thread.sleep(500);
                i++;
            }

        } catch (InterruptedException e) {
            System.out.println("[" + Thread.currentThread().getName() + "] thread was terminated");
        }

    }
}
