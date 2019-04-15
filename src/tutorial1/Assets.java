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
    //menu assets
    public static BufferedImage background;
    public static BufferedImage start;
    public static BufferedImage help;
    public static BufferedImage info;
    public static BufferedImage back;
    //level one assets
    public static BufferedImage backgroundLevel1;
    public static BufferedImage playerLevel1;
    public static BufferedImage fruit;
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
    public static SoundClip natural;
    //Level 4 assets
    public static BufferedImage arrow;

    
    
    
    public static void init(){
        background = ImageLoader.loadImage("/tutorial1/images/Background.png");
        backgroundLevel1 = ImageLoader.loadImage("/tutorial1/images/BkLvl1.jpeg");
        playerLevel1 = ImageLoader.loadImage("/tutorial1/images/monito.png");
        fruit = ImageLoader.loadImage("/tutorial1/images/manzana.png");
        start = ImageLoader.loadImage("/tutorial1/images/Inicio.png");
        help = ImageLoader.loadImage("/tutorial1/images/Ayuda.png");
        info = ImageLoader.loadImage("/tutorial1/images/Info.png");
        back = ImageLoader.loadImage("/tutorial1/images/Back.png");

        eat = new SoundClip("/tutorial1/sounds/eat.wav",-3f,false); 
//        natural = new SoundClip("/tutorial1/sounds/natural.wav",-3f,true);

        arrow = ImageLoader.loadImage("/tutorial1/images/arrow.png");
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
    }
}
