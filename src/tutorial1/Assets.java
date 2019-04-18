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
    public static BufferedImage rev2;
    public static BufferedImage info1;
    public static BufferedImage control1;
    public static BufferedImage next;
    public static BufferedImage nextA[];
    public static BufferedImage spritesR;
    public static BufferedImage spritesL;
    public static BufferedImage playerRight[];
    public static BufferedImage playerLeft[];
    public static SoundClip eat;
    //Level 4 assets
    public static BufferedImage arrow;
    //Level 5 assets
    public static BufferedImage backgroundLevel5;
    public static BufferedImage Gary;
    public static BufferedImage martillo;
    public static BufferedImage martilloBW;
    public static BufferedImage hacha;
    public static BufferedImage hachaBW;
    public static BufferedImage peine;
    public static BufferedImage peineBW;
    public static BufferedImage pala;
    public static BufferedImage palaBW;
    public static BufferedImage regla;
    public static BufferedImage reglaBW;
    public static BufferedImage sierra;
    public static BufferedImage sierraBW;
    public static BufferedImage telescopio;
    public static BufferedImage telescopioBW;
    public static BufferedImage tijera;
    public static BufferedImage tijeraBW;
    public static BufferedImage pauseN5;
    public static BufferedImage rev3;
    public static BufferedImage info5;
    public static BufferedImage control5;
    public static SoundClip blink;

    public static void init() {
        //Assets Menu
        background = ImageLoader.loadImage("/tutorial1/images/Background.png");
        backgroundLevel1 = ImageLoader.loadImage("/tutorial1/images/BkLvl1.jpeg");
        playerLevel1 = ImageLoader.loadImage("/tutorial1/images/monito.png");
        fruit = ImageLoader.loadImage("/tutorial1/images/manzana.png");
        start = ImageLoader.loadImage("/tutorial1/images/Inicio.png");
        help = ImageLoader.loadImage("/tutorial1/images/Ayuda.png");
        info = ImageLoader.loadImage("/tutorial1/images/Info.png");
        back = ImageLoader.loadImage("/tutorial1/images/Back.png");
        //Assets level 1
        menu = ImageLoader.loadImage("/tutorial1/images/Menu.png");
        save = ImageLoader.loadImage("/tutorial1/images/Save.png");
        pauseN1 = ImageLoader.loadImage("/tutorial1/images/Pausa_N1.png");
        rev1 = ImageLoader.loadImage("/tutorial1/images/Rev_ag.png");
        rev2 = ImageLoader.loadImage("/tutorial1/images/Rev_cog.png");
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
        for (int i = 0; i < 3; i++) {
            playerRight[i] = spritesheet.crop(i * 198, 0, 187, 299);
            playerLeft[i] = spritesheetL.crop(i * 198, 0, 187, 299);
        }
        //croping the pictures from the sheet int the array
        for (int i = 0; i < 2; i++) {
            nextA[i] = spritesheetN.crop(i * 331, 0, 331, 34);
        }
        eat = new SoundClip("/tutorial1/sounds/eat.wav", -3f, false);

        //Assets level 4
        arrow = ImageLoader.loadImage("/tutorial1/images/arrow.png");
        //Assets level 5
        backgroundLevel5 = ImageLoader.loadImage("/tutorial1/images/Background_N5.jpeg");
        Gary = ImageLoader.loadImage("/tutorial1/images/Gary.png");
        martillo = ImageLoader.loadImage("/tutorial1/images/Martillo.png");
        martilloBW = ImageLoader.loadImage("/tutorial1/images/MartilloBW.png");
        hacha = ImageLoader.loadImage("/tutorial1/images/Hacha.png");
        hachaBW = ImageLoader.loadImage("/tutorial1/images/HachaBW.png");
        peine = ImageLoader.loadImage("/tutorial1/images/Peile.png");
        peineBW = ImageLoader.loadImage("/tutorial1/images/PeileBW.png");
        pala = ImageLoader.loadImage("/tutorial1/images/Pala.png");
        palaBW = ImageLoader.loadImage("/tutorial1/images/PalaBW.png");
        regla = ImageLoader.loadImage("/tutorial1/images/Regla.png");
        reglaBW = ImageLoader.loadImage("/tutorial1/images/ReglaBW.png");
        sierra = ImageLoader.loadImage("/tutorial1/images/Sierra.png");
        sierraBW = ImageLoader.loadImage("/tutorial1/images/SierraBw.png");
        telescopio = ImageLoader.loadImage("/tutorial1/images/Telescopio.png");
        telescopioBW = ImageLoader.loadImage("/tutorial1/images/TelescopioBW.png");
        tijera = ImageLoader.loadImage("/tutorial1/images/Tijera.png");
        tijeraBW = ImageLoader.loadImage("/tutorial1/images/TijeraBW.png");
        pauseN5 = ImageLoader.loadImage("/tutorial1/images/Pausa_N5.png");
        rev3 = ImageLoader.loadImage("/tutorial1/images/Rev_ci.png");
        info5 = ImageLoader.loadImage("/tutorial1/images/Info_N5.png");
        control5 = ImageLoader.loadImage("/tutorial1/images/Controles_N5.png");
        blink = new SoundClip("/tutorial1/sounds/blink.wav", -3f, false);
}
}
