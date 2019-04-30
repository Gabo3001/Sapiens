/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author HOME
 */
public class KeyManager implements KeyListener{
    
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    public boolean a;
    public boolean s;
    public boolean d;
    public boolean pause;
    public boolean next;
    public boolean space;

    
    private boolean keys[];
    
    public KeyManager(){
        keys = new boolean[256];
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //if the key press is different of space, p or r
        if (e.getKeyCode() != KeyEvent.VK_P && e.getKeyCode() != KeyEvent.VK_N){
            // set true to every key pressed
            keys[e.getKeyCode()] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_P){
            //set true p key
            keys[e.getKeyCode()] = true;
        }
        else if(e.getKeyCode() == KeyEvent.VK_N){
            //set true n key
            keys[e.getKeyCode()] = true;
        }
        else{
            keys[e.getKeyCode()] = false;
        }
    }
    /**
     * this function set false to the space, r, p, a, s and d key
     */
    public void kStop(){
        //Function that set on false  to the space, r, p, a, s and d keya
        keys [KeyEvent.VK_P] = false;
        keys [KeyEvent.VK_N] = false;
        keys [KeyEvent.VK_A] = false;
        keys [KeyEvent.VK_S] = false;
        keys [KeyEvent.VK_D] = false;
    }
    
    /**
     *  to enable or disable moves on every tick
     */
    public void tick(){
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        a = keys[KeyEvent.VK_A];
        s = keys[KeyEvent.VK_S];
        d = keys[KeyEvent.VK_D];
        pause = keys[KeyEvent.VK_P];
        next = keys[KeyEvent.VK_N];
        space = keys[KeyEvent.VK_SPACE];

    }
}
