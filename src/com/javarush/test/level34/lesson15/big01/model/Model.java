package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vsevolodvisnevskij on 26.04.17.
 */
public class Model {
    public final static int FIELD_SELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("/Users/vsevolodvisnevskij/IdeaProjects/JavaRushHomeWork/JavaRushHomeWork/src/com/javarush/test/level34/lesson15/big01/res/levels.txt"));

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel++;
        restartLevel(currentLevel);
    }

    public void move(Direction direction) {
        Player player = getGameObjects().getPlayer();
        if (checkWallCollision(player, direction)) {
            return;
        }
        if (checkBoxCollision(direction)) {
            return;
        }
        switch (direction) {
            case UP:
                player.move(0, -FIELD_SELL_SIZE);
                break;
            case DOWN:
                player.move(0, FIELD_SELL_SIZE);
                break;
            case LEFT:
                player.move(-FIELD_SELL_SIZE, 0);
                break;
            case RIGHT:
                player.move(FIELD_SELL_SIZE, 0);
                break;
        }
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        Set<Wall> walls = getGameObjects().getWalls();
        for (Wall w : walls) {
            if (gameObject.isCollision(w, direction)) {
                return true;
            }
        }
        return false;
    }

//    public boolean checkBoxCollision(Direction direction) {
//        Player player = getGameObjects().getPlayer();
//        Set<Box> boxes = getGameObjects().getBoxes();
//        for (Box box : boxes) {
//            if (player.isCollision(box, direction)) {
//                for (Box box1 : boxes) {
//                    if (box.isCollision(box1, direction) || checkWallCollision(box, direction)) {
//                        return true;
//                    } else {
//                        switch (direction) {
//                            case UP:
//                                box.move(0, -FIELD_SELL_SIZE);
//                                return false;
//                            case DOWN:
//                                box.move(0, FIELD_SELL_SIZE);
//                                return false;
//                            case LEFT:
//                                box.move(-FIELD_SELL_SIZE, 0);
//                                return false;
//                            case RIGHT:
//                                box.move(FIELD_SELL_SIZE, 0);
//                                return false;
//                        }
//                    }
//                }
//            }
//        }
//        return false;
//    }

    public boolean checkBoxCollision(Direction direction){


        Player player = gameObjects.getPlayer();


        // найдем во что уперся игрок
        GameObject  stoped = null;
        for (GameObject gameObject: gameObjects.getAll()){
            if (!(gameObject instanceof Player)&&!(gameObject instanceof Home) && player.isCollision(gameObject, direction)){
                stoped = gameObject;
            }
        }
        //свободное место или дом
        if ((stoped == null)){
            return false;
        }
        if (stoped instanceof Box){
            Box stopedBox = (Box)stoped;
            if (checkWallCollision(stopedBox, direction)){
                return true;
            }
            for (Box box : gameObjects.getBoxes()){
                if(stopedBox.isCollision(box, direction)){
                    return true;
                }
            }
            switch (direction)
            {
                case LEFT:
                    stopedBox.move(-FIELD_SELL_SIZE, 0);
                    break;
                case RIGHT:
                    stopedBox.move(FIELD_SELL_SIZE, 0);
                    break;
                case UP:
                    stopedBox.move(0, -FIELD_SELL_SIZE);
                    break;
                case DOWN:
                    stopedBox.move(0, FIELD_SELL_SIZE);
            }
        }
        return false;


    }

    public void checkCompletion() {
        Set<Home> homes = getGameObjects().getHomes();
        Set<Box> boxes = getGameObjects().getBoxes();
        boolean isAllOk = true;
        for (Home h : homes) {
            boolean isOk = false;
            for (Box b : boxes) {
                if (h.getX() == b.getX() && h.getY() == b.getY()) {
                    isOk = true;
                    break;
                }
            }
            if (!isOk) {
                isAllOk = false;
            }
        }
        if (isAllOk) {
            eventListener.levelCompleted(currentLevel);
        }
    }
}
