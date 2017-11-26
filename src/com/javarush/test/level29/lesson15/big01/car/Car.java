package com.javarush.test.level29.lesson15.big01.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (!isSummer(date, SummerStart, SummerEnd)) {
            consumption = getWinterConsumption(length);
        } else {
            consumption = getSummerConsumption(length);
        }
        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (canPassengersBeTransferred()) {
            return numberOfPassengers;
        }

        return 0;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
        fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();

    public static Car create(int type, int numberOfPassengers) {
        if (type == 0) {
            return new Truck(numberOfPassengers);
        } else if (type == 1) {
            return new Sedan(numberOfPassengers);
        } else if (type == 2) {
            return new Cabriolet(numberOfPassengers);
        } else {
            return null;
        }
    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        return (date.getTime() >= summerStart.getTime() && date.getTime() < summerEnd.getTime());
    }

    public double getWinterConsumption(int length) {
        double consumption;
        consumption = length * winterFuelConsumption + winterWarmingUp;
        return consumption;
    }

    public double getSummerConsumption(int length) {
        double consumption;
        consumption = length * summerFuelConsumption;
        return consumption;
    }

    private boolean canPassengersBeTransferred() {
        if (driverAvailable && fuel > 0) {
            return true;
        }
        return false;
    }
}
