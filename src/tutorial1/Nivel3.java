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
    private LinkedList<PlantLevel3> corn;     //linked list for corn
    private LinkedList<PlantLevel3> pepper;
    private LinkedList<PlantLevel3> tomato;
    private BallLevel3 ball;
    private KeyManager keyManager;
    private boolean start;
    private Boton menu;
    private Boton save;
    private int scene;
    private Animation next;





    public Nivel3(String title, int width, int height, Game game) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.game = game;
        keyManager = new KeyManager();
        corn = new LinkedList<PlantLevel3>();
        pepper = new LinkedList<PlantLevel3>();
        tomato = new LinkedList<PlantLevel3>();
        start = false;
        this.next = new Animation(Assets.nextA, 500);
        scene = 0;

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

    public void init() {
        player = new PlayerLevel3(330, getHeight() - 100, 1, 160, 80, game);
        ball = new BallLevel3(385, getHeight() - 145, 1, 40, 50, game);
        
        
        for(int i = 0; i < 8; i++){
            corn.add(new PlantLevel3(1*(i*100) + 40, 30, 70, 70, game, 1, 3));
        }
        
        for(int i = 0; i < 4; i++){
            pepper.add(new PlantLevel3(1*(i*100) + 50, 100, 70, 70, game, 2, 3));
        }
        
          for(int i = 0; i < 4; i++){
            tomato.add(new PlantLevel3(1*(i*100) + 420, 100, 70, 70, game, 3, 3));
        }
          
        menu = new Boton(413, 360, 100, 50, game, 5);
        save = new Boton(283, 360, 100, 50, game, 4);
        
    }

    public void tick() {
        
        if (isStart() && !game.isPause()) {
        keyManager.tick();
        player.tick();
        ball.tick();
        
        //Make all corn plants tick
            for (int i = 0; i < corn.size(); i++) {
                PlantLevel3 plant =  corn.get(i);
                plant.tick();
                
                if(ball.intersecta(plant) && plant.getLives() > 1){
                //corn loses one life
                plant.setLives(plant.getLives() - 1);
                
                //Make the ball bounce away from plant
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
            
            //make all peppers tick
            for (int i = 0; i < pepper.size(); i++) {
                PlantLevel3 plant =  pepper.get(i);
                plant.tick();
                
                if(ball.intersecta(plant) && plant.getLives() > 1){
                //pepper plant lose one life
                plant.setLives(plant.getLives() - 1);
                
                //Make the ball bounce away from plant
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
            
            //Make tomato plants tick
             for (int i = 0; i < tomato.size(); i++) {
                PlantLevel3 plant =  tomato.get(i);
                plant.tick();
                
                if(ball.intersecta(plant) && plant.getLives() > 1){
                //tomato plant lose one life
                plant.setLives(plant.getLives() - 1);
                
                //Make the ball bounce away from plant
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
       
        }else {
            //When the n key is pressed
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
        }
       //if menu is clicked
       if (menu.intersecta(game.getMouseManager()) && game.isPause()) {
                game.setNivel(0);
        }
        
    }

    public void render() {
        bs = game.getDisplay().getCanvas().getBufferStrategy();

        if (bs == null) {
            game.getDisplay().getCanvas().createBufferStrategy(3);
        } else {
            g = bs.getDrawGraphics();
            if (isStart()) {
             g.drawImage(Assets.backgroundLevel3, 0, 0, width, height, null);
             player.render(g);
             ball.render(g);

               //render plants
            for (int i = 0; i < corn.size(); i++) {
                PlantLevel3 plant =  corn.get(i);
                plant.render(g);
            }
            
            for (int i = 0; i < pepper.size(); i++) {
                PlantLevel3 plant =  pepper.get(i);
                plant.render(g);
            }
            
            for (int i = 0; i < tomato.size(); i++) {
                PlantLevel3 plant =  tomato.get(i);
                plant.render(g);
            }
            
            if (game.isPause()) {
                    g.drawImage(Assets.pauseN1, 250, 50, 300, 400, null);
                    save.render(g);
                    menu.render(g);
                }
            }else{
                if(getScene() == 0){
                    g.drawImage(Assets.rev1, 0, 0, width, height, null);
                    g.drawImage(next.getCurretFrame(), 230, 460, 300, 30, null);
                }
                if(getScene() == 1){
                    g.drawImage(Assets.info1, 0, 0, width, height, null);
                    g.drawImage(next.getCurretFrame(), 230, 460, 300, 30, null);
                }
                if(getScene() == 2){
                    g.drawImage(Assets.control1, 0, 0, width, height, null);
                    g.drawImage(next.getCurretFrame(), 230, 460, 300, 30, null);
                }
            }
            
            bs.show();
            g.dispose();
        }
    }

}

