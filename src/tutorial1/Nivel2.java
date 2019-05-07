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
   

private MamutN2 alien;
private Laser laser; //To use the ball
private boolean lasershoot;
private LinkedList<Mamut> enemigo;
private LinkedList<MamutBlanco> blanco;
private LinkedList<MamutNegro> negro;
private int score; // puntaje
private String num; //to display score
private int TotalAlien;//to keep track of total bricks
private int Win;//to keep score of destroyed bricks
private int lives;
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
    private quiz cognitive;
    
    public Nivel2(String title, int width, int height, Game game) { 
        this.title = title;
        this.width = width;
        this.height = height;
        this.game = game;
        enemigo = new LinkedList<Mamut>(); //lista que despliega los bricks
        blanco = new LinkedList<MamutBlanco>(); //lista que despliega los bricks
        negro = new LinkedList<MamutNegro>(); //lista que despliega los bricks
        score = 0; //puntaje es 0 cuando inicia el juego
        num = ""+score; //string que despliega en la pantalla el puntaje
        this.TotalAlien = 0; //se inicializa como 0 y ya despues se asignan los bricks con un for
        this.lasershoot=true;
        this.Win = 0; // se inicializa como 0 cuando inicia el juego porque todavia no destruye ningun brick
        start = false;
        this.lives= 3;
        scene = 0;
        this.next = new Animation(Assets.nextA, 500);
        this.timer = 60 * 50;//fps*time you want
        this.cronos = "tiempo: " + timer;
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

    public MamutN2 getAlien() {
        return alien;
    }

    public void setAlien(MamutN2 alien) {
        this.alien = alien;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getTotalAlien() {
        return TotalAlien;
    }

    public void setTotalAlien(int TotalAlien) {
        this.TotalAlien = TotalAlien;
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
    
    private int getWin() {
        return Win;
    }
    
    private void setWin(int i) {
       this.Win = i;
    }
    
    public void init() { 

        player = new Player(300, 430, 3, 60, 40, game);

        //we add the laser but with no size         
        laser = new Laser(0, 0, 0, 0, 0, game);
        
        //we create an alien matrix
        for(int j = 1; j <= 1; j++) {
            for (int i = 1; i <= 1; i++) {
                 enemigo.add(new Mamut(getWidth()-30 - 100*i ,5 + 110*j, 40, 40, game));  
                 setTotalAlien(getTotalAlien()+1); 
            } 
        }
        
            for(int j = 1; j <= 1; j++) {
            for (int i = 1; i <= 200; i++) {
                int iX = (int) (Math.random() * 800);
                 negro.add(new MamutNegro(getWidth()+10000 - iX*i ,5 + 170*j, 40, 40, game, 4));  
                 setTotalAlien(getTotalAlien()+1); 
            } 
        }
            
            for(int j = 1; j <= 1; j++) {
            for (int i = 1; i <= 200; i++) {
                int iX = (int) (Math.random() * 800);
                 negro.add(new MamutNegro(getWidth()+10000 - iX*i ,5 + 220*j, 40, 40, game,-4));  
                 setTotalAlien(getTotalAlien()+1); 
            } 
        }
                
            for(int j = 1; j <= 1; j++) {
            for (int i = 1; i <= 100; i++) {
                int iX = (int) (Math.random() * 800);
                 blanco.add(new MamutBlanco(getWidth()+10000 - iX*i ,5 + 270*j, 40, 40, game, -1));  
                 setTotalAlien(getTotalAlien()+1); 
            } 
        }
            for(int j = 1; j <= 1; j++) {
            for (int i = 1; i <= 100; i++) {
                int iX = (int) (Math.random() * 800);
                 blanco.add(new MamutBlanco(getWidth()-30 - iX*i ,5 + 320*j, 40, 40, game, 1));  
                 setTotalAlien(getTotalAlien()+1); 
            } 
        }
        
    
        menu = new Boton(413, 360, 100, 50, game, 5);
        save = new Boton(283, 360, 100, 50, game, 4);
    }
        
        
    public void tick() {
            if (getTimer() / 60 == 0) {
                //game.getDB().
            try {
                game.getDB().getQuizInfo("Cognitiva",cognitive,game);
            } catch (Exception ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
                try {
                    new DatabaseManager().updateScore(game.getScoreTableID(),"level2",game.getScore());
                } catch (Exception ex) {
                    Logger.getLogger(Nivel2.class.getName()).log(Level.SEVERE, null, ex);
                }
         
            
            game.setNivel(3);
        }
            
            if (isStart() && !game.isPause()) {
             
            //advancing player with colition
            player.tick();
            laser.tick();

              
             //we actualize the bricks for rendering
             for (int i = 0; i < enemigo.size(); i++) {
               Mamut marciano =  enemigo.get(i);
               marciano.tick();
               if(marciano.getX()>getWidth()+getWidth()/10 || marciano.getX()<-(getWidth()/10)){
                    for(int j = 0; j < enemigo.size(); j++){
                        Mamut alien = enemigo.get(j);
                        alien.SwitchLayer();
                    }
               }
               if(marciano.intersecta(laser)){
    //              Assets.alienExplosion.play();
                  marciano.changeAlive(); 
                  laser.destroy();
                  laser.canShoot();
                  setWin(getWin()+1);
                  //actualize score
                  setScore(getScore() + 100);
                  setNum(""+ getScore());
                  Assets.jabalia.play();
             }

                }
             
             
             
             
             
             
             
             
             for (int i = 0; i < blanco.size(); i++) {
               MamutBlanco marcianoB =  blanco.get(i);
               marcianoB.tick();
               if(marcianoB.getX()>getWidth()+220+getWidth()/2 || marcianoB.getX()<-(getWidth()/2)-260){
                    for(int j = 0; j < blanco.size(); j++){
               //         MamutBlanco alienB = blanco.get(j);
               //         alienB.SwitchLayer();
                    }
               }
               if(marcianoB.intersecta(laser)){
    //              Assets.alienExplosion.play();
                  marcianoB.changeAlive(); 
                  laser.destroy();
                  laser.canShoot();
                  setWin(getWin()+1);
                  //actualize score
                  setScore(getScore() + 10);
                  setNum(""+ getScore());
                  Assets.jabalia.play();
             }

                }
             
             
             
             
             
             
             
             
             
             
             for (int i = 0; i < negro.size(); i++) {
               MamutNegro marcianoN =  negro.get(i);
               marcianoN.tick();
               if(marcianoN.getX()>getWidth()+180+getWidth()/2 || marcianoN.getX()<-(getWidth()/2)-220){
                    for(int j = 0; j < negro.size(); j++){
                 //       MamutNegro alienN = negro.get(j);
                 //       alienN.SwitchLayer();
                    }
               }
               if(marcianoN.intersecta(laser)){
    //              Assets.alienExplosion.play();
                  marcianoN.changeAlive(); 
                  laser.destroy();
                  laser.canShoot();
                  setWin(getWin()+1);
                  //actualize score
                  setScore(getScore() + 50);
                  setNum(""+ getScore());
                  Assets.jabalia.play();
             }
 
                }
             
             
             
             
             
             
             

            if (game.getKeyManager().space && laser.isShooting()){
    //            Assets.laserSound.play();
            laser = new Laser( player.getX() + 11, player.getY()-10, 1, 20, 30, game);
            laser.cantShoot();
            }
            if(laser.getY()<0){
                laser.canShoot();
            }

             //logic for when the player loses a live

             if(laser.getY() > getHeight() && lives > 0 ){
                 lives = lives-1;
                 setScore(getScore() - 50);
                 setNum(""+ getScore());
         //        player.setX(320);
                 laser.setX(370);
                 laser.setY(player.getY() - 40); 
             }
             //sets our lose ocndition
             else if (lives == 0){ 
                 setScore(0);
                    setNum(""+score);
                    for(int w = 0; w<enemigo.size();w++){
                        Mamut Area51 = enemigo.get(w);
                        Area51.setAlive(false);
                    }
                    
                    
                    
                    
                    
                    
                    for(int w = 0; w<negro.size();w++){
                        MamutNegro Area51N = negro.get(w);
                        Area51N.setAlive(false);
                    }
                    
                    
                    
                    
                    
                    for(int w = 0; w<blanco.size();w++){
                        MamutBlanco Area51B = blanco.get(w);
                        Area51B.setAlive(false);
                    }
                    
                    
                    
                    
                    
       
                    lives = 3;
                    player.setSpeed(4);
    //                Assets.song.play();
                    laser.setX(0); 
                    laser.setY(0);
                    setWin(0);
                    setTotalAlien(0);
                
             }


    }
            else {
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
            }
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
                g.setColor(Color.WHITE);
                g.drawString(cronos, 670, 480);
                if (!game.isPause()) {
                    setTimer(getTimer() - 1);
                }
                //updates the time, it is divided by 60 because it moves at 60fps
                setCronos("TIEMPO: " + getTimer() / 60);
        
                //loopfor rendering all bricks
                for (int i = 0; i < enemigo.size(); i++) {
                    Mamut ET =  enemigo.get(i);
                    ET.render(g);

                }
                
                
                
                for (int i = 0; i < blanco.size(); i++) {
                    MamutBlanco ETB =  blanco.get(i);
                    ETB.render(g);

                }
                
                
                
                
                
                
                for (int i = 0; i < negro.size(); i++) {
                    MamutNegro ETN =  negro.get(i);
                    ETN.render(g);

                }
       
                if (game.isPause()) {
                    g.drawImage(Assets.pauseN3, 250, 50, 300, 400, null);
                    save.render(g);
                    menu.render(g);
                }
     
        
            //draw score
                   g.setFont(new Font("Serif", Font.PLAIN, 20));
                   g.setColor(Color.WHITE);
                   g.drawString("PUNTAJE: " + num, 2, 480);

        
        } else {

                if (getScene() == 0) {
                    g.drawImage(Assets.control2, 0, 0, width, height, null);
                    g.drawImage(next.getCurretFrame(), 230, 460, 300, 30, null);
                }
                if (getScene() == 1) {
                    g.drawImage(Assets.info2, 0, 0, width, height, null);
                    g.drawImage(next.getCurretFrame(), 230, 460, 300, 30, null);
                }
            }
       
        bs.show();
        g.dispose();
    }

}
}
