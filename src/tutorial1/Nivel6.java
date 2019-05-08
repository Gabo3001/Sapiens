
//                try {
//                    game.getDB().getQuizInfo("Scientifica",scientific,game);
//                } catch (Exception ex) {
//                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
//                }

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

/**
 *
 * @author Electel
 */
public class Nivel6 {
        private int width;
    private int height;
    private Game game;
    String title;
    private BufferStrategy bs;
    private Graphics g;
    private Boton A;
    private Boton S;
    private Boton D;
    private LinkedList<Bulbo> yellow;
    private LinkedList<Bulbo> blue;
    private LinkedList<Bulbo> purple;
    private int chance;
    private boolean yellowRight;
    private boolean blueRight;
    private boolean purpleRight;
    private int lightsUp;
    private Boton menu;
    private Boton save;
    private Animation next;
    private boolean start;
    private int scene;
    private SoundClip songN6;

    public Nivel6(String title, int width, int height, Game game) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.game = game;
        yellow = new LinkedList<Bulbo>();
        blue = new LinkedList<Bulbo>();
        purple = new LinkedList<Bulbo>();
        yellowRight = true;
        purpleRight = true;
        blueRight = true;
        lightsUp = 0;
        scene = 0;
        start = false;
        this.next = new Animation(Assets.nextA, 500);
        songN6 = new SoundClip("/tutorial1/sounds/N6.wav", -3f, true);
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public void setScene(int scene) {
        this.scene = scene;
    }

    public boolean isStart() {
        return start;
    }

    public int getScene() {
        return scene;
    }

    public void setLightsUp(int lightsUp) {
        this.lightsUp = lightsUp;
    }

    public int getLightsUp() {
        return lightsUp;
    }

    public void setBlueRight(boolean blueRight) {
        this.blueRight = blueRight;
    }

    public void setPurpleRight(boolean purpleRight) {
        this.purpleRight = purpleRight;
    }

    public boolean isPurpleRight() {
        return purpleRight;
    }

    public boolean isBlueRight() {
        return blueRight;
    }

    public void setYellowRight(boolean yellowRight) {
        this.yellowRight = yellowRight;
    }

    public boolean isYellowRight() {
        return yellowRight;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public int getChance() {
        return chance;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void init() {
        A = new Boton(231, 440, 70, 60, game, 6);
        S = new Boton(381, 440, 70, 60, game, 7);
        D = new Boton(531, 440, 70, 60, game, 8);
        for (int i = 0; i < 10; i++) {
            yellow.add(new Bulbo(228, -90, 80, 90, game, 1));
        }
        for (int i = 0; i < 10; i++) {
            blue.add(new Bulbo(376, -90, 80, 90, game, 2));
        }
        for (int i = 0; i < 10; i++) {
            purple.add(new Bulbo(525, -90, 80, 90, game, 3));
        }
        menu = new Boton(413, 360, 100, 50, game, 5);
        save = new Boton(283, 360, 100, 50, game, 4);
    }

    public void tick() {
        //If the game start and is not in pause
        if (isStart() && !game.isPause()) {
            //If theres no song playing
            if (songN6.isStop()) {
                //Reproduce el clip
                songN6.play();
            }
            //if the lights up go below 0
            if(getLightsUp() < 0){
                //set lights up in 0
                setLightsUp(0);
            }
            for (int i = 0; i < yellow.size(); i++) {
                Bulbo y = yellow.get(i);
                y.tick();
                //Chance get a random number from 0 to 749
                setChance((int) (Math.random() * (750)));
                //if chance is 1 and is not pause and yellow is in right position
                if (getChance() == 1 && !game.isPause() && isYellowRight()) {
                    if (!y.isVisible()) {
                        //The bulb is set visible
                        y.setVisible(true);
                        //Set yelowRight on false
                        setYellowRight(false);
                    }
                }
                //if the yellow bulb is on y = 0
                if (y.getY() == 0) {
                    //Set yelowRight on true
                    setYellowRight(true);
                }
                //If the yellow bulb intersect the A button
                if (y.intersectaB(A) && game.getKeyManager().a) {
                    //The bulb go back to its original position
                    y.setY(-90);
                    //Visible is set on false
                    y.setVisible(false);
                    // LightsUp increase in one
                    setLightsUp(getLightsUp() + 1);
                    //The function kstop is calles
                    game.getKeyManager().kStop();
                    //The sound of cristal is played
                    Assets.cristal.play();
                }
            }
            for (int i = 0; i < blue.size(); i++) {
                Bulbo b = blue.get(i);
                b.tick();
                //Chance get a random number from 0 to 749
                setChance((int) (Math.random() * (750)));
                //if chance is 1 and is not pause
                if (getChance() == 1 && !game.isPause() && isBlueRight()) {
                    if (!b.isVisible()) {
                        //The bulb is set visible
                        b.setVisible(true);
                        //Set blueRight on false
                        setBlueRight(false);
                    }
                }
                //if the blue bulb is on y = 0
                if (b.getY() == 0) {
                    //Set blueRight on true
                    setBlueRight(true);
                }
                //If the blue bulb intersect the S button
                if (b.intersectaB(S) && game.getKeyManager().s) {
                    //The bulb go back to its original position
                    b.setY(-90);
                    //Visible is set on false
                    b.setVisible(false);
                    // LightsUp increase in one
                    setLightsUp(getLightsUp() + 1);
                    //The function kstop is calles
                    game.getKeyManager().kStop();
                    Assets.cristal.play();
                }
            }
            for (int i = 0; i < purple.size(); i++) {
                Bulbo p = purple.get(i);
                p.tick();
                //Chance get a random number from 0 to 749
                setChance((int) (Math.random() * (750)));
                //if chance is 1 and is not pause
                if (getChance() == 1 && !game.isPause() && isPurpleRight()) {
                    if (!p.isVisible()) {
                        //The bulb is set visible
                        p.setVisible(true);
                        //Set purpleRight on false
                        setPurpleRight(false);
                    }
                }
                //if the purple bulb is on y = 0
                if (p.getY() == 0) {
                    //Set purpleRight on true
                    setPurpleRight(true);
                }
                //If the purple bulb intersect the D button
                if (p.intersectaB(D) && game.getKeyManager().d) {
                    //The bulb go back to its original position
                    p.setY(-90);
                    //Visible is set on false
                    p.setVisible(false);
                    // LightsUp increase in one
                    setLightsUp(getLightsUp() + 1);
                    //The function kstop is calles
                    game.getKeyManager().kStop();
                    Assets.cristal.play();
                }
            }
        } else if (game.isPause() && isStart()) {
            //If theres no song playing
            if (songN6.isStop()) {
                //Reproduce el clip
                songN6.play();
            }
            //if menu is clicked
            if (menu.intersecta(game.getMouseManager()) && game.isPause()) {
                game.setWhatLevel(6);
                game.setNivel(0);
                //The song is pause
                songN6.pause();
            }
            //if reset is clicked
            if (save.intersecta(game.getMouseManager()) && game.isPause()) {
                //The level is reset
                reset();
            }
        } else {
            //When thw n key is press
            if (game.getKeyManager().next) {
                //If scene is minor to 3
                if (getScene() < 2) {
                    //the scene increase in 1
                    setScene(getScene() + 1);
                }
                //The function kStop is called
                game.getKeyManager().kStop();
            }
            //Next animation tick is on
            this.next.tick();
            //Whene scee reach 3
            if (getScene() == 2) {
                //start is set on true
                setStart(true);
            }
            //If theres no song playing
            if (songN6.isStop()) {
                //Reproduce el clip
                songN6.play();
            }
        }
    }

    /**
     * This function reset the level one to its original state
     */
    public void reset(){
        //set yellow, blue and purple right on true
        setYellowRight(true);
        setPurpleRight(true);
        setBlueRight(true);
        //set lights up on 0
        setLightsUp(0);
        //The scene is set on 0
        setScene(0);
        //Start is set on false
        setStart(false);
        //The song start from the begining
        songN6.stop();
        songN6.setfPosition(0);
        //The bulbs are initialice again
        for (int i = 0; i < yellow.size(); i++) {
                    Bulbo y = yellow.get(i);
                    y.setY(-90);
                }
                for (int i = 0; i < blue.size(); i++) {
                    Bulbo b = blue.get(i);
                    b.setY(-90);
                }
                for (int i = 0; i < purple.size(); i++) {
                    Bulbo p = purple.get(i);
                    p.setY(-90);
                }
        //The game is no longer on pause
        game.setPause(false);
        //set the mause position on 0s
        game.getMouseManager().setX(0);
        game.getMouseManager().setY(0);
    }
    
    public void render() {
        bs = game.getDisplay().getCanvas().getBufferStrategy();

        if (bs == null) {
            game.getDisplay().getCanvas().createBufferStrategy(3);
        } else {
            g = bs.getDrawGraphics();
            if (isStart()) {
                if (getLightsUp() > 140) {
                    g.drawImage(Assets.city8, 0, 0, width, height, null);
                } else if (getLightsUp() > 120) {
                    g.drawImage(Assets.city7, 0, 0, width, height, null);
                } else if (getLightsUp() > 100) {
                    g.drawImage(Assets.city6, 0, 0, width, height, null);
                } else if (getLightsUp() > 80) {
                    g.drawImage(Assets.city5, 0, 0, width, height, null);
                } else if (getLightsUp() > 60) {
                    g.drawImage(Assets.city4, 0, 0, width, height, null);
                } else if (getLightsUp() > 40) {
                    g.drawImage(Assets.city3, 0, 0, width, height, null);
                } else if (getLightsUp() > 20) {
                    g.drawImage(Assets.city2, 0, 0, width, height, null);
                } else {
                    g.drawImage(Assets.city1, 0, 0, width, height, null);
                }

                A.render(g);
                S.render(g);
                D.render(g);
                for (int i = 0; i < yellow.size(); i++) {
                    Bulbo y = yellow.get(i);
                    y.render(g);
                }
                for (int i = 0; i < blue.size(); i++) {
                    Bulbo b = blue.get(i);
                    b.render(g);
                }
                for (int i = 0; i < purple.size(); i++) {
                    Bulbo p = purple.get(i);
                    p.render(g);
                }
                if (game.isPause()) {
                    g.drawImage(Assets.pauseN6, 250, 50, 300, 400, null);
                    save.render(g);
                    menu.render(g);
                }
            } else {
                if (getScene() == 0) {
                    g.drawImage(Assets.info6, 0, 0, width, height, null);
                    g.drawImage(next.getCurretFrame(), 230, 460, 300, 30, null);
                }
                if (getScene() == 1) {
                    g.drawImage(Assets.control6, 0, 0, width, height, null);
                    g.drawImage(next.getCurretFrame(), 230, 460, 300, 30, null);
                }
            }
            bs.show();
            g.dispose();
        }
    }
}

