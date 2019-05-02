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
 * @author Garzafox
 */
public class Arrow4 extends Item{
    private int direction;
    private Game game;
    private int width;
    private int height;
    private int speed;
    private boolean visible;
    
    public Arrow4(int x, int y, int width, int height, Game game) {
        super(x,y);
        this.direction = 2;
        this.game = game;
        this.width = width;
        this.height = height;
        speed = 4;
        this.visible = false;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public int getWidth(){
        return width;
    }
    public void setWidth(int w){
        this.width=w;
    }
    public int getHeight(){
        return height;
    }
    public void setHeight(int h){
        this.height=h;
    }

    public int getDirection() {
        return direction;
    }


    public void setDirection(int direction) {
        this.direction = direction;
    }
    
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    


    @Override
    public void tick() {
        if(!game.isPause()){
            //If is visible
            if(isVisible()){
                //The arrow start moving to the left
            setX(getX()-getSpeed());
            } else {
                //If is not visible is set on x = 800
                setX(game.getWidth());
            }
            //If the arrow leave the screen
            if (getX() < -54) {
                //The variable Visible is set on false
                setVisible(false);
        }
        }

    }
    
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    


    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.arrow, getX(), getY(), getWidth(), getHeight(), null);
    }
}
