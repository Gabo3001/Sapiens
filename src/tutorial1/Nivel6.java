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
public class Nivel6 {
        private int width;
    private int height;
    private Game game;
    private BufferStrategy bs;
    private Graphics g;
    String title;

    public Nivel6(String title, int width, int height, Game game) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.game = game;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void init() {

    }

    public void tick() {
        
    }

    public void render() {
        bs = game.getDisplay().getCanvas().getBufferStrategy();

        if (bs == null) {
            game.getDisplay().getCanvas().createBufferStrategy(3);
        } else {
            g = bs.getDrawGraphics();

            bs.show();
            g.dispose();
        }
    }
}
