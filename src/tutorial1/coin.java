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
 * @author Electel
 */
public class coin extends Item{
     private int direction;
    private Game game;
    private int width;
    private int height;
    private int speed;
    private boolean attack;
    
    public coin(int x, int y, int width, int height, Game game) {
        super(x,y);
        this.game = game;
        this.width = width;
        this.height = height;
        speed = 3;
        this.attack = true;
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
    
    public void isAttack(boolean bA){
        this.attack=bA;
    }


    @Override
    public void tick() {
        //If the game is not on pause
        if(!game.isPause()){
            //If the coin is attack
            if(attack){
                //It will move to the right
                setX(getX()-getSpeed());
            }
        }
    }
    
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    


    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.coin, getX(), getY(), getWidth(), getHeight(), null);
    }
}
