package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by vsevolodvisnevskij on 26.04.17.
 */
public class Player extends CollisionObject implements Movable {
    @Override
    public void move(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.blue);
        graphics.fillOval(getX(), getY(), getWidth(), getHeight());
    }

    public Player(int x, int y) {
        super(x, y);
    }
}
