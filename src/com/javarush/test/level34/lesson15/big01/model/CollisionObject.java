package com.javarush.test.level34.lesson15.big01.model;

/**
 * Created by vsevolodvisnevskij on 26.04.17.
 */
public abstract class CollisionObject extends GameObject {
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        switch (direction) {
            case UP:
                if (getX() == gameObject.getX() && getY() - Model.FIELD_SELL_SIZE == gameObject.getY()) {
                    return true;
                }
                break;
            case DOWN:
                if (getX() == gameObject.getX() && getY() + Model.FIELD_SELL_SIZE == gameObject.getY()) {
                    return true;
                }
                break;
            case LEFT:
                if (getX() - Model.FIELD_SELL_SIZE == gameObject.getX() && getY()== gameObject.getY()) {
                    return true;
                }
                break;
            case RIGHT:
                if (getX() + Model.FIELD_SELL_SIZE == gameObject.getX() && getY() == gameObject.getY()) {
                    return true;
                }
                break;
        }
        return false;
    }
}
