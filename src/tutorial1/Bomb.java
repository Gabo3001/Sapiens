/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

/**
 *
 * @author karymenahleacosta
 */

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bomb extends Item{

    private int width;
    private int height;
    private Game game;
    private int speed;

 //   private AnimationN2 bomba; //la animacion de la pelota (esta girando)
    private boolean Active; //
    
    public Bomb(int x, int y, int width, int height, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
        this.speed = 1;
  //      this.bomba = new AnimationN2(Assets.BombImages, 100); //se inicializa con la imagen principal 
        this.Active = false;
    }
    public boolean isActive(){
        return Active;
    }
    public void setActive(boolean b){
        this.Active = b;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    

    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    


    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void tick() {

        
                setY(getY()+getSpeed());
                if(getY()>game.getHeight()){
                    setActive(false);
                }
            
    }
    
    
    public boolean intersecta(Player obj){
     return obj instanceof Player  && getPerimetro().intersects(((Player) obj).getPerimetro());
     }
           
    public Rectangle getPerimetro() {
     return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
            
    @Override
    public void render(Graphics g) {
        if(isActive()){
          g.drawImage(Assets.fire, getX(), getY(), getWidth(), getHeight(), null);  
        }
        
    }
}

