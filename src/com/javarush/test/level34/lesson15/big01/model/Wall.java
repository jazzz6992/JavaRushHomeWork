package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by vsevolodvisnevskij on 26.04.17.
 */
public class Wall extends CollisionObject {
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        graphics.drawRect(getX(), getY(), getWidth(), getHeight());
    }
}
