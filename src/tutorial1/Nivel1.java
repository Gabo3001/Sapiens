/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

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
    private Fruit fruit;
//    private Boton back;
    
    public Nivel1(String title, int width, int height, Game game) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.game = game;
    //    g=graphics;
    }
    public void init() {
        //Start, help and back are initialized
   //     back = new Boton(310, 500, 150, 75, game, 3);
        player = new Player(300,getHeight()-80,3,80,60,game);
        fruit = new Fruit(getWidth()/2,0,40,40,game);
    }
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public void tick() {
        player.tick();
        fruit.tick();
//        if (back.intersecta(game.getMouseManager())) {
//            game.setNivel(0);
//        }
    }

    public void render() {
        bs = game.getDisplay().getCanvas().getBufferStrategy();

        if (bs == null) {
            game.getDisplay().getCanvas().createBufferStrategy(3);
        } else {
            g = bs.getDrawGraphics();
            g.drawImage(Assets.backgroundLevel1, 0, 0, width, height, null);
            player.render(g);
            fruit.render(g);
            bs.show();
            g.dispose();
        }
    }
    
}
