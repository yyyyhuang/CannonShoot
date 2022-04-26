
// draw balls
import java.awt.Graphics;
import java.awt.Color;

public class Ball {
    private static final int DIAMETER = 20;

    public Ball() {
    }

    public void drawBall(Graphics g, int x, int y) {
        g.setColor(Color.orange);
        g.fillOval(x - DIAMETER / 2, y - DIAMETER / 2, DIAMETER, DIAMETER);
    }
}
