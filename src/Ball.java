
// draw balls
import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Ball {
    BufferedImage q;
    public Ball() {
        try {
            q = ImageIO.read(new File("pokeball.png"));
        }
        catch (IOException e){System.out.println("error in ball");}
    }

    public void drawBall(Graphics g, int x, int y) {
        g.drawImage(q, x - 20, y - 20, 40, 40,  null);
    }
}
