package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by vsevolodvisnevskij on 11.11.16.
 */
public class Hippodrome {
    ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                move();
                print();
                Thread.sleep(200);
            } catch (InterruptedException ex) {

            }
        }
    }

    public void move() {
        for (Horse horse :
                getHorses()) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse :
                getHorses()) {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner() {
        double max = 0;

        Horse winner = null;
        for (Horse horse :
                getHorses()) {
            if (horse.distance > max) {
                max = horse.distance;
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().name + "!");
    }

    public static void main(String[] args) {
        game = new Hippodrome();
        Horse horse = new Horse("Spirit", 3, 0);
        Horse horse1 = new Horse("Wind", 3, 0);
        Horse horse2 = new Horse("Saint's Little Helper", 3, 0);
        game.getHorses().add(horse);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.run();
        game.printWinner();

    }
}
