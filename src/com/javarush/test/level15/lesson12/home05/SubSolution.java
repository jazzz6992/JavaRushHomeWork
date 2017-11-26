package com.javarush.test.level15.lesson12.home05;

/**
 * Created by vsevolodvisnevskij on 19.10.16.
 */
public class SubSolution extends Solution {
    SubSolution() {
    }

    SubSolution(int x) {
        super(x);
    }

    SubSolution(double x) {
        super(x);
    }

    public SubSolution(String s) {
        super(s);
    }

    public SubSolution(Object o) {
        super(o);
    }

    public SubSolution(float f) {
        super(f);
    }

    protected SubSolution(boolean b) {
        super(b);
    }

    protected SubSolution(byte b) {
        super(b);
    }

    protected SubSolution(short s) {
        super(s);
    }

    private SubSolution(long l) {
        super();
    }

    private SubSolution(char c) {
        super();
    }

    private SubSolution(int x, int y) {
        super();
    }
}
