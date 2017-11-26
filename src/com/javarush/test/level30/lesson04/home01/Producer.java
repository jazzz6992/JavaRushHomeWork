package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by Alex on 30.01.2017.
 */
public class Producer implements Runnable
{
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        for (int i = 1; i < 10; i++)
        {
            System.out.println(String.format("Элемент 'ShareItem-%d' добавлен", i));
            queue.offer(new ShareItem("ShareItem-" + i, i));
            try
            {
                Thread.sleep(100);
                if (queue.hasWaitingConsumer()) {
                    System.out.println("Consumer в ожидании!");
                }
            }
            catch (InterruptedException e)
            {
return;
            }
        }

    }
}
