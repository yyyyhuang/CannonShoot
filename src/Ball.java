
// draw balls
import java.awt.Graphics;
import java.awt.Color;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Ball {
    private static final int DIAMETER = 20;
    BufferedImage q;
    public Ball() {
        try {
            q = ImageIO.read(new File("pokeball_PNG24.png"));
        }
        catch (IOException e){}
    }

    public void drawBall(Graphics g, int x, int y) {
        /*
        g.setColor(Color.orange);
        g.fillOval(x - DIAMETER / 2, y - DIAMETER / 2, DIAMETER, DIAMETER);
        */
        g.drawImage(q, x - 30, y - 30, 40, 40,  null);
    }
}
