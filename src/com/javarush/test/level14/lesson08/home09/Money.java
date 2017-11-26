package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    private double ammount;
    public Money(double amount)
    {
        this.ammount = amount;
    }

    public double getAmount() {
        return ammount;
    }

    public abstract String getCurrencyName();
}

