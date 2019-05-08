
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
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private Boton menu;
    private Boton save;
    private int cont;
    private Animation next;
    private boolean start;
    private int scene;
    private SoundClip songN1;

    public Nivel1(String title, int width, int height, Game game) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.game = game;
        fruit = new LinkedList<Fruit>();
        cont = 0;
        scene = 0;
        start = false;
        this.next = new Animation(Assets.nextA, 500);
        songN1 = new SoundClip("/tutorial1/sounds/N1.wav", -3f, true);
    }

    public void init() {
        //Start, help and back are initialized

        player = new Player(300, 350, 3, 80, 60, game);

        int iX;
        int range;
        int iY;
        for (int i = 0; i < 10; i++) {
            range = (game.getHeight()) + 1;//max-min
            iY = (int) (Math.random() * range);
            iX = (int) (Math.random() * 760);
            fruit.add(new Fruit(iX, 0 - iY, 40, 40, game));
        }
        menu = new Boton(413, 360, 100, 50, game, 5);
        save = new Boton(283, 360, 100, 50, game, 4);

    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public boolean isStart() {
        return start;
    }

    public void setScene(int scene) {
        this.scene = scene;
    }

    public int getScene() {
        return scene;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public int getCont() {
        return cont;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void tick() {
        

        //If start is true and the game is not on pause
        if (isStart() && !game.isPause()) {
            player.tick();
            //If theres no song playing
            if (songN1.isStop()) {
                //Reproduce el clip
                songN1.play();
            }
            for (int i = 0; i < fruit.size(); i++) {
                Fruit food = fruit.get(i);
                food.tick();

                //Si el player intersecta al perseguidor
                if (player.intersecta(food)) {
                    //Se mueve el objeto a un lugar random en x dentro de los limites de la pantalla
                    food.setX((int) (Math.random() * 760));
                    //Se reposiciona el objeto en un lugar random a media pantlla arriba de la pantalla 
                    int iPosY = (int) (Math.random() * getHeight() * 1 / 2) - getHeight();
                    food.setY(iPosY);
                    //The counter of apples increase in 1
                    setCont(getCont() + 1);
                    //The general score increase in 50
                    game.setScore(game.getScore() + 50);
                    //The eat sond is played
                    Assets.eat.play();
                }
                //Si la posicion en y del objeto supera el limite inferior de la pantaya
                if (food.getY() >= 385) {
                    //Se mueve el objeto a un lugar random en x dentro de los limites de la pantalla                
                    food.setX((int) (Math.random() * 760));
                    //Se reposiciona el objeto en un lugar random a media pantlla arriba de la pantalla 
                    int iPosY = (int) (Math.random() * getHeight() * 1 / 2) - getHeight();
                    food.setY(iPosY);
                    //IF the score is different to 0
                    if (game.getScore() != 0) {
                        //the score decrese in 5
                        game.setScore(game.getScore() - 5);
                    }
                }

            }
        } else if (game.isPause() && isStart()) {
            //If theres no song playing
            if (songN1.isStop()) {
                //Reproduce el clip
                songN1.play();
            }
            //if menu is clicked
            if (menu.intersecta(game.getMouseManager()) && game.isPause()) {
                game.setWhatLevel(1);
                game.setNivel(0);
                //The song is pause
                songN1.pause();
            }
            //if reset is clicked
            if (save.intersecta(game.getMouseManager()) && game.isPause()) {
                //Thr level is reset
                reset();
            }
        } else {
            //When thw n key is press
            if (game.getKeyManager().next) {
                //If scene is minor to 3
                if (getScene() < 3) {
                    //the scene increase in 1
                    setScene(getScene() + 1);
                }
                game.getKeyManager().kStop();
            }
            //Next animation tick is on
            this.next.tick();
            //Whene scee reach 3
            if (getScene() == 3) {
                //start is set on true
                setStart(true);
            }
            //If theres no song playing
            if (songN1.isStop()) {
                //Reproduce el clip
                songN1.play();
            }
        }
        //WHen the player recolect 100 apples
        if (getCont() == 100) {
            //The music stops
            try {    
                new DatabaseManager().updateScore(game.getScoreTableID(),"level1",game.getScore());
            }catch (Exception ex) {
                Logger.getLogger(Nivel1.class.getName()).log(Level.SEVERE, null, ex);
            }
//            try {
//                game.getDB().getScoreBoard();
//            } catch (Exception ex) {
//                Logger.getLogger(Esp.class.getName()).log(Level.SEVERE, null, ex);
//            }
            //Last score is set on the last score you get through the level
            game.setLastScore(game.getScore());
            //music stops
            songN1.stop();
            //The user is move to the next level
            game.setNivel(2);
        }
        

    }
    /**
     * This function reset the level one to its original state
     */
    public void reset(){
        //The counter of the apples is back to 0
        setCont(0);
        //The scene is set on 0
        setScene(0);
        //Start is set on false
        setStart(false);
        //The song start from the begining
        songN1.stop();
        songN1.setfPosition(0);
        //The player is set on its original position
        player.setX(300);
        player.setY(350);
        //The apples are set on a random position
        for (int i = 0; i < fruit.size(); i++) {
            Fruit food = fruit.get(i);
            food.setX((int) (Math.random() * 760));
            int iPosY = (int) (Math.random() * getHeight() * 1 / 2) - getHeight();
            food.setY(iPosY);
        }
        //The game is no longer on pause
        game.setPause(false);
        //The score go back to 0
        game.setScore(0);
        //set the mause position on 0s
        game.getMouseManager().setX(0);
        game.getMouseManager().setY(0);
    }
    
    //DATABSAE SCORE UPDATE
    public void update() throws Exception{
        
        try {    
            new DatabaseManager().updateScore(game.getScoreTableID(),"level1",game.getScore());
        }catch (Exception ex) {
            Logger.getLogger(Nivel1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void render() {
        bs = game.getDisplay().getCanvas().getBufferStrategy();

        if (bs == null) {
            game.getDisplay().getCanvas().createBufferStrategy(3);
        } else {
            g = bs.getDrawGraphics();
            if (isStart()) {
                g.drawImage(Assets.backgroundLevel1, 0, 0, width, height, null);
                g.setFont(new Font("Serif", Font.PLAIN, 20));
                g.setColor(Color.WHITE);
                g.drawString("Usuario: "+game.getUsername(), getWidth() - getWidth() / 4, 0 + getHeight() / 15);
                
                player.render(g);
                for (int i = 0; i < fruit.size(); i++) {
                    Fruit feed = fruit.get(i);
                    feed.render(g);

                }
                if (game.isPause()) {
                    g.drawImage(Assets.pauseN1, 250, 50, 300, 400, null);
                    save.render(g);
                    menu.render(g);
                }

                
                g.drawString("PUNTAJE: " + game.getScore(), 2, 480);
                g.drawString("MANZANAS: " + getCont() + "/100", 620, 480);
            } else {
                if (getScene() == 0) {
                    g.drawImage(Assets.rev2, 0, 0, width, height, null);
                    g.drawImage(next.getCurretFrame(), 230, 460, 300, 30, null);
                }
                if (getScene() == 1) {
                    g.drawImage(Assets.info1, 0, 0, width, height, null);
                    g.drawImage(next.getCurretFrame(), 230, 460, 300, 30, null);
                }
                if (getScene() == 2) {
                    g.drawImage(Assets.control1, 0, 0, width, height, null);
                    g.drawImage(next.getCurretFrame(), 230, 460, 300, 30, null);
                }
            }
            bs.show();
            g.dispose();
        }
    }

}
