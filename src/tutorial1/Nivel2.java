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
 *
 * @author karymenahleacosta
 */
public class Nivel2 {
   

private MamutN2 alien;
private LinkedList<Bomb> bomb;
private Laser laser; //To use the ball
private boolean lasershoot;
private LinkedList<Mamut> enemigo;
private int score; // puntaje
private String num; //to display score
private int TotalAlien;//to keep track of total bricks
private int Win;//to keep score of destroyed bricks
private int lives;

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
    
    public Nivel2(String title, int width, int height, Game game) { 
        this.title = title;
        this.width = width;
        this.height = height;
        this.game = game;
        enemigo = new LinkedList<Mamut>(); //lista que despliega los bricks
        bomb = new LinkedList<Bomb>();
        score = 0; //puntaje es 0 cuando inicia el juego
        num = ""+score; //string que despliega en la pantalla el puntaje
        this.TotalAlien = 0; //se inicializa como 0 y ya despues se asignan los bricks con un for
        this.lasershoot=true;
        this.Win = 0; // se inicializa como 0 cuando inicia el juego porque todavia no destruye ningun brick
        start = true;
        this.lives= 3;
        scene = 0;
        this.next = new Animation(Assets.nextA, 500);
    }

    public Animation getNext() {
        return next;
    }

    public void setNext(Animation next) {
        this.next = next;
    }

    public int getScene() {
        return scene;
    }

    public void setScene(int scene) {
        this.scene = scene;
    }

    public MamutN2 getAlien() {
        return alien;
    }

    public void setAlien(MamutN2 alien) {
        this.alien = alien;
    }

    
    public LinkedList<Bomb> getBomb() {
        return bomb;
    }

    public void setBomb(LinkedList<Bomb> bomb) {
        this.bomb = bomb;
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

    public LinkedList<Mamut> getEnemigo() {
        return enemigo;
    }

    public void setEnemigo(LinkedList<Mamut> enemigo) {
        this.enemigo = enemigo;
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
        for(int j = 1; j <= 4; j++) {
            for (int i = 1; i <= 6; i++) {
                 enemigo.add(new Mamut(getWidth()-30 - 100*i ,5 + 60*j, 40, 40, game));  
                 setTotalAlien(getTotalAlien()+1);
                 bomb.add( new Bomb(100,getHeight()+100,10,16,game)); 
            } 
        }
        
    
        menu = new Boton(413, 360, 100, 50, game, 5);
        save = new Boton(283, 360, 100, 50, game, 4);
    }
        
        
    public void tick() {
            if(getTotalAlien() == getWin()){
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
               Bomb beam = bomb.get(i);
               beam.tick();
               if(marciano.getX()>getWidth()-marciano.getWidth() || marciano.getX()<-2){
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
             }
               if(marciano.intersect(player) || marciano.getY()+marciano.getHeight()>getHeight()){
    //               Assets.deadPlayer.play();
                    lives = lives-1;
                    setScore(getScore() - 50);
                    setNum(""+ getScore());
             //       player.setX(320);
                    laser.setX(370);
                    laser.setY(-100); 
                    for(int k = 0; k <enemigo.size();k++){
                        Mamut xenomorph = enemigo.get(k);
                        xenomorph.reset();
                        Bomb granada = bomb.get(k);
                        granada.setY(getHeight()+100);
                    }
             }
               int iNum = (int) (Math.random() * 1000);
               if(iNum > 995 && marciano.isAlive() && !beam.isActive()){
    //               Assets.alienBeam.play();
                   beam.setX(marciano.getX());
                   beam.setY(marciano.getY());
                   beam.setActive(true);
               }
               if(beam.intersecta(player)){
      //             Assets.deadPlayer.play();
                   lives=lives-1;
                   setScore(getScore() - 50);
                   setNum(""+ getScore());
                   beam.setActive(false);
          //         player.setX(320);
                   laser.setY(-100);
                  for(int k = 0; k <enemigo.size();k++){
                        Mamut xenomorph = enemigo.get(k);
                    //    xenomorph.reset();
                       Bomb granada = bomb.get(k);
                        granada.setY(getHeight()+100);
                   }
               }
                }

            if (game.getKeyManager().space && laser.isShooting()){
    //            Assets.laserSound.play();
            laser = new Laser( player.getX() + 11, player.getY()-10, 1, 10, 20, game);
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
        //            player.setX(getWidth()/2-48);
        //            player.setY(getHeight()-60);
                    lives = 3;
                    player.setSpeed(4);
    //                Assets.song.play();
                    laser.setX(0); 
                    laser.setY(0);
                    setWin(0);
                    setTotalAlien(0);
                    //Se vuelve a desplegar la matriz de bricksfor(int j = 1; j <= 4; j++) {
                for(int j = 1; j <= 4; j++) {
                for (int i = 1; i <= 6; i++) {
                 enemigo.add(new Mamut(getWidth()-30 - 100*i ,5 + 60*j, 40, 40, game));  
                 setTotalAlien(getTotalAlien()+1);
                 bomb.add( new Bomb(100,getHeight()+100,8,16,game)); 
            } 
        }
                
             }


    }/*else {
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
            //When scene reaches 3
            if (getScene() == 3) {
                //start is set on true
                setStart(true);
            }
}*/  
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
        
                //loopfor rendering all bricks
                for (int i = 0; i < enemigo.size(); i++) {
                    Mamut ET =  enemigo.get(i);
                    ET.render(g);
 
        //Para mostrar puntaje ganado
 //           if(ET.getTime()>0&&!ET.isAlive()){
 //              g.setColor(Color.WHITE);
 //              g.drawString("+100", ET.getX(), ET.getY()); 
 //              ET.setTime(ET.getTime()-1);
 //             }
                    Bomb boom=bomb.get(i);
                    boom.render(g);
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

        
        } /*else {
                if (getScene() == 0) {
                    g.drawImage(Assets.rev2, 0, 0, width, height, null);
                    g.drawImage(next.getCurretFrame(), 230, 460, 300, 30, null);
                }
                if (getScene() == 1) {
                    g.drawImage(Assets.info1, 0, 0, width, height, null);
                    g.drawImage(next.getCurretFrame(), 230, 460, 300, 30, null);
                }
                if (getScene() == 2) {
                    g.drawImage(Assets.control1, 0, 0, width, height, null);
                    g.drawImage(next.getCurretFrame(), 230, 460, 300, 30, null);
                }
            }*/
       
        bs.show();
        g.dispose();
    }

}
}

