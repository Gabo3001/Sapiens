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
public class Boton extends Item {
    
    private int width;
    private int height;
    private Game game;
    private int type;   //Determine the type of button
    
    public Boton (int x, int y, int width, int height, Game game, int type){
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
        
    }
    
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    
    public boolean intersecta(Object obj) {
        return obj instanceof MouseManager && getPerimetro().intersects(((MouseManager) obj).getPerimetro());
    }

    @Override
    public void render(Graphics g) {
        //1 for the start button
        if (getType() == 1){
            g.drawImage(Assets.start, getX(), getY(), getWidth(), getHeight(), null);
        }
        //2 for the help button
        if (getType() == 2){
            g.drawImage(Assets.help, getX(), getY(), getWidth(), getHeight(), null);
        }
        //3 for the back button
        if (getType() == 3){
            g.drawImage(Assets.back, getX(), getY(), getWidth(), getHeight(), null);
        }
        //4 for the save button
        if (getType() == 4){
            g.drawImage(Assets.save, getX(), getY(), getWidth(), getHeight(), null);
        }
        //5 for the back to menu button
        if (getType() == 5){
            g.drawImage(Assets.menu, getX(), getY(), getWidth(), getHeight(), null);
        }
        //5 for the login to an existing account
        if (getType() == 6){
            g.drawImage(Assets.login, getX(), getY(), getWidth(), getHeight(), null);
        }
    }
    
}
