
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
public class Bulbo extends Item{
    private int direction;
    private Game game;
    private int width;
    private int height;
    private int speed;
    private int type;
    private boolean visible;
    
    public Bulbo(int x, int y, int width, int height, Game game, int type) {
        super(x,y);
        this.direction = 2;
        this.game = game;
        this.width = width;
        this.height = height;
        this.type = type;
        speed = 3;
        visible = false;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
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
        //if the game is not in pause
        if (!game.isPause()) {
            //If the bulb is visible
            if (isVisible()) {
                // the bulb start moving downards
                setY(getY() + getSpeed());
            } else {
                //If is not visible is set on y = -90
                setY(-90);
            }
            //If the bulb leave the screen
            if (getY() > 500) {
                //The variable Visible is set on false
                setVisible(false);
                //The number of lights up decrease by one
                game.getNivel6().setLightsUp(game.getNivel6().getLightsUp()-1);
                //crash sound is played
                Assets.crash.play();
            }
        }
    }
    /**
     * Funtion that get the perimeter of the bulb
     * @return a rectangle with the perimeter of the bulb
     */
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    
    /**
     * Function that check if the bulb intersects with a button
     *
     * @param obj An object from the class boton
     * @return true when bulb intersects with a button
     */
    public boolean intersectaB(Object obj) {
        return obj instanceof Boton && getPerimetro().intersects(((Boton) obj).getPerimetro());
    }
    
    @Override
    public void render(Graphics g) {
        //1 for the yellow bulb
        if (getType() == 1){
            g.drawImage(Assets.yellowB, getX(), getY(), getWidth(), getHeight(), null);
        }
        //2 for the blue bulb
        if (getType() == 2){
            g.drawImage(Assets.blueB, getX(), getY(), getWidth(), getHeight(), null);
        }
        //3 for the purple bulb
        if (getType() == 3){
            g.drawImage(Assets.purpleB, getX(), getY(), getWidth(), getHeight(), null);
        }
    }
}

