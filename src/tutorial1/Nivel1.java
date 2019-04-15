/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

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
//    private Boton back;
    
    public Nivel1(String title, int width, int height, Game game) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.game = game;
        fruit = new LinkedList<Fruit>();
    //    g=graphics;
    }
    public void init() {
        //Start, help and back are initialized
        player = new Player(300,getHeight()-80,3,80,60,game);
        
        int iX;
        int range;
        int iY;
        for(int i = 0;i<10;i++){
            range=(game.getHeight())+1;//max-min
            iY = (int) (Math.random() * range);
            iX = (int) (Math.random() * 760);
            fruit.add(new Fruit(iX,0-iY ,40,40,game));
        }
        
    }
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    public void tick() {
        player.tick();
       // Assets.natural.play();
        for(int i=0;i<fruit.size();i++){
            Fruit food = fruit.get(i);
            food.tick();

            //Si el player intersecta al perseguidor
            if (player.intersecta(food)){
                //Se mueve el objeto a un lugar random en x dentro de los limites de la pantalla
                food.setX((int)(Math.random() * 760));
                //Se reposiciona el objeto en un lugar random a media pantlla arriba de la pantalla 
                int iPosY = (int) (Math.random() * getHeight() * 1/2)-getHeight();
                food.setY(iPosY);
                Assets.eat.play();
            }
            //Si la posicion en y del objeto supera el limite inferior de la pantaya
            if(food.getY() >= getHeight()){
                //Se mueve el objeto a un lugar random en x dentro de los limites de la pantalla                
                food.setX((int)(Math.random() * 760));
                //Se reposiciona el objeto en un lugar random a media pantlla arriba de la pantalla 
                int iPosY = (int) (Math.random() * getHeight() * 1/2)-getHeight();
                food.setY(iPosY);

            }
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
            for (int i = 0; i < fruit.size(); i++) {
            Fruit feed =  fruit.get(i);
            feed.render(g);
        }
            bs.show();
            g.dispose();
        }
    }
    
}
