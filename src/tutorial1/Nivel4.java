/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

/**
 *
 * @author Electel
 */
public class Nivel4 {
    
    
    private int width;
    private int height;
    private Game game;
    private BufferStrategy bs;
    private Graphics g;
    String title;
    private Player player;
    private LinkedList<Arrow4> arrow;
    private int timer;
    private String cronos;
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
        this.timer=120000;
        this.cronos = "tiempo: "+timer;
    //    g=graphics;
    }
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public String getCronos(){
        return cronos;
    }
    
    public void setCronos(String t){
        this.cronos = t;
    }
    
    public int getTimer(){
        return timer;
    }
    
    public void setTimer(int t){
        if(t!=0)
        this.timer = t;
    }
    
    /**
     *
     */
    public void init(){
        player = new Player(getWidth()/2-40,getHeight()-getHeight()/4,3,80,60,game);
        
        int iX;
        int range;
        int iY;
        for(int i = 0;i<10;i++){
            range=(game.getWidth())+1;//max-min
            iY = (int) (Math.random() * range);
            iX = (int) (Math.random() * range);
            arrow.add(new Arrow4(getWidth()+iX,getHeight()-getHeight()/4 ,72,24,game));
        }
    }

    /**
     *
     */
    public void tick(){
        player.tick();
         for(int i=0;i<arrow.size();i++){
            Arrow4 quiver = arrow.get(i);
            quiver.tick();
        }
    }
    
        public void render() {
        bs = game.getDisplay().getCanvas().getBufferStrategy();

        if (bs == null) {
            game.getDisplay().getCanvas().createBufferStrategy(3);
        } else {
            g = bs.getDrawGraphics();
            g.drawImage(Assets.backgroundLevel1, 0, 0, width, height, null);
            player.render(g);
            for (int i = 0; i < arrow.size(); i++) {
            Arrow4 quiver =  arrow.get(i);
            quiver.render(g);
            g.setColor(Color.WHITE);
            g.drawString(cronos, 100, 100);
            setTimer(getTimer()-1);
            setCronos("tiempo: "+getTimer()/120);
        }
            bs.show();
            g.dispose();
        }
    }
}
