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
public class Menu {
    private int width;
    private int height;
    private KeyManager keyManager;
    private MouseManager mouseManager;
    private Boton start;
    private Boton help;
    private Boton back;
    private Game game;
    private BufferStrategy bs;
    private Graphics gr;
    private Display display;
    String title;

    public Menu(String title, int width, int height, Game game) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.game = game;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public void init() {
       display = new Display(title, getWidth(), getHeight());
       start = new Boton (0, getHeight() - 100, 100, 150, game, 1);
       help = new Boton (100, getHeight() - 100, 100, 150, game, 2);
       back = new Boton (0, getHeight() - 200, 100, 150, game, 3);
    }

    public void tick() {
        keyManager.tick();
        
    }
    
    public void render(Graphics g){
        g.drawImage(Assets.background, 0, 0, width, height, null);
        //El problema esta al intentar mandar a llamar el render de otro objeto
        //start.render(g);
    }

}
