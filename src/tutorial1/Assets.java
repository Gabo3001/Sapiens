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
    public static BufferedImage fin;
    public static BufferedImage start;
    public static BufferedImage help;
    public static BufferedImage info;
    public static BufferedImage back;

    //level one assets
    public static BufferedImage backgroundLevel1;
    public static BufferedImage playerLevel1;
    public static BufferedImage fruit;
    public static BufferedImage black;
    public static BufferedImage menu;
    public static BufferedImage login;
    public static BufferedImage pregunta;
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
    public static SoundClip natural;

    //Level 2
    public static BufferedImage info2;
    public static BufferedImage control2;
    public static BufferedImage pauseN2;
    public static BufferedImage laser;
    public static BufferedImage mamut;
    public static BufferedImage AlienImages[];
    public static BufferedImage alienSprites;
    public static BufferedImage backgroundN2;
    public static BufferedImage fire;
    public static BufferedImage MamutImages[];
    public static BufferedImage hogRight[];
    public static BufferedImage hogLeft[];
    public static BufferedImage hogBlackRight[];
    public static BufferedImage hogBlackLeft[];
    public static BufferedImage hogWhiteRight[];
    public static BufferedImage hogWhiteLeft[];
    public static BufferedImage hogSprites;
    public static BufferedImage hogSpritesB;
    public static BufferedImage hogSpritesN;
    public static SoundClip jabalia;
    public static BufferedImage bkGndN2;
    public static BufferedImage spritesR2;
    public static BufferedImage playerRight2[];
    public static BufferedImage playerLevel2;

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

    //Level 4 assets
    public static BufferedImage arrow;
    public static BufferedImage coin;
    public static BufferedImage bkmirror;
    public static BufferedImage knight;
    public static BufferedImage prog1;
    public static BufferedImage prog2;
    public static BufferedImage prog3;
    public static BufferedImage prog4;
    public static BufferedImage prog5;
    public static BufferedImage prog6;
    public static BufferedImage prog7;
    public static SoundClip target;
    public static SoundClip cash;
    public static BufferedImage info4;
    public static BufferedImage control4;
    public static BufferedImage pauseN4;
    public static BufferedImage spritesR4;
    public static BufferedImage playerRight4[];

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

    //Level 6 Assets
    public static BufferedImage city1;
    public static BufferedImage city2;
    public static BufferedImage city3;
    public static BufferedImage city4;
    public static BufferedImage city5;
    public static BufferedImage city6;
    public static BufferedImage city7;
    public static BufferedImage city8;
    public static BufferedImage yellowB;
    public static BufferedImage purpleB;
    public static BufferedImage blueB;
    public static BufferedImage a;
    public static BufferedImage s;
    public static BufferedImage d;
    public static SoundClip cristal;
    public static SoundClip crash;
    public static BufferedImage info6;
    public static BufferedImage control6;
    public static BufferedImage pauseN6;

    public static void init() {
        //Assets Menu

        background = ImageLoader.loadImage("/tutorial1/images/Background.png");
        fin = ImageLoader.loadImage("/tutorial1/images/fin.png");
        backgroundLevel1 = ImageLoader.loadImage("/tutorial1/images/BkLvl1.jpeg");
        backgroundN2 = ImageLoader.loadImage("/tutorial1/images/back1 2.png");
        backgroundLevel3 = ImageLoader.loadImage("/tutorial1/images/bkLvl3.jpg");
        playerLevel1 = ImageLoader.loadImage("/tutorial1/images/monito.png");
        fruit = ImageLoader.loadImage("/tutorial1/images/manzana.png");
        start = ImageLoader.loadImage("/tutorial1/images/Inicio.png");
        help = ImageLoader.loadImage("/tutorial1/images/Ayuda.png");
        login = ImageLoader.loadImage("/tutorial1/images/login.png");
        pregunta = ImageLoader.loadImage("/tutorial1/images/pregunta.png");
        info = ImageLoader.loadImage("/tutorial1/images/Info.png");
        back = ImageLoader.loadImage("/tutorial1/images/Back.png");

        //level 4 assets
        bkmirror = ImageLoader.loadImage("/tutorial1/images/BkLvl1_mirror.jpg");
        eat = new SoundClip("/tutorial1/sounds/eat.wav", -3f, false);
        cash = new SoundClip("/tutorial1/sounds/coin.wav", -3f, false);
        target = new SoundClip("/tutorial1/sounds/arrow.wav", -3f, false);
        coin = ImageLoader.loadImage("/tutorial1/images/coin.png");
        arrow = ImageLoader.loadImage("/tutorial1/images/arrow.png");
        prog1 = ImageLoader.loadImage("/tutorial1/images/prog1.png");
        prog2 = ImageLoader.loadImage("/tutorial1/images/prog2.png");
        prog3 = ImageLoader.loadImage("/tutorial1/images/prog3.png");
        prog4 = ImageLoader.loadImage("/tutorial1/images/prog4.png");
        prog5 = ImageLoader.loadImage("/tutorial1/images/prog5.png");
        prog6 = ImageLoader.loadImage("/tutorial1/images/prog6.png");
        prog7 = ImageLoader.loadImage("/tutorial1/images/prog7.png");
        control4 = ImageLoader.loadImage("/tutorial1/images/Controles_N4.png");
        info4 = ImageLoader.loadImage("/tutorial1/images/Info_N4.png");
        pauseN4 = ImageLoader.loadImage("/tutorial1/images/Pausa_N4.png");
        spritesR4 = ImageLoader.loadImage("/tutorial1/images/Player4L.png");
        SpriteSheet spritesheet4 = new SpriteSheet(spritesR4);
        playerRight4 = new BufferedImage[3];
        //croping the pictures from the sheet int the array
        for (int i = 0; i < 3; i++) {
            playerRight4[i] = spritesheet4.crop(i * 198, 0, 187, 298);
        }
        

        //Assets level 1
        menu = ImageLoader.loadImage("/tutorial1/images/Menu.png");
        save = ImageLoader.loadImage("/tutorial1/images/Save.png");
        pauseN1 = ImageLoader.loadImage("/tutorial1/images/Pausa_N1.png");
        rev1 = ImageLoader.loadImage("/tutorial1/images/Rev_ag.png");
        black = ImageLoader.loadImage("/tutorial1/images/black.png");
        rev2 = ImageLoader.loadImage("/tutorial1/images/Rev_cog.png");
        
        info1 = ImageLoader.loadImage("/tutorial1/images/Info_N1.png");
        control1 = ImageLoader.loadImage("/tutorial1/images/Controles_N1.png");
        next = ImageLoader.loadImage("/tutorial1/images/Next.png");
        knight = ImageLoader.loadImage("/tutorial1/images/knight.png");
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

        //Assets level 2
        info2 = ImageLoader.loadImage("/tutorial1/images/info_N2.png");
        control2 = ImageLoader.loadImage("/tutorial1/images/controles_N2.png");
        pauseN2 = ImageLoader.loadImage("/tutorial1/images/Pausa_N2.png");
        laser = ImageLoader.loadImage("/tutorial1/images/spear.png");
        hogSprites = ImageLoader.loadImage("/tutorial1/images/jabali.png");
        hogSpritesB = ImageLoader.loadImage("/tutorial1/images/MamutB.PNG");
        hogSpritesN = ImageLoader.loadImage("/tutorial1/images/MamutN.png");
        bkGndN2 = ImageLoader.loadImage("/tutorial1/images/BkLvl2jpg.jpg");
        jabalia = new SoundClip("/tutorial1/sounds/jabalia.wav", -3f, false);

        SpriteSheet hogSpriteSheet = new SpriteSheet(hogSprites);
        hogLeft = new BufferedImage[3];
        hogRight = new BufferedImage[3];
        for (int k = 0; k < 3; k++) {
            hogLeft[k] = hogSpriteSheet.crop(0 + 46 * k, 0, 48, 32);
        }
        for (int k = 0; k < 3; k++) {
            hogRight[k] = hogSpriteSheet.crop(0 + 46 * k, 48, 48, 32);
        }

        SpriteSheet hogSpriteSheetN = new SpriteSheet(hogSpritesN);
        hogBlackLeft = new BufferedImage[3];
        hogBlackRight = new BufferedImage[3];
        for (int k = 0; k < 3; k++) {
            hogBlackLeft[k] = hogSpriteSheetN.crop(0 + 46 * k, 0, 48, 31);
        }
        for (int k = 0; k < 3; k++) {
            hogBlackRight[k] = hogSpriteSheetN.crop(0 + 48 * k, 45, 45, 31);
        }

        SpriteSheet hogSpriteSheetB = new SpriteSheet(hogSpritesB);
        hogWhiteLeft = new BufferedImage[3];
        hogWhiteRight = new BufferedImage[3];
        for (int k = 0; k < 3; k++) {
            hogWhiteLeft[k] = hogSpriteSheetB.crop(0 + 47 * k, 0, 46, 31);
        }
        for (int k = 0; k < 3; k++) {
            hogWhiteRight[k] = hogSpriteSheetB.crop(0 + 48 * k, 46, 46, 33);
        }
        playerLevel2 = ImageLoader.loadImage("/tutorial1/images/Player2.png");
        spritesR2 = ImageLoader.loadImage("/tutorial1/images/Player2L.png");
        SpriteSheet spritesheet2 = new SpriteSheet(spritesR2);
        playerRight2 = new BufferedImage[3];
        //croping the pictures from the sheet int the array
        for (int i = 0; i < 3; i++) {
            playerRight2[i] = spritesheet2.crop(i * 198, 0, 187, 299);
        }

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

        for (int i = 0; i < 2; i++) {
            nextA[i] = spritesheetN.crop(i * 331, 0, 331, 34);
        }
        eat = new SoundClip("/tutorial1/sounds/eat.wav", -3f, false);

        //level 3 assets
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
        //Level 6 Assets
        city1 = ImageLoader.loadImage("/tutorial1/images/pixelCity0.png");
        city2 = ImageLoader.loadImage("/tutorial1/images/pixelCity1.png");
        city3 = ImageLoader.loadImage("/tutorial1/images/pixelCity2.png");
        city4 = ImageLoader.loadImage("/tutorial1/images/pixelCity3.png");
        city5 = ImageLoader.loadImage("/tutorial1/images/pixelCity4.png");
        city6 = ImageLoader.loadImage("/tutorial1/images/pixelCity5.png");
        city7 = ImageLoader.loadImage("/tutorial1/images/pixelCity6.png");
        city8 = ImageLoader.loadImage("/tutorial1/images/pixelCity7.png");
        yellowB = ImageLoader.loadImage("/tutorial1/images/YellowB.png");
        purpleB = ImageLoader.loadImage("/tutorial1/images/PurpleB.png");
        blueB = ImageLoader.loadImage("/tutorial1/images/BlueB.png");
        a = ImageLoader.loadImage("/tutorial1/images/A.png");
        s = ImageLoader.loadImage("/tutorial1/images/S.png");
        d = ImageLoader.loadImage("/tutorial1/images/D.png");
        control6 = ImageLoader.loadImage("/tutorial1/images/Controles_N6.png");
        info6 = ImageLoader.loadImage("/tutorial1/images/Info_N6.png");
        pauseN6 = ImageLoader.loadImage("/tutorial1/images/Pausa_N6.png");
        cristal = new SoundClip("/tutorial1/sounds/Crystal-02.wav", -3f, false);
        crash = new SoundClip("/tutorial1/sounds/crash.wav", -3f, false);
    }

}
