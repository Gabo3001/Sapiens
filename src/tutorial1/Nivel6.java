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
    String title;

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
        D = new Boton(532, 440, 70, 60, game, 8);
        for (int i = 0; i < 10; i++) {
            yellow.add(new Bulbo(228, -90, 80, 90, game, 1));
        }
        for (int i = 0; i < 10; i++) {
            blue.add(new Bulbo(376, -90, 80, 90, game, 2));
        }
        for (int i = 0; i < 10; i++) {
            purple.add(new Bulbo(525, -90, 80, 90, game, 3));
        }
    }

    public void tick() {
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
    }

    public void render() {
        bs = game.getDisplay().getCanvas().getBufferStrategy();

        if (bs == null) {
            game.getDisplay().getCanvas().createBufferStrategy(3);
        } else {
            g = bs.getDrawGraphics();
            if(getLightsUp() > 140){
                g.drawImage(Assets.city8, 0, 0, width, height, null);
            } else if(getLightsUp() > 120){
                g.drawImage(Assets.city7, 0, 0, width, height, null);
            } else if(getLightsUp() > 100){
                g.drawImage(Assets.city6, 0, 0, width, height, null);
            } else if(getLightsUp() > 80){
                g.drawImage(Assets.city5, 0, 0, width, height, null);
            } else if(getLightsUp() > 60){
                g.drawImage(Assets.city4, 0, 0, width, height, null);
            } else if(getLightsUp() > 40){
                g.drawImage(Assets.city3, 0, 0, width, height, null); 
            } else if(getLightsUp() > 20){
                g.drawImage(Assets.city2, 0, 0, width, height, null);
            } else {
                g.drawImage(Assets.city1, 0, 0, width, height, null);
            }
            g.setColor(Color.WHITE);
            g.setFont(new Font("Serif", Font.PLAIN, 20));
            g.drawString("Usuario: "+game.getUsername(), getWidth() - getWidth() / 4, 0 + getHeight() / 15);
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
            bs.show();
            g.dispose();
        }
    }
}
