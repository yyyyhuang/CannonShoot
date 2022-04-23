
// graph
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

public class Graph extends JPanel {
    public Graph() {
    }

    public Graphics drawGraph(Graphics g, int angle, int x, int y, int tX, int tY, boolean fire) {

        Cannon cannon = new Cannon(angle);
        cannon.drawCannon(g);
        Ball ball = new Ball();
        if (fire == true) {
            
            ball.drawBall(g, x, y);
        }
        // diameter of ball is 20
        // center of the ball is (x - 10, y - 10)
        // center of the target is (tX - 10, tY - 10);
        // when both x and y axis distances are smaller than diameter, it means booms
        if (Math.abs(x - tX) < 20 && Math.abs(y - tY) < 20) {

            //g.setColor(Color.GREEN);
            //g.fillOval(tX - 20, tY - 20, 40, 40);
            ball.drawBall(g, x, y);
            this.drawBoom(g, tX-20, tY-20);

        }
        return g;
    }

    public int[] ballStartPos(double angle) {
        Cannon cannon = new Cannon(angle);
        return cannon.cannonEnd();
    }

    public void drawBoom(Graphics g, int centerX, int centerY){
        int[] starX = {42, 52, 72, 52, 60, 40, 15, 28, 9, 32, 42};
        int[] starY = {38, 62, 68, 80, 105, 85, 102, 75, 58, 60, 38};
        for(int i = 0; i< starX.length; i++){
            starX[i] =(int) (starX[i] / 3 +centerX);
            starY[i] =(int) (starY[i] / 3 +centerY);
        }
        g.setColor(Color.red);
        g.drawPolygon(starX, starY, starX.length);
    }
}