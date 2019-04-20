/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import java.awt.image.BufferedImage;

/**
 *
 * @author HOME
 */
public class Assets {
    public static BufferedImage background;
    public static BufferedImage backgroundLevel1;
    public static BufferedImage playerLevel1;
    public static BufferedImage fruit;
    public static BufferedImage start;
    public static BufferedImage help;
    public static BufferedImage info;
    public static BufferedImage back;
    public static BufferedImage menu;
    public static BufferedImage save;
    public static BufferedImage pauseN1;
    public static BufferedImage rev1;
    public static BufferedImage info1;
    public static BufferedImage control1;
    public static BufferedImage next;
    public static BufferedImage nextA[];
    public static BufferedImage spritesR;
    public static BufferedImage spritesL;
    public static BufferedImage playerRight[];
    public static BufferedImage playerLeft[];
    public static SoundClip eat;
    
    //Level 3
    public static BufferedImage backgroundLevel3;
    public static BufferedImage water;
    public static BufferedImage playerLevel3; 
    public static BufferedImage pauseN3;
    public static BufferedImage control3;
    public static BufferedImage info3;
    public static BufferedImage cornFirst; //sprite for corn's first stage
    public static BufferedImage cornSecond; //sprite for corn's second stage
    public static BufferedImage cornThird; //sprite for corn's third stage
    public static BufferedImage pepperFirst; //sprite for pepper's first stage
    public static BufferedImage pepperSecond; //sprite for pepper's second stage
    public static BufferedImage pepperThird; //sprite for pepper's third stage
    public static BufferedImage tomatoFirst; //sprite for tomato's first stage
    public static BufferedImage tomatoSecond; //sprite for tomato's second stage
    public static BufferedImage tomatoThird; //sprite for tomato's third stage
    
    
    
    public static void init(){
        background = ImageLoader.loadImage("/tutorial1/images/Background.png");
        backgroundLevel1 = ImageLoader.loadImage("/tutorial1/images/BkLvl1.jpeg");
        backgroundLevel3 = ImageLoader.loadImage("/tutorial1/images/field.png");
        playerLevel1 = ImageLoader.loadImage("/tutorial1/images/monito.png");
        fruit = ImageLoader.loadImage("/tutorial1/images/manzana.png");
        start = ImageLoader.loadImage("/tutorial1/images/Inicio.png");
        help = ImageLoader.loadImage("/tutorial1/images/Ayuda.png");
        info = ImageLoader.loadImage("/tutorial1/images/Info.png");
        back = ImageLoader.loadImage("/tutorial1/images/Back.png");
        menu = ImageLoader.loadImage("/tutorial1/images/Menu.png");
        save = ImageLoader.loadImage("/tutorial1/images/Save.png");
        pauseN1 = ImageLoader.loadImage("/tutorial1/images/Pausa_N1.png");
        rev1 = ImageLoader.loadImage("/tutorial1/images/Rev_ag.png");
        info1 = ImageLoader.loadImage("/tutorial1/images/Info_N1.png");
        control1 = ImageLoader.loadImage("/tutorial1/images/Controles_N1.png");
        next = ImageLoader.loadImage("/tutorial1/images/Next.png");
        spritesR = ImageLoader.loadImage("/tutorial1/images/Player1R.png");
        spritesL = ImageLoader.loadImage("/tutorial1/images/Player1L.png");
        SpriteSheet spritesheet = new SpriteSheet(spritesR);
        SpriteSheet spritesheetL = new SpriteSheet(spritesL);
        SpriteSheet spritesheetN = new SpriteSheet(next);
        playerRight = new BufferedImage[3];
        playerLeft = new BufferedImage[3];
        nextA = new BufferedImage[2];
        //croping the pictures from the sheet int the array
        for (int i = 0; i < 3; i++){
            playerRight[i] = spritesheet.crop(i * 198, 0, 187, 299);
            playerLeft[i] = spritesheetL.crop(i * 198, 0, 187, 299);
        }
        //croping the pictures from the sheet int the array
        for (int i = 0; i < 2; i++){
            nextA[i] = spritesheetN.crop(i * 331, 0, 331, 34);
        }
        eat = new SoundClip("/tutorial1/sounds/eat.wav",-3f,false);   
        
        //sprites for third level
        cornFirst = ImageLoader.loadImage("/tutorial1/images/corn3L.png");
        cornSecond = ImageLoader.loadImage("/tutorial1/images/corn2L.png");
        cornThird = ImageLoader.loadImage("/tutorial1/images/corn1L.png");
        
        control3 = ImageLoader.loadImage("/tutorial1/images/Controles_N3.png");
        info3 = ImageLoader.loadImage("/tutorial1/images/Info_N3.png");
        pauseN3 = ImageLoader.loadImage("/tutorial1/images/Pausa_N3.png");
        
        pepperFirst = ImageLoader.loadImage("/tutorial1/images/pepper3L.png");
        pepperSecond = ImageLoader.loadImage("/tutorial1/images/pepper2L.png");
        pepperThird = ImageLoader.loadImage("/tutorial1/images/pepper1L.png");
        
        tomatoFirst = ImageLoader.loadImage("/tutorial1/images/tomato3L.png");
        tomatoSecond = ImageLoader.loadImage("/tutorial1/images/tomato2L.png");
        tomatoThird = ImageLoader.loadImage("/tutorial1/images/tomato1L.png");

        water = ImageLoader.loadImage("/tutorial1/images/water.png");
        playerLevel3 = ImageLoader.loadImage("/tutorial1/images/can.png");
        
    }
}
