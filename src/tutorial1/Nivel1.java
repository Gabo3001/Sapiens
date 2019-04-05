/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

/**
 *
 * @author Electel
 */
public class Nivel1 {
    
    private int width;
    private int height;
    private Game game;
    private BufferStrategy bs;
    private Graphics g;
    String title;
    private Player player;
    private LinkedList<Fruit> fruit;
    
    public Nivel1(String title, int width, int height, Game game) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.game = game;
        fruit = new LinkedList<Fruit>();
    }
    public void init() {
        //player and the apples are initialized
        player = new Player(300,350,3,80,60,game);
        int iX;
        int range;
        int iY;
        for(int i = 0;i<10;i++){
            range=(game.getHeight())+1;//max-min
            iY = (int) (Math.random() * range);
            iX = (int) (Math.random() * 760);
            fruit.add(new Fruit(iX,0-iY ,40,40,game));
        }
        
    }
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public void tick() {
        player.tick();
        for(int i=0;i<fruit.size();i++){
            Fruit food = fruit.get(i);
            food.tick();
            //if the player intersects the apple
            if (player.intersecta(food)){
                //The object is moved to a random place in x that is inside the screen
                food.setX((int)(Math.random() * 760));
                //The object is moved to a random place in y that is inside the screen
                int iPosY = (int) (Math.random() * getHeight() * 1/2)-getHeight();
                food.setY(iPosY);
            }
            //if the y position of the apple go out the infirior limit of the sceen
            if(food.getY() >= getHeight()){
                //The object is moved to a random place in x that is inside the screen               
                food.setX((int)(Math.random() * 760));
                //The object is moved to a random place in y that is inside the screen 
                int iPosY = (int) (Math.random() * getHeight() * 1/2)-getHeight();
                food.setY(iPosY);
            }
        }
        

    }

    public void render() {
        bs = game.getDisplay().getCanvas().getBufferStrategy();

        if (bs == null) {
            game.getDisplay().getCanvas().createBufferStrategy(3);
        } else {
            g = bs.getDrawGraphics();
            g.drawImage(Assets.backgroundLevel1, 0, 0, width, height, null);
            player.render(g);
            for (int i = 0; i < fruit.size(); i++) {
            Fruit feed =  fruit.get(i);
            feed.render(g);
        }
            bs.show();
            g.dispose();
        }
    }
    
}
