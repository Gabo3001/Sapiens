/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author HOME
 */
public class Menu {

    private int width;
    private int height;
    private Boton start;
    private Boton help;
    private Boton back;
    private Boton login;
    private Boton pregunta;
    private Game game;
    private BufferStrategy bs;
    private Graphics g;
    private login log;
    private quiz question;
    private boolean logVis;
    private boolean open;
    
    private JFrame jf;
    private JTextField jt = new JTextField();
    private AddQuestion prof;
 
    
    String title;
    private boolean info;   //Boolean that determain if the information is show or not
    private SoundClip songM;
    
    public Menu(String title, int width, int height, Game game) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.game = game;
        info = false;
        songM = new SoundClip("/tutorial1/sounds/Inicio.wav",  -3f, true); 
        
    }

    public void setSongM(SoundClip songM) {
        this.songM = songM;
    }

    public SoundClip getSongM() {
        return songM;

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
  

        log = new login(game);
        
        
        start = new Boton(20, -150, 150, 75, game, 1);
        login = new Boton(20, 150, 150, 75, game, 9);
        pregunta = new Boton(20, -150, 150, 75, game, 10);
        help = new Boton(20, 235, 150, 75, game, 2);
        back = new Boton(310, 500, 150, 75, game, 3);
    }

    public void tick() {
        //If theres no song playing
        if (songM.isStop()){
            //Reproduce el clip
            songM.play();
        }
        //if help is clicked
       
        if (help.intersecta(game.getMouseManager())) {
            //info is set in true
            setInfo(true);
            //The buttons start and help dissapear from the screen
            start.setX(start.getX() - 200);
            login.setX(login.getX() - 200);
            help.setX(help.getX() - 200);
            //Back appear on the screen
            back.setY(back.getY() - 100);
            //The x and y of the mouse are set on 0
            game.getMouseManager().setX(0);
            game.getMouseManager().setY(0);
        }
        //if help is clicked
        if (back.intersecta(game.getMouseManager())) {
            //info is set in false
            setInfo(false);
            //The buttons start and help apear on the screen
            start.setX(start.getX() + 200);
            help.setX(help.getX() + 200);
            login.setX(login.getX() + 200);
            //Back dissapear from the screen
            back.setY(back.getY() + 100);
            //The x and y of the mouse are set on 0
            game.getMouseManager().setX(0);
            game.getMouseManager().setY(0);
        }
        //if start is clicked
        if (start.intersecta(game.getMouseManager())) {
            //The x and y of the mouse are set on 0
            game.getMouseManager().setX(0);
            game.getMouseManager().setY(0);
            //The game move to the first minigame
            game.setNivel(game.getWhatLevel());
            //The music stops
            songM.pause();
        }
        //if the id is different to 0 and 42
        if(game.getUserID() != 0 && game.getUserID() != 42){
            //Login button dissapears
            login.setX(-150);
            //start button appears
            start.setY(150);
        }
        //if the id correspong to the id of the teacher
        if (game.getUserID() == 42){
            //help and login button dissapear
            help.setX(-150);
            login.setX(-150);
            //add question appear
            pregunta.setY(150);
            
        }
        //if loging button is clicked
        if (login.intersecta(game.getMouseManager())) {
            //The x and y of the mouse are set on 0
            game.getMouseManager().setX(0);
            game.getMouseManager().setY(0);
        }
        //if the id correspong to the id of the teacher
        if (game.getUserID() == 42){
            //help and login button dissapear
            help.setX(-150);
            login.setX(-150);
            //add question appear
            pregunta.setY(150);
            
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
            
            g.setColor(Color.BLACK);
            g.setFont(new Font("Serif", Font.PLAIN, 20));
            g.drawString("Usuario: "+game.getUsername(), getWidth() - getWidth() / 4, 0 + getHeight() / 15);
            g.drawString("id: "+game.getUserID(), getWidth() - getWidth() / 4, 0 + getHeight() / 15+20);
            start.render(g);
            help.render(g);
            back.render(g);
            login.render(g);
            pregunta.render(g);
            bs.show();
            g.dispose();
           
        }
    }

}
