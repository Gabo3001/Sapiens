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
    }
    
    
    
}
