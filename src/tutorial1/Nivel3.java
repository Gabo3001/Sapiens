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
 * @author HOME
 */
public class Nivel3 {

    private int width;
    private int height;
    private Game game;
    private BufferStrategy bs;
    private Graphics g;
    String title;
    private PlayerLevel3 player;
    private LinkedList<PlantLevel3> plants;     //linked list for the small bricks



    public Nivel3(String title, int width, int height, Game game) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.game = game;
        plants = new LinkedList<PlantLevel3>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void init() {
        player = new PlayerLevel3(330, getHeight() - 100, 1, 160, 80, game);
        for(int i = 0; i < 13; i++){
            plants.add(new PlantLevel3(1*(i*60)+ 10, 50, 50, 50, game, 1, 1));
        }
    }

    public void tick() {
        player.tick();
        
        //Set the plants to their initial positions
            for (int i = 0; i < plants.size(); i++) {
                PlantLevel3 plant =  plants.get(i);
                plant.setLives(1);
                plant.setX(1*(i*60)+ 10);
                plant.tick();
            }
        
    }

    public void render() {
        bs = game.getDisplay().getCanvas().getBufferStrategy();

        if (bs == null) {
            game.getDisplay().getCanvas().createBufferStrategy(3);
        } else {
            g = bs.getDrawGraphics();
            
             g.drawImage(Assets.backgroundLevel3, 0, 0, width, height, null);
             player.render(g);

               //render plants
            for (int i = 0; i < plants.size(); i++) {
                PlantLevel3 plant =  plants.get(i);
                plant.render(g);
            }
            bs.show();
            g.dispose();
        }
    }

}

