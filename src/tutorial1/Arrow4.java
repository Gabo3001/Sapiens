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
    private boolean attack;
    
    public Arrow4(int x, int y, int width, int height, Game game) {
        super(x,y);
        this.direction = 2;
        this.game = game;
        this.width = width;
        this.height = height;
        speed = 4;
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
        if(!game.isPause()){
            if(attack)
            setX(getX()-getSpeed());
            if(getX()<0-getWidth()){
                //setX(game.getWidth());
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
