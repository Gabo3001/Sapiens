/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author HOME
 */
public class Game implements Runnable{
    
    private Display display;
    String title;
    private int width;
    private int height;
    private int nivel;
    private Thread thread;
    private boolean running;
    private Menu menu;
    private Nivel1 nivel1;
    private Nivel4 nivel4;
    private KeyManager keyManager;
    private MouseManager mouseManager;
    private Graphics g;
    
    public Game(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        this.nivel = 0;
        running = false;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    public Display getDisplay() {
        return display;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight() {
        return height;
    }
   
    
    private void init(){
        display = new Display(title, getWidth(), getHeight());
        Assets.init();

                menu = new Menu(title, getWidth(), getHeight(), this);
                menu.init();


                nivel1 = new Nivel1(title,getWidth(),getHeight(),this);
                nivel1.init();

                nivel4 = new Nivel4(title,getWidth(),getHeight(),this);
                nivel4.init();

        
        display.getJframe().addKeyListener(keyManager);
        display.getJframe().addMouseListener(mouseManager);
        display.getJframe().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
    }
    
    @Override
    public void run() {
        init();
        //frames per seconds
        int fps = 60;
        //time for each tick in nano seconds
        double timeTick = 1000000000 / fps;
        // inizialing delta
        double delta = 0;
        // define now to use inside the loop
        long now;
        // initializing last time to the computer time in nanosecs
        long lastTime = System.nanoTime();
        while (running){
            // setting the time now to the actual time
            now = System.nanoTime();
            // acumulating to delta the difference between times in timeTick units
            delta += (now - lastTime) / timeTick;
            //updating the last time
            lastTime = now;
            
            // if delta is positive we tick the game
            if (delta >= 1){
                tick();
                render();
                delta --;
            }
        }
        stop();    
    }
    
    
    public int getNivel(){
        return nivel;
    }
    
    public void setNivel(int level){
        this.nivel=level;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }
    
    private void tick(){
        keyManager.tick();
        switch(getNivel()){
            case 0:
                menu.tick();
                break;
            case 1:
                nivel1.tick();
                break;
            case 4:
                nivel4.tick();
                break;
        }
        
    }
    
    private void render(){
        switch(getNivel()){
            case 0:
                menu.render();
                break;
            case 1:
                nivel1.render();
                break;
            case 4:
                nivel4.render();
                break;
                
        }
        
    }
    
    public synchronized void start(){
        if(!running){
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }
    
    public synchronized void stop(){
        if(running){
            running = false;
            try{
                thread.join();
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }
}
