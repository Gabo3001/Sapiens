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
//    private Boton back;
    
    public Nivel1(String title, int width, int height, Game game) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.game = game;
        fruit = new LinkedList<Fruit>();
    //    g=graphics;
    }
    public void init() {
        //Start, help and back are initialized
   //     back = new Boton(310, 500, 150, 75, game, 3);
        player = new Player(300,getHeight()-80,3,80,60,game);
        for(int i = 0;i<10;i++){
            int range=(getWidth())+1;//max-min
            int iNum = (int) (Math.random() * range);
            fruit.add(new Fruit(iNum,0-iNum,40,40,game));
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
            if (player.intersecta(food)) {
                fruit.remove(i);
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
