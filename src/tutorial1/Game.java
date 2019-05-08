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
 * @author CacToon
 */
public class Game implements Runnable {

    private Display display;
    String title;
    private int width;
    private int height;
    private int nivel;
    private int whatLevel;
    private Thread thread;
    private boolean running;
    private Menu menu;
    private Nivel1 nivel1;
    private Nivel2 nivel2;
    private Nivel3 nivel3;
    private Nivel4 nivel4;
    private Nivel5 nivel5;
    private Nivel6 nivel6;
    private KeyManager keyManager;
    private MouseManager mouseManager;
    private int score;
    private int lastScore;
    private boolean pause;    
    
    //DATABASE 
    private int userID;
    private String username;
    private String password;
    private DatabaseManager dbm;
    private int ScoreTableID;
    

    public Game(String title, int width, int height) {

        this.title = title;
        this.width = width;
        this.height = height;
        this.nivel = 0;
        running = false;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
        pause = false;
        score = 0;
        
        whatLevel = 1;
        this.userID=0;
        this.username="XXXXXXX";
    }
    public Nivel2 getNivel2(){
        return nivel2;
    }
    public Nivel4 getNivel4(){
        return nivel4;
    }
    public Nivel6 getNivel6(){
        return nivel6;
    }

    public void setScoreTableID(int id){
        this.ScoreTableID=id;
    }
    
    public int getScoreTableID(){
        return ScoreTableID;
    } 

    public int getLastScore() {
        return lastScore;
    }

    public void setLastScore(int lastScore) {
        this.lastScore = lastScore;
    }
    
    public void setUserID(int id){
        this.userID=id;
    }
    
    public int getUserID(){
        return userID;
    }
    public DatabaseManager getDB(){
        return dbm;
    }
    
    public String getUsername(){
        return username;
    }
    public void setUsername(String usr){
        this.username=usr;
    }

    public void setWhatLevel(int whatLevel) {
        this.whatLevel = whatLevel;
    }

    public int getWhatLevel() {
        return whatLevel;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public Display getDisplay() {
        return display;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    private void init() {
        display = new Display(title, getWidth(), getHeight());
        Assets.init();

        menu = new Menu(title, getWidth(), getHeight(), this);
        menu.init();

        nivel1 = new Nivel1(title, getWidth(), getHeight(), this);
        nivel1.init();
        
        nivel2 = new Nivel2(title, getWidth(), getHeight(), this);
        nivel2.init();

        nivel4 = new Nivel4(title, getWidth(), getHeight(), this);
        nivel4.init();

        nivel3 = new Nivel3(title,getWidth(),getHeight(),this);
        nivel3.init();

        nivel5 = new Nivel5(title, getWidth(), getHeight(), this);
        nivel5.init();

        nivel6 = new Nivel6(title, getWidth(), getHeight(), this);
        nivel6.init();

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
        while (running) {
            // setting the time now to the actual time
            now = System.nanoTime();
            // acumulating to delta the difference between times in timeTick units
            delta += (now - lastTime) / timeTick;
            //updating the last time
            lastTime = now;

            // if delta is positive we tick the game
            if (delta >= 1) {
                tick();
                render();
                delta--;
            }
        }
        stop();
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int level) {
        this.nivel = level;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    private void tick() {
        keyManager.tick();
        switch (getNivel()) {
            case 0:
                menu.tick();
                break;
            case 1:
                nivel1.tick();
                break;
            case 2:
                nivel2.tick();
                break;            
            case 3:
                nivel3.tick();
                break;
            case 4:
                nivel4.tick();
                break;
            case 5:
                nivel5.tick();

                break;
            case 6:
                nivel6.tick();
                break;
        }
        //if p is pressed
        if (getKeyManager().pause) {
            //if pause is true
            if (isPause() && getNivel() != 0) {
                //set pause to false
                setPause(false);
            } //if pause is false

            else if (!isPause() && getNivel() != 0) {

                //set pause to true
                setPause(true);
            }
            //pStop is called set the key press back to false

            getKeyManager().kStop();

        }
    }

    private void render() {
        switch (getNivel()) {
            case 0:
                menu.render();
                break;
            case 1:
                nivel1.render();

                break;
            case 2:
                nivel2.render();
                break;
                
            case 3:
                nivel3.render();
                break;
            case 4:
                nivel4.render();
                break;
            case 5:
                nivel5.render();
                break;
            case 6:
                nivel6.render();
                break;
        }

    }

    public synchronized void start() {
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    public synchronized void stop() {
        if (running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
