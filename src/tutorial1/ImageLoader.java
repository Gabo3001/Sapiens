/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial1;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author HOME
 */
public class ImageLoader {

    public static BufferedImage loadImage(String path) {
        BufferedImage bi = null;
        try {
            //bi = ImageIO.read(ImageLoader.class.getResource(path));
            //bi = ImageIO.read(Toolkit.getDefaultToolkit().getImage(getClass().getResource(path)));
            //bi = ImageIO.read(new URL(getClass().getResource(path)));
            InputStream resource = ImageLoader.class.getResourceAsStream(path);
            bi = ImageIO.read(resource);

        } catch (IOException ioe) {
            System.out.println("Error loading image" + path + ioe.toString());
            System.exit(1);
        }
        return bi;
    }
}
