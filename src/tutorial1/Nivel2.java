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
 *
 * @author karymenahleacosta
 */
public class Nivel2 {

    private Laser laser; //To use the ball
    private boolean lasershoot;
    private LinkedList<Mamut> enemigo;
    private LinkedList<MamutBlanco> blanco;
    private LinkedList<MamutNegro> negro;
    private String num; //to display score
    private int timer;
    private String cronos;

    private int width;
    private int height;
    private Game game;
    private BufferStrategy bs;
    private Graphics g;
    String title;
    private Player player;
    private boolean start;
    private Boton menu;
    private Boton save;
    private Animation next;
    private int scene;
    private SoundClip songN2;

    public Nivel2(String title, int width, int height, Game game) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.game = game;
        enemigo = new LinkedList<Mamut>(); //lista que despliega los bricks
        blanco = new LinkedList<MamutBlanco>(); //lista que despliega los bricks
        negro = new LinkedList<MamutNegro>(); //lista que despliega los bricks
        num = "" + game.getScore(); //string que despliega en la pantalla el puntaje
        this.lasershoot = true;
        start = false;
        scene = 0;
        this.next = new Animation(Assets.nextA, 500);
        this.timer = 60 * 60;//fps*time you want
        this.cronos = "tiempo: " + timer;
        songN2 = new SoundClip("/tutorial1/sounds/N2.wav", -3f, true);
    }

    public Animation getNext() {
        return next;
    }

    public void setNext(Animation next) {
        this.next = next;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int t) {
        if (t != 0) {
            this.timer = t;
        }
    }

    public int getScene() {
        return scene;
    }

    public void setScene(int scene) {
        this.scene = scene;
    }

    public String getCronos() {
        return cronos;
    }

    public void setCronos(String t) {
        this.cronos = t;
    }

    public Laser getLaser() {
        return laser;
    }

    public void setLaser(Laser laser) {
        this.laser = laser;
    }

    public boolean isLasershoot() {
        return lasershoot;
    }

    public void setLasershoot(boolean lasershoot) {
        this.lasershoot = lasershoot;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public boolean isStart() {
        return start;
    }

    public void init() {

        player = new Player(300, 430, 3, 60, 40, game);

        //we add the laser but with no size         
        laser = new Laser(0, 0, 0, 0, 0, game);

        //we create an alien matrix
        enemigo.add(new Mamut(getWidth() - 30 - 100, 5 + 110, 40, 40, game));

        for (int i = 1; i <= 200; i++) {
            int iX = (int) (Math.random() * 800);
            negro.add(new MamutNegro(getWidth() + 10000 - iX * i, 5 + 170, 40, 40, game, 4));
        }

        for (int i = 1; i <= 200; i++) {
            int iX = (int) (Math.random() * 800);
            negro.add(new MamutNegro(getWidth() + 10000 - iX * i, 5 + 220, 40, 40, game, -4));
        }

        for (int i = 1; i <= 100; i++) {
            int iX = (int) (Math.random() * 800);
            blanco.add(new MamutBlanco(getWidth() + 10000 - iX * i, 5 + 270, 40, 40, game, -1));
        }

        for (int i = 1; i <= 100; i++) {
            int iX = (int) (Math.random() * 800);
            blanco.add(new MamutBlanco(getWidth() - 30 - iX * i, 5 + 320, 40, 40, game, 1));
        }

        menu = new Boton(413, 360, 100, 50, game, 5);
        save = new Boton(283, 360, 100, 50, game, 4);
    }

    public void tick() {

        if (isStart() && !game.isPause()) {
            //If theres no song playing
            if (songN2.isStop()) {
                //Reproduce el clip
                songN2.play();
            }
            //the tick for player and laser is made
            player.tick();
            laser.tick();

            //make white mamut tick
            for (int i = 0; i < enemigo.size(); i++) {
                Mamut mamut = enemigo.get(i);
                mamut.tick();
                //If the mamut go out of the screen it chenge direction
                if (mamut.getX() > getWidth() + getWidth() / 10 || mamut.getX() < -(getWidth() / 10)) {
                    mamut.SwitchLayer();
                }
                //If the mamut intersect with the projectile
                if (mamut.intersecta(laser)) {
                    //The mamut is not longer alive
                    mamut.changeAlive();
                    //The projectile is destroyed
                    laser.destroy();
                    //The variable can shoot is set on true
                    laser.canShoot();
                    //actualize score
                    game.setScore(game.getScore() + 100);
                    setNum("" + game.getScore());
                    //the jabalina sound is played
                    Assets.jabalia.play();
                }

            }
            //make tick for the normal mamut
            for (int i = 0; i < blanco.size(); i++) {
                MamutBlanco mamut = blanco.get(i);
                mamut.tick();
                //If the mamut intersect with the projectile
                if (mamut.intersecta(laser)) {
                    //The mamut is not longer alive
                    mamut.changeAlive();
                    //The projectile is destroyed
                    laser.destroy();
                    //The variable can shoot is set on true
                    laser.canShoot();
                    //actualize score
                    game.setScore(game.getScore() + 10);
                    setNum("" + game.getScore());
                    //the jabalina sound is played
                    Assets.jabalia.play();
                }

            }
            //the tick for the black mamut is made
            for (int i = 0; i < negro.size(); i++) {
                MamutNegro mamut = negro.get(i);
                mamut.tick();
                //If the mamut intersect with the projectile
                if (mamut.intersecta(laser)) {
                    //The mamut is not longer alive
                    mamut.changeAlive();
                    //The projectile is destroyed
                    laser.destroy();
                    //The variable can shoot is set on true
                    laser.canShoot();
                    //actualize score
                    game.setScore(game.getScore() + 50);
                    setNum("" + game.getScore());
                    //the jabalina sound is played
                    Assets.jabalia.play();
                }

            }
            //if space is clicked and the laser is shoting
            if (game.getKeyManager().space && laser.isShooting()) {
                //a new laser is generated
                laser = new Laser(player.getX() + 11, player.getY() - 10, 1, 20, 30, game);
                //the laser can not be shoot
                laser.cantShoot();
            }
            //if the laser y position is smaller that 0
            if (laser.getY() < 0) {
                //the laser can be shoot
                laser.canShoot();
            }

        } else if (game.isPause() && isStart()) {
            //If theres no song playing
            if (songN2.isStop()) {
                //Reproduce el clip
                songN2.play();
            }
            //if menu is clicked
            if (menu.intersecta(game.getMouseManager()) && game.isPause()) {
                game.setWhatLevel(1);
                game.setNivel(0);
                //The song is pause
                songN2.pause();
            }
            //if reset is clicked
            if (save.intersecta(game.getMouseManager()) && game.isPause()) {
                //Thr level is reset
                reset();
            }
        } else {
            //When the n key is pressed
            if (game.getKeyManager().next) {
                //If scene is minor to 3
                if (getScene() < 2) {
                    //the scene increase in 1
                    setScene(getScene() + 1);
                }
                game.getKeyManager().kStop();
            }
            //Next animation tick is on
            this.next.tick();
            //When scene reaches 3
            if (getScene() == 2) {
                //start is set on true
                setStart(true);
            }
            //If theres no song playing
            if (songN2.isStop()) {
                //Reproduce el clip
                songN2.play();
            }
        }
        if (getTimer() / 60 == 0) {
            try {
                //The game is set on the level 5
                new DatabaseManager().updateScore(game.getScoreTableID(), "level2", game.getScore());
            } catch (Exception ex) {
                Logger.getLogger(Nivel2.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                game.getDB().getScoreBoard();
            } catch (Exception ex) {
                Logger.getLogger(Nivel2.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Last score is set on the last score you get through the level
            game.setLastScore(game.getScore());
            //music stops
            songN2.stop();
            //The user is move to the next level
            game.setNivel(3);
        }
    }

    /**
     * funtion that reset the level 2 to its initial state
     */
    void reset() {
        //The music restart from the begining
        songN2.stop();
        songN2.setfPosition(0);
        //Laser is set on true
        setLasershoot(true);
        //start is set on false
        setStart(false);
        //scene is set on 0
        setScene(0);
        //The timer start in 50
        setTimer(60 * 60);//fps*time you want
        setCronos("tiempo: " + timer);
        //The position of the player is reset to ist original position
        player.setX(300);
        player.setY(430);
        //The position of the laset is set to its original position
        laser.setX(0);
        laser.setY(0);
        //All the animals are set on random position acording to its initialization
        for (int i = 0; i < enemigo.size(); i++) {
            Mamut ET = enemigo.get(i);
            ET.setAlive(true);
            ET.setY(115);
            ET.setX(getWidth() - 30 - 100);

        }
        for (int i = 0; i < 200; i++) {
            int iX = (int) (Math.random() * 800);
            MamutNegro ETN = negro.get(i);
            ETN.setX(getWidth() + 10000 - iX * i);
            ETN.setAlive(true);
        }

        for (int i = 0; i < 200; i++) {
            int iX = (int) (Math.random() * 800);
            MamutNegro ETN = negro.get(i + 200);
            ETN.setX(getWidth() + 10000 - iX * i);
            ETN.setAlive(true);
        }

        for (int i = 0; i < 100; i++) {
            MamutBlanco ETB = blanco.get(i);
            int iX = (int) (Math.random() * 800);
            ETB.setX(getWidth() + 10000 - iX * i);
            ETB.setAlive(true);
        }

        for (int i = 0; i < 100; i++) {
            MamutBlanco ETB = blanco.get(i + 100);
            int iX = (int) (Math.random() * 800);
            ETB.setX(getWidth() - 30 - iX * i);
            ETB.setAlive(true);
        }
        //The score is set to the same score as it started
        game.setScore(game.getLastScore());
        //The score that is showed is actualized
        setNum("" + game.getScore());
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

                g.drawImage(Assets.backgroundN2, 0, 0, width, height, null);
                player.render(g);
                laser.render(g);

                g.setFont(new Font("Serif", Font.PLAIN, 20));
                g.setColor(Color.BLACK);
                g.drawString(cronos, 670, 20);
                if (!game.isPause()) {
                    setTimer(getTimer() - 1);
                }
                //updates the time, it is divided by 60 because it moves at 60fps
                setCronos("TIEMPO: " + getTimer() / 60);

                //loopfor rendering all bricks
                for (int i = 0; i < enemigo.size(); i++) {
                    Mamut ET = enemigo.get(i);
                    ET.render(g);

                }

                for (int i = 0; i < blanco.size(); i++) {
                    MamutBlanco ETB = blanco.get(i);
                    ETB.render(g);

                }

                for (int i = 0; i < negro.size(); i++) {
                    MamutNegro ETN = negro.get(i);
                    ETN.render(g);

                }

                if (game.isPause()) {
                    g.drawImage(Assets.pauseN3, 250, 50, 300, 400, null);
                    save.render(g);
                    menu.render(g);
                }

                //draw score
                g.setFont(new Font("Serif", Font.PLAIN, 20));
                g.setColor(Color.BLACK);
                g.drawString("PUNTAJE: " + num, 2, 20);

            } else {

                if (getScene() == 0) {
                    g.drawImage(Assets.info2, 0, 0, width, height, null);
                    g.drawImage(next.getCurretFrame(), 230, 460, 300, 30, null);
                }
                if (getScene() == 1) {
                    g.drawImage(Assets.control2, 0, 0, width, height, null);
                    g.drawImage(next.getCurretFrame(), 230, 460, 300, 30, null);
                }
            }

            bs.show();
            g.dispose();
        }

    }
}
