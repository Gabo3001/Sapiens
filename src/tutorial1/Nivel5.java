/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Ready for level 5
//try {
//    new DatabaseManager().updateScore(game.getScoreTableID(),"level5",game.getScore());
//} catch (Exception ex) {
//    Logger.getLogger(Nivel2.class.getName()).log(Level.SEVERE, null, ex);
//}
package tutorial1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HOME
 */
public class Nivel5 {

    private int width;
    private int height;
    private Game game;
    private BufferStrategy bs;
    private Graphics g;
    private Boton hacha;
    private Boton pala;
    private Boton martillo;
    private Boton telescopio;
    private Boton sierra;
    private Boton tijera;
    private Boton regla;
    private Boton peine;
    private boolean i1;
    private boolean i2;
    private boolean i3;
    private boolean i4;
    private boolean i5;
    private boolean i6;
    private boolean i7;
    private boolean i8;
    private Boton menu;
    private Boton save;
    private int cont;
    private Animation next;
    private boolean start;
    private int scene;
    private SoundClip songN5;
    String title;
    private int timer;
    private int cronos;
    private int Timeobj1;
    private int Timeobj2;
    private int Timeobj3;
    private int Timeobj4;
    private int Timeobj5;
    private int Timeobj6;
    private int Timeobj7;
    private int Timeobj8;
    private int sX;
    private int sY;
    private int sX2;
    private int sXY;
    private int N;
    private int PivoteAnterior;
    private int var;

    public Nivel5(String title, int width, int height, Game game) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.game = game;
        i1 = false;
        i2 = false;
        i3 = false;
        i4 = false;
        i5 = false;
        i6 = false;
        i7 = false;
        i8 = false;
        cont = 0;
        scene = 0;
        start = false;
        this.next = new Animation(Assets.nextA, 500);
        songN5 = new SoundClip("/tutorial1/sounds/N5.wav", -3f, true);
        this.cronos = 0;
        this.timer = 0;
        this.Timeobj1 = 0;
        this.Timeobj2 = 0;
        this.Timeobj3 = 0;
        this.Timeobj4 = 0;
        this.Timeobj5 = 0;
        this.Timeobj6 = 0;
        this.Timeobj7 = 0;
        this.Timeobj8 = 0;
        this.sX = sX;
        this.sY = sY;
        this.sX2 = sX2;
        this.sXY = sXY;
        this.N = 8;
        this.PivoteAnterior = 1;
        this.var = 100;

    }

    /**
     *
     * @return
     */
    public int getTimer() {
        return timer;
    }

    /**
     *
     * @return
     */
    public int getCronos() {
        return cronos;
    }

    /**
     *
     * @param t
     */
    public void setCronos(int t) {
        if (t != 0) {
            this.cronos = t;
        }
    }

    /**
     *
     * @param t
     */
    public void setTimer(int t) {
        if (t != 0) {
            this.timer = t;
        }
    }

    public void setTimeObj1(int t) {
        this.Timeobj1 = t;
    }

    public void setTimeObj2(int t) {
        this.Timeobj2 = t;
    }

    public void setTimeObj3(int t) {
        this.Timeobj3 = t;
    }

    public void setTimeObj4(int t) {
        this.Timeobj4 = t;
    }

    public void setTimeObj5(int t) {
        this.Timeobj5 = t;
    }

    public void setTimeObj6(int t) {
        this.Timeobj6 = t;
    }

    public void setTimeObj7(int t) {
        this.Timeobj7 = t;
    }

    public void setTimeObj8(int t) {
        this.Timeobj8 = t;
    }

    public int getTimeObj1() {
        return Timeobj1;
    }

    public int getTimeObj2() {
        return Timeobj2;
    }

    public int getTimeObj3() {
        return Timeobj3;
    }

    public int getTimeObj4() {
        return Timeobj4;
    }

    public int getTimeObj5() {
        return Timeobj5;
    }

    public int getTimeObj6() {
        return Timeobj6;
    }

    public int getTimeObj7() {
        return Timeobj7;
    }

    public int getTimeObj8() {
        return Timeobj8;
    }

    public void setScene(int scene) {
        this.scene = scene;
    }

    public int getScene() {
        return scene;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public boolean isStart() {
        return start;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public int getCont() {
        return cont;
    }

    public boolean isI8() {
        return i8;
    }

    public boolean isI7() {
        return i7;
    }

    public boolean isI6() {
        return i6;
    }

    public boolean isI5() {
        return i5;
    }

    public boolean isI4() {
        return i4;
    }

    public boolean isI3() {
        return i3;
    }

    public boolean isI2() {
        return i2;
    }

    public boolean isI1() {
        return i1;
    }

    public void setI8(boolean i8) {
        this.i8 = i8;
    }

    public void setI7(boolean i7) {
        this.i7 = i7;
    }

    public void setI6(boolean i6) {
        this.i6 = i6;
    }

    public void setI5(boolean i5) {
        this.i5 = i5;
    }

    public void setI4(boolean i4) {
        this.i4 = i4;
    }

    public void setI3(boolean i3) {
        this.i3 = i3;
    }

    public void setI2(boolean i2) {
        this.i2 = i2;
    }

    public void setI1(boolean i1) {
        this.i1 = i1;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void init() {
        pala = new Boton(10, 10, 30, 45, game, 0);
        martillo = new Boton(200, 290, 33, 48, game, 0);
        sierra = new Boton(430, 8, 45, 108, game, 0);
        peine = new Boton(700, 191, 55, 22, game, 0);
        hacha = new Boton(127, 65, 60, 45, game, 0);
        tijera = new Boton(130, 207, 45, 32, game, 0);
        telescopio = new Boton(600, 18, 43, 67, game, 0);
        regla = new Boton(438, 308, 15, 46, game, 0);
        menu = new Boton(413, 360, 100, 50, game, 5);
        save = new Boton(283, 360, 100, 50, game, 4);
    }

    //implements a numeric method to get the score of the game
    public void MetodosN() {

        //The sumatory of the number from 1 to 8
        sX = 36;
        //Sum of all the times
        sY = getTimeObj1() + getTimeObj2() + getTimeObj3() + getTimeObj4() + getTimeObj5() + getTimeObj6() + getTimeObj7() + getTimeObj8();
        //The sumatory of the number from 1 to 8 to the square
        sX2 = 204;
        //Sum of the values of x * the values of y
        sXY = (1 * getTimeObj1() + 2 * getTimeObj2() + 3 * getTimeObj3() + 4 * getTimeObj4() + 5 * getTimeObj5() + 6 * getTimeObj6() + 7 * getTimeObj7() + 8 * getTimeObj8());

        //Initialize the matrix 
        int mati[][] = {{N, sX, sY}, {sX, sX2, sXY}};
        //Montante is called to solve the matrix
        for (int i = 0; i < 2; i++) {
            for (int k = 0; k < 2; k++) {

                if (i != k) {
                    for (int j = (i + 1); j < 3; j++) {
                        mati[k][j] = (mati[i][i] * mati[k][j] - mati[k][i] * mati[i][j]) / PivoteAnterior;
                    }
                }

            }
            PivoteAnterior = mati[i][i];
        }
        //The data is save on an array
        int[] data = new int[2];
        for (int i = 0; i < 2; i++) {

            data[i] = mati[i][2] / PivoteAnterior;
        }
        //The data is recolected
        int a1 = data[0];
        int a2 = data[1];
        //The resulting function is evalueted in 10
        int func = a1 * var + a2;
        //if funtion is greater than 5000 the player dont resive points
        if (func < 5000) {
            game.setScore(game.getScore() + (5000 - func));
        }

    }

    public void tick() {

        //If start is true and not in pause
        if (isStart() && !game.isPause()) {
            //If theres no song playing
            if (songN5.isStop()) {
                //Reproduce el clip
                songN5.play();
            }
            //if axe is clicked
            if (hacha.intersecta(game.getMouseManager())) {
                if (!isI1()) {
                    setTimeObj1(getCronos());
                    //Blink sound is played
                    Assets.blink.play();
                    //The conuter increase in one
                    setCont(getCont() + 1);
                }
                //i1 is set on true
                setI1(true);
                //The position of the mouse is moved
                game.getMouseManager().setX(0);
                game.getMouseManager().setY(0);
            }
            //if hammer is clicked
            if (martillo.intersecta(game.getMouseManager())) {

                if (!isI2()) {
                    setTimeObj2(getCronos());
                    //Blink sound is played
                    Assets.blink.play();
                    //The conuter increase in one
                    setCont(getCont() + 1);
                }
                //i2 is set on true
                setI2(true);
                //The position of the mouse is moved
                game.getMouseManager().setX(0);
                game.getMouseManager().setY(0);
            }
            //if shovel is clicked
            if (pala.intersecta(game.getMouseManager())) {

                if (!isI3()) {
                    setTimeObj3(getCronos());
                    //Blink sound is played
                    Assets.blink.play();
                    //The conuter increase in one
                    setCont(getCont() + 1);
                }
                //i3 is set on true
                setI3(true);
                //The position of the mouse is moved
                game.getMouseManager().setX(0);
                game.getMouseManager().setY(0);
            }
            //if hair comb is clicked
            if (peine.intersecta(game.getMouseManager())) {

                if (!isI4()) {
                    setTimeObj4(getCronos());
                    //Blink sound is played
                    Assets.blink.play();
                    //The conuter increase in one
                    setCont(getCont() + 1);
                }
                //i4 is set on true
                setI4(true);
                //The position of the mouse is moved
                game.getMouseManager().setX(0);
                game.getMouseManager().setY(0);
            }
            //if ruler is clicked
            if (regla.intersecta(game.getMouseManager())) {

                if (!isI5()) {
                    setTimeObj5(getCronos());
                    //Blink sound is played
                    Assets.blink.play();
                    //The conuter increase in one
                    setCont(getCont() + 1);
                }
                //i5 is set on true
                setI5(true);
                //The position of the mouse is moved
                game.getMouseManager().setX(0);
                game.getMouseManager().setY(0);
            }
            //if saw is clicked
            if (sierra.intersecta(game.getMouseManager())) {

                if (!isI6()) {
                    setTimeObj6(getCronos());
                    //Blink sound is played
                    Assets.blink.play();
                    //The conuter increase in one
                    setCont(getCont() + 1);
                }
                //i6 is set on true
                setI6(true);
                //The position of the mouse is moved
                game.getMouseManager().setX(0);
                game.getMouseManager().setY(0);
            }
            //if telescope is clicked
            if (telescopio.intersecta(game.getMouseManager())) {

                if (!isI7()) {
                    setTimeObj7(getCronos());
                    //Blink sound is played
                    Assets.blink.play();
                    //The conuter increase in one
                    setCont(getCont() + 1);
                }
                //i7 is set on true
                setI7(true);
                //The position of the mouse is moved
                game.getMouseManager().setX(0);
                game.getMouseManager().setY(0);
            }
            //if scissors is clicked
            if (tijera.intersecta(game.getMouseManager())) {

                if (!isI8()) {
                    setTimeObj8(getCronos());
                    //Blink sound is played
                    Assets.blink.play();
                    //The conuter increase in one
                    setCont(getCont() + 1);
                }
                //i8 is set on true
                setI8(true);
                //The position of the mouse is moved
                game.getMouseManager().setX(0);
                game.getMouseManager().setY(0);
            }
        } else if (game.isPause() && isStart()) {
            //If theres no song playing
            if (songN5.isStop()) {
                //Reproduce el clip
                songN5.play();
            }
            //if menu is clicked
            if (menu.intersecta(game.getMouseManager()) && game.isPause()) {
                game.setWhatLevel(5);
                game.setNivel(0);
                //The song is pause
                songN5.pause();
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
                //The function kStop is called
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
            if (songN5.isStop()) {
                //Reproduce el clip
                songN5.play();
            }
        }
        //If the counter get to 8
        if (getCont() == 8) {
            MetodosN();
            try {
                //The game is set on the level 5

                new DatabaseManager().updateScore(game.getScoreTableID(), "level5", game.getScore());
            } catch (Exception ex) {
                Logger.getLogger(Nivel5.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                game.getDB().getScoreBoard();
            } catch (Exception ex) {
                Logger.getLogger(Nivel5.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Last score is set on the last score you get through the level
            game.setLastScore(game.getScore());
            //The song is stop
            songN5.stop();
            game.setNivel(6);
        }
    }

    /**
     * This function reset the level one to its original state
     */
    public void reset() {
        //The counter of the apples is back to 0
        setCont(0);
        //The scene is set on 0
        setScene(0);
        //Start is set on false
        setStart(false);
        //All the booleans for the tools are set on false
        setI1(false);
        setI2(false);
        setI3(false);
        setI4(false);
        setI5(false);
        setI6(false);
        setI7(false);
        setI8(false);
        //Set the time on 0
        setCronos(0);
        setTimer(0);
        //The time when the objects are found are set on 0
        setTimeObj1(0);
        setTimeObj2(0);
        setTimeObj3(0);
        setTimeObj4(0);
        setTimeObj5(0);
        setTimeObj6(0);
        setTimeObj7(0);
        setTimeObj8(0);
        //The score is set to the same score as it started
        game.setScore(game.getLastScore());
        //The song start from the begining
        songN5.stop();
        songN5.setfPosition(0);
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
                if (!game.isPause()) {
                    setTimer(getTimer() + 1);
                    setCronos(getTimer() / 60);
                }
                g.drawImage(Assets.backgroundLevel5, 0, 0, width, height, null);
                //g.drawString("Usuario: "+game.getUsername(), getWidth() - getWidth() / 4, 0 + getHeight() / 15);
                if (!isI1()) {
                    g.drawImage(Assets.hachaBW, 80, 370, 80, 50, null);
                } else {
                    g.drawImage(Assets.hacha, 80, 370, 80, 50, null);
                }
                if (!isI2()) {
                    g.drawImage(Assets.martilloBW, 160, 368, 70, 50, null);
                } else {
                    g.drawImage(Assets.martillo, 160, 368, 70, 50, null);
                }
                if (!isI3()) {
                    g.drawImage(Assets.palaBW, 240, 368, 70, 50, null);
                } else {
                    g.drawImage(Assets.pala, 240, 368, 70, 50, null);
                }
                if (!isI4()) {
                    g.drawImage(Assets.peineBW, 330, 370, 70, 50, null);
                } else {
                    g.drawImage(Assets.peine, 330, 370, 70, 50, null);
                }
                if (!isI5()) {
                    g.drawImage(Assets.reglaBW, 415, 360, 40, 60, null);
                } else {
                    g.drawImage(Assets.regla, 415, 360, 40, 60, null);
                }
                if (!isI6()) {
                    g.drawImage(Assets.sierraBW, 480, 365, 70, 50, null);
                } else {
                    g.drawImage(Assets.sierra, 480, 365, 70, 50, null);
                }
                if (!isI7()) {
                    g.drawImage(Assets.telescopioBW, 580, 368, 70, 50, null);
                } else {
                    g.drawImage(Assets.telescopio, 580, 368, 70, 50, null);
                }
                if (!isI8()) {
                    g.drawImage(Assets.tijeraBW, 680, 368, 70, 50, null);
                } else {
                    g.drawImage(Assets.tijera, 680, 368, 70, 50, null);
                }
                if (game.isPause()) {
                    g.drawImage(Assets.pauseN5, 250, 50, 300, 400, null);
                    save.render(g);
                    menu.render(g);
                }
            } else {
                if (getScene() == 0) {
                    g.drawImage(Assets.rev3, 0, 0, width, height, null);
                    g.drawImage(next.getCurretFrame(), 230, 460, 300, 30, null);
                }
                if (getScene() == 1) {
                    g.drawImage(Assets.info5, 0, 0, width, height, null);
                    g.drawImage(next.getCurretFrame(), 230, 460, 300, 30, null);
                }
                if (getScene() == 2) {
                    g.drawImage(Assets.control5, 0, 0, width, height, null);
                    g.drawImage(next.getCurretFrame(), 230, 460, 300, 30, null);
                }
            }

            bs.show();
            g.dispose();
        }
    }

}
