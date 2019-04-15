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
    private boolean jumping;
    private boolean gravity;
    private int initialY;
    
    
    public Player (int x, int y, int direction, int width, int height, Game game){
        super(x, y);
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
        this.speed = direction;
        this.jumping = false;
        this.gravity = false;
        this.initialY = y;
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
    
    public void isJumping(boolean bJ){
        this.jumping = bJ;
    }
    public void isGravity(boolean bG){
        this.gravity = bG;
    }  
    
    
    @Override
    public void tick() {
        if(game.getNivel()==1){
            if (game.getKeyManager().left){
                setX(getX() - getSpeed());
            }
            if (game.getKeyManager().right){
                setX(getX() + getSpeed());
            }
            // reset x position and y position if colision
            if (getX() + 60 >= game.getWidth()){
                setX(game.getWidth() - 60);
            }
            else if (getX() <= 0){
                setX(0);
            }
        }
        if(game.getNivel() == 4){
            if(game.getKeyManager().space && !gravity){
                isJumping(true);  
            }
            if(jumping){
                setY(getY()-4); 
            }
            
            if (getY()<=game.getHeight()/2-getHeight() ){
                isJumping(false);
                isGravity(true);
            }
            if(gravity){
               setY(getY()+4);             
            }


            if (getY() >= game.getHeight()-game.getHeight()/4){
                setY(game.getHeight()-game.getHeight()/4);
                isGravity(false);
            }
        }


        
    }
    
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    
    public boolean intersecta(Object obj) {
        return obj instanceof Fruit && getPerimetro().intersects(((Fruit) obj).getPerimetro());
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.playerLevel1,getX(),getY(),getHeight(), getWidth(), null);
    }
    
}
