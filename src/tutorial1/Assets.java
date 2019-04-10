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
    public static BufferedImage spritesR;
    public static BufferedImage spritesL;
    public static BufferedImage playerRight[];
    public static BufferedImage playerLeft[];
    public static SoundClip eat;
    
    public static void init(){
        background = ImageLoader.loadImage("/tutorial1/images/Background.png");
        backgroundLevel1 = ImageLoader.loadImage("/tutorial1/images/BkLvl1.jpeg");
        playerLevel1 = ImageLoader.loadImage("/tutorial1/images/monito.png");
        fruit = ImageLoader.loadImage("/tutorial1/images/manzana.png");
        start = ImageLoader.loadImage("/tutorial1/images/Inicio.png");
        help = ImageLoader.loadImage("/tutorial1/images/Ayuda.png");
        info = ImageLoader.loadImage("/tutorial1/images/Info.png");
        back = ImageLoader.loadImage("/tutorial1/images/Back.png");
        spritesR = ImageLoader.loadImage("/tutorial1/images/Player1R.png");
        spritesL = ImageLoader.loadImage("/tutorial1/images/Player1L.png");
        SpriteSheet spritesheet = new SpriteSheet(spritesR);
        SpriteSheet spritesheetL = new SpriteSheet(spritesL);
        playerRight = new BufferedImage[3];
        playerLeft = new BufferedImage[3];
        //croping the pictures from the sheet int the array
        for (int i = 0; i < 3; i++){
            playerRight[i] = spritesheet.crop(i * 198, 0, 187, 299);
            playerLeft[i] = spritesheetL.crop(i * 198, 0, 187, 299);
        }
        eat = new SoundClip("/tutorial1/sounds/eat.wav",-3f,false);    
    }
}
