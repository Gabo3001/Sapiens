/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author HOME
 */
public class Player extends Item {

    private int direction;
    private int width;
    private int height;
    private Game game;
    private int speed;
    private Animation animationRight;
    private Animation animationLeft;

    public Player(int x, int y, int direction, int width, int height, Game game) {
        super(x, y);
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
        this.speed = direction;
        this.animationRight = new Animation(Assets.playerRight, 100);
        this.animationLeft = new Animation(Assets.playerLeft, 100);
    }

    public int getDirection() {
        return direction;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void tick() {
        if (!game.isPause()) {
            if (game.getKeyManager().left) {
                this.animationLeft.tick();
                setX(getX() - getSpeed());
            }
            if (game.getKeyManager().right) {
                this.animationRight.tick();
                setX(getX() + getSpeed());
            }
            // reset x position and y position if colision
            if (getX() + 60 >= game.getWidth()) {
                setX(game.getWidth() - 60);
            } else if (getX() <= 0) {
                setX(0);
            }
        }

    }

    /**
     * Funtion that get the perimeter of the player
     *
     * @return a rectangle with the perimeter of the player
     */
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    /**
     * Function that check if the player intersects with an especifc object
     *
     * @param obj An object from the class Fruit
     * @return true when player intersects with a fruit
     */
    public boolean intersecta(Object obj) {
        return obj instanceof Fruit && getPerimetro().intersects(((Fruit) obj).getPerimetro());
    }

    @Override
    public void render(Graphics g) {
        if (game.getKeyManager().right && !game.isPause()) {
            g.drawImage(animationRight.getCurretFrame(), getX(), getY(), getHeight(), getWidth(), null);
        } else if (game.getKeyManager().left && !game.isPause()) {
            g.drawImage(animationLeft.getCurretFrame(), getX(), getY(), getHeight(), getWidth(), null);
        } else {
            g.drawImage(Assets.playerLevel1, getX(), getY(), getHeight(), getWidth(), null);
        }
    }
}
