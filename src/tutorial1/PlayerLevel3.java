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
public class PlayerLevel3 extends Item {

    private int direction;
    private int width;
    private int height;
    private Game game;
    private int speed;

    public PlayerLevel3(int x, int y, int direction, int width, int height, Game game) {
        super(x, y);
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
        this.speed = 5;
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
        
        
            // moving player depending on flags
            if (game.getKeyManager().left) {
                setX(getX() - getSpeed());
            }
            if (game.getKeyManager().right) {
                setX(getX() + getSpeed());
            }
            // reset x position and y position if colision
            if (getX() + 160 >= game.getWidth()) {
                setX(game.getWidth() - 160);
            } else if (getX() <= 0) {
                setX(0);
            }
        

    }

    
    /**
     * Creates a rectangle in the left half of the player
     * 
     * @return a rectangle with the dimentions of the left half of the player
     */
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), 80, getHeight());
    }
    /**
     * Creates a rectangle in the right half of the player
     * 
     * @return a rectangle with the dimentions of the right half of the player
     */
    public Rectangle getPerimetro2() {
        return new Rectangle(getX()+80, getY(), 80, getHeight());
    }
    /**
     * check if the left half of the player intersects with the ball
     * 
     * @param obj gets the object that intersects with the player
     * @return a boolean when the left half of the player intersects
     * another object
     */
    public boolean intersecta(Object obj) {
        return obj instanceof BallLevel3 && getPerimetro().intersects(((BallLevel3) obj).getPerimetro());
    }
    
    /**
     * check if the right half of the player intersects with the ball
     * 
     * @param obj gets the object that intersects with the player
     * @return a boolean when the right half of the player intersects 
     * another object
     */
    public boolean intersecta2(Object obj) {
        return obj instanceof BallLevel3 && getPerimetro2().intersects(((BallLevel3) obj).getPerimetro());
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.playerLevel3, getX(), getY(), getWidth(), getHeight(), null);
    }

}
