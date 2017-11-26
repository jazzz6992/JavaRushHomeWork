package com.javarush.test.level30.lesson06.home01;

import java.util.concurrent.RecursiveTask;

/**
 * Created by vsevolodvisnevskij on 02.02.17.
 */
public class BinaryRepresentationTask extends RecursiveTask<String> {
    int i;
    public BinaryRepresentationTask(int i) {
        this.i = i;
    }

    @Override
    protected String compute() {
        int a = i % 2;
        int b = i / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            BinaryRepresentationTask bin = new BinaryRepresentationTask(b);
            bin.fork();
            return bin.join() + result;
        } else {
            return result;
        }
    }
}
