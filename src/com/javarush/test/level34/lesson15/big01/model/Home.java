package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by vsevolodvisnevskij on 26.04.17.
 */
public class Home extends GameObject {
    public Home(int x, int y) {
        super(x, y);
        setWidth(Model.FIELD_SELL_SIZE);
        setHeight(Model.FIELD_SELL_SIZE);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.drawOval(getX(), getY(), getWidth(), getHeight());
    }
}
