/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import java.awt.Graphics;

/**
 *
 * @author karymenahleacosta
 */
public class MamutN2 extends Item{
    
    private Game game;
    boolean moveRight;
    boolean moveLeft;
    boolean isVisible;

    public MamutN2(int x, int y) {
        super(x, y);
        moveLeft=false;
        moveRight=true;
        isVisible=true;
    }

    public boolean isIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    
    @Override
    public void tick() {

      
    }

    @Override
    public void render(Graphics g) {
       
    }
    
    
}
