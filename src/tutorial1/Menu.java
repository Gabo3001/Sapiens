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
    private Boton start;
    private Boton login;
    private Boton help;
    private Boton back;
    private Game game;
    private BufferStrategy bs;
    private Graphics g;
    String title;
    private boolean info;   //Boolean that determain if the information is show or not

    public Menu(String title, int width, int height, Game game) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.game = game;
        info = false;
    }

    public void setInfo(boolean info) {
        this.info = info;
    }

    public boolean isInfo() {
        return info;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void init() {
        //Start, help and back are initialized
        start = new Boton(20, 150, 150, 75, game, 1);
        help = new Boton(20, 235, 150, 75, game, 2);
        back = new Boton(310, 500, 150, 75, game, 3);
        login = new Boton(20, 320, 150, 75, game, 9);
    }

    public void tick() {
        //if help is clicked
        if (help.intersecta(game.getMouseManager())) {
            //info is set in true
            setInfo(true);
            //The buttons start and help dissapear from the screen
            start.setX(start.getX() - 200);
            help.setX(help.getX() - 200);
            login.setX(login.getX()-200);
            //Back appear on the screen
            back.setY(back.getY() - 100);
        }
        //if help is clicked
        if (back.intersecta(game.getMouseManager())) {
            //info is set in false
            setInfo(false);
            //The buttons start and help apear on the screen
            start.setX(start.getX() + 200);
            help.setX(help.getX() + 200);
            login.setX(login.getX()+200);
            //Back dissapear from the screen
            back.setY(back.getY() + 100);
        }
        //if start is clicked
        if (start.intersecta(game.getMouseManager())) {
            //The x and y of the mouse are set on 0
            game.getMouseManager().setX(0);
            game.getMouseManager().setY(0);
            //The game move to the first minigame
            game.setNivel(game.getWhatLevel());
        }
        if(login.intersecta(game.getMouseManager())){
            //System.out.println("hello");
        }
    }

    public void render() {
        bs = game.getDisplay().getCanvas().getBufferStrategy();

        if (bs == null) {
            game.getDisplay().getCanvas().createBufferStrategy(3);
        } else {
            g = bs.getDrawGraphics();
            //If info is off the normal background is showed
            if(!isInfo()){
                g.drawImage(Assets.background, 0, 0, width, height, null);
            } else{ 
                //When info is on the info screen is showed
                g.drawImage(Assets.info, 0, 0, width, height, null);
            }
            start.render(g);
            help.render(g);
            login.render(g);
            back.render(g);
            bs.show();
            g.dispose();
        }
    }

}
