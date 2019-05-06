
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
public class Nivel4 {

    private int width;
    private int originalWidth;
    private int height;
    private Game game;
    private BufferStrategy bs;
    private Graphics g;
    String title;
    private PlayerN4 player;
    private LinkedList<Arrow4> arrow;
    private LinkedList<coin> coin;
    private int timer;
    private String cronos;
    private int mvBk;//for moving the background
    private int mvBk2;
    private int clock;
    private int score;
    private int chance;
    private boolean aRight;
    private String points;
    private Boton menu;
    private Boton save;
    private Animation next;
    private boolean start;
    private int scene;
    private SoundClip songN4;
//    private Boton back;

    /**
     *
     * @param title
     * @param width
     * @param height
     * @param game
     */
    public Nivel4(String title, int width, int height, Game game) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.game = game;
        arrow = new LinkedList<Arrow4>();
        coin = new LinkedList<coin>();
        this.timer = 60 * 90;
        this.cronos = "tiempo: " + timer;
        this.mvBk = width;
        this.mvBk2 = 0;
        this.clock = 0;
        this.points = ": " + score;
        this.score = 0;
        scene = 0;
        start = false;
        this.next = new Animation(Assets.nextA, 500);
        aRight = true;
        songN4 = new SoundClip("/tutorial1/sounds/N4.wav", -3f, true);
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

    public int getWidth() {
        return width;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int s) {
        this.score = s;
    }

    public int getHeight() {
        return height;
    }

    public String getCronos() {
        return cronos;
    }

    public void setCronos(String t) {
        this.cronos = t;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String t) {
        this.points = t;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int t) {
        if (t != 0) {
            this.timer = t;
        }
    }

    public int getMvBk() {
        return mvBk;
    }

    public void setMvBk2(int i) {
        this.mvBk2 = i;
    }

    public int getMvBk2() {
        return mvBk2;
    }

    public void setMvBk(int i) {
        this.mvBk = i;
    }

    public int getClock() {
        return clock;
    }

    public void setClock(int i) {
        this.clock = i;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public int getChance() {
        return chance;
    }

    public void setaRight(boolean aRight) {
        this.aRight = aRight;
    }

    public boolean isaRight() {
        return aRight;
    }

    /**
     *
     */
    public void init() {
        player = new PlayerN4(0, getHeight() - getHeight() / 4 - 20, 3, 80, 60, game);
        int posY;
        for (int i = 0; i < 50; i++) {
            posY = (int) (Math.random() * 56) + 345;
            arrow.add(new Arrow4(getWidth(), posY, 54, 12, game));
        }
        for (int i = 0; i < 1000; i++) {
            coin.add(new coin(getWidth() + i * 100, getHeight() - getHeight() / 5, 20, 30, game));
        }

        menu = new Boton(413, 360, 100, 50, game, 5);
        save = new Boton(283, 360, 100, 50, game, 4);
    }

    /**
     *
     */
    public void tick() {

        //If the game start and is not in pause
        if (isStart() && !game.isPause()) {
            //If theres no song playing
            if (songN4.isStop()) {
                //Reproduce el clip
                songN4.play();
            }
            player.tick();
            for (int i = 0; i < arrow.size(); i++) {
                Arrow4 quiver = arrow.get(i);
                quiver.tick();
                //Chance get a random number from 0 to 1499
                setChance((int) (Math.random() * (1500)));
                //if chance is 1 and is not pause and the arrow is in right position
                if (getChance() == 1 && !game.isPause() && isaRight()) {
                    if (!quiver.isVisible()) {
                        //The arrow is set visible
                        quiver.setVisible(true);
                        //Set aRight on false
                        setaRight(false);
                        //The speed of the arrow is set random
                        quiver.setSpeed((int) (Math.random() * 5) + 6);
                    }
                }
                //if the arrow is on x = 300
                if (quiver.getX() < 250 && quiver.getX() > 238) {
                    //Set aRight on true
                    setaRight(true);
                }
                //When the player intersects with an arrow
                if (player.intersectArrow(quiver)) {
                    //the score decrease on 5
                    setScore(getScore() - 5);
                    //If the score go below 0
                    if (getScore() < 0) {
                        //The score is set on 0
                        setScore(0);
                    }
                    //Set aRight on true
                    setaRight(true);
                    //The arrow go back to where it start
                    quiver.setX(getWidth());
                    //The arrow is not visible
                    quiver.setVisible(false);
                    //The sound of hit is played
                    Assets.target.play();
                }
            }
            for (int i = 0; i < coin.size(); i++) {
                coin bitcoin = coin.get(i);
                bitcoin.tick();
                //If the player intersects qith a coin
                if (player.intersecta(bitcoin)) {
                    //The coin dissapear from he screen
                    bitcoin.setY(getHeight());
                    //the sound of cash is played
                    Assets.cash.play();
                    //The score increase in one
                    setScore(getScore() + 1);
                }
            }
            //this is our time tracker it makes 60 ticks for every second
            setClock(getClock() + 1);
            //We move the firest backgroun image
            if (getWidth() - getMvBk() <= (0 - getWidth())) {
                setMvBk(0);
            }
            //we move the second background image
            if (getWidth() - getMvBk2() <= (0 - getWidth())) {
                setMvBk2(0);
            }
            if (getClock() % 1 == 0) {
                setMvBk(getMvBk() + 2);
                setMvBk2(getMvBk2() + 2);
            }
        } else if (game.isPause() && isStart()) {
            //If theres no song playing
            if (songN4.isStop()) {
                //Reproduce el clip
                songN4.play();
            }
            //if menu is clicked
            if (menu.intersecta(game.getMouseManager()) && game.isPause()) {
                game.setWhatLevel(4);
                game.setNivel(0);
                //The song is pause
                songN4.pause();
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
            if (songN4.isStop()) {
                //Reproduce el clip
                songN4.play();
            }
        }
        //When the time finished
        if (getTimer() / 60 == 0) {
            //The x and y of the keymanadager are set on 0
            game.getMouseManager().setX(0);
            game.getMouseManager().setY(0);
            //The song is stop
            songN4.stop();
                            try {
                    //The game is set on the level 5

                    new DatabaseManager().updateScore(game.getScoreTableID(),"level4",getScore());
                } catch (Exception ex) {
                    Logger.getLogger(Nivel4.class.getName()).log(Level.SEVERE, null, ex);
                }
     
           
                try {
                    game.getDB().getScoreBoard();
                } catch (Exception ex) {
                    Logger.getLogger(Nivel4.class.getName()).log(Level.SEVERE, null, ex);
                }
            //The game is set on the level 5
            game.setNivel(5);
        }

    }

    public void render() {
        bs = game.getDisplay().getCanvas().getBufferStrategy();

        if (bs == null) {
            game.getDisplay().getCanvas().createBufferStrategy(3);
        } else {
            g = bs.getDrawGraphics();
            if (isStart()) {
                g.drawImage(Assets.backgroundLevel1, getWidth() - getMvBk(), 0, width, height, null);
                g.drawImage(Assets.bkmirror, getWidth() - getMvBk2(), 0, width, height, null);
                g.drawImage(Assets.coin, getWidth() - getWidth() / 5, getHeight() - getHeight() / 12, 20, 30, null);

                player.render(g);
                for (int i = 0; i < arrow.size(); i++) {
                    Arrow4 quiver = arrow.get(i);
                    quiver.render(g);
                }
                for (int i = 0; i < coin.size(); i++) {
                    coin bitcoin = coin.get(i);
                    bitcoin.render(g);
                }

                g.setColor(Color.WHITE);
                g.setFont(new Font("Serif", Font.PLAIN, 20));
                //draws the remaining time
                g.drawString(cronos, 0 + getWidth() / 100, getHeight() - getHeight() / 25);
                if (!game.isPause()) {
                    setTimer(getTimer() - 1);
                }
                //updates the time, it is divided by 60 because it moves at 60fps
                setCronos("Tiempo: " + getTimer() / 60);
                //increases the text size for our coin count
                g.setFont(new Font("Serif", Font.PLAIN, 35));
                g.drawString(points, getWidth() - getWidth() / 6, getHeight() - getHeight() / 30);
                setPoints(": " + getScore());
                if (game.isPause()) {
                    g.drawImage(Assets.pauseN4, 250, 50, 300, 400, null);
                    save.render(g);
                    menu.render(g);
                }

            } else {
                if (getScene() == 0) {
                    g.drawImage(Assets.info4, 0, 0, width, height, null);
                    g.drawImage(next.getCurretFrame(), 230, 460, 300, 30, null);
                }
                if (getScene() == 1) {
                    g.drawImage(Assets.control4, 0, 0, width, height, null);
                    g.drawImage(next.getCurretFrame(), 230, 460, 300, 30, null);
                }
            }
            bs.show();
            g.dispose();
        }

    }

}

