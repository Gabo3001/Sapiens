/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Electel
 */
public class Fruit extends Item{
    private int direction;
    private Game game;
    private int width;
    private int height;
    private int speed;
    
    public Fruit(int x, int y, int width, int height, Game game) {
        super(x,y);
        this.direction = 2;
        this.game = game;
        this.width = width;
        this.height = height;
        speed = 4;
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


    @Override
    public void tick() {
        if(!game.isPause()){
            setY(getY()+getSpeed());
        }
    }
    /**
     * Funtion that get the perimeter of the fruit
     * @return a rectangle with the perimeter of the fruit
     */
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.fruit, getX(), getY(), getWidth(), getHeight(), null);
    }
}
