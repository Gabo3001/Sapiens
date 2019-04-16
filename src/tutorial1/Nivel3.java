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
    private BallLevel3 ball;
    private KeyManager keyManager;
    private boolean start;          //Boolean that control the start
    private boolean pause;          //Boolean that control the pause



    public Nivel3(String title, int width, int height, Game game) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.game = game;
        keyManager = new KeyManager();
        plants = new LinkedList<PlantLevel3>();
        start = false;                  //Se inicializa start en false
        pause = true;                   //Pause is initialize in true
    }
    
    
    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

       public KeyManager getKeyManager() {
        return keyManager;
    }

    public void init() {
        player = new PlayerLevel3(330, getHeight() - 100, 1, 160, 80, game);
        ball = new BallLevel3(385, getHeight() - 145, 1, 50, 50, game);
        
        
        for(int i = 0; i < 5; i++){
            plants.add(new PlantLevel3(1*(i*60) + 10, 50, 50, 50, game, 1, 3));
        }
        
        
    }

    public void tick() {
         keyManager.tick();
        player.tick();
        
         ball.tick();
        
        //Si se preciona space
        if (getKeyManager().space){
            setStart(true);
            //Start when space bar is pressed
            ball.setSpeed(2);
        }

                //When p is press
        if (getKeyManager().pause){
            //if pause is true
            if (isPause()){
                //set pause to false
                setPause(false);
                //pStop is called set the key press back to false
                getKeyManager().kStop();
            }
            //if pause is false
            else{
                //set pause to true
                setPause(true);
                //pStop is called set the key press back to false
                getKeyManager().kStop();
            }
        }
        //Set the plants to their initial positions
            for (int i = 0; i < plants.size(); i++) {
                PlantLevel3 plant =  plants.get(i);
                plant.setLives(1);
                plant.setX(1*(i*70)+ 60);
                plant.tick();
                
                if(ball.intersecta(plant)){
                //brick lose one life
                plant.setLives(plant.getLives() - 1);
                
                //Make the ball bounce away from brick
                if(ball.getDirection() == 1)
                    ball.setDirection(3);
                
                else if(ball.getDirection() == 2)
                    ball.setDirection(4);
                
                else if(ball.getDirection() == 3)
                    ball.setDirection(1);
                
                else if(ball.getDirection() == 4)
                    ball.setDirection(2);
                }
            }
            
        //Si la pelota intersecta con el player en la mitad derecha
        if (player.intersecta(ball)) {
            //The direction of the ball is changed to 2
            ball.setDirection(2);
        }
        //Si la pelota intersecta con el player en la mitad derecha
        else if (player.intersecta2(ball)) {
            //The direction of the ball is changed to 1
            ball.setDirection(1);
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
             ball.render(g);

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

