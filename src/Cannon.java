import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Cannon {
    private double angle;
    private static final int WIDTH = 20; // cannon's width
    private static final int LENGTH = 80; // cannon's length
    private static final int X = 120; // x-axis of left-lower corner of the connon
    private static final int Y = 520; // y-axis of left-lower corner of the connon
    protected int[] xAxis = { X, X + LENGTH, X + LENGTH, X };
    protected int[] yAxis = { Y, Y, Y - WIDTH, Y - WIDTH };

    public Cannon(double angle) {
        this.angle = angle * Math.PI / 180; // convert from degree to radians
        // the slider is 0 - 90 degrees, and to change in radians it is larger than 90
        // degrees
    }

    private void rotate() {
        // rotate the cannon around left-lower corner of cannon

        // four corners of cannon, left-down 0, right-down 1, left-upper 2 , right
        // uppper 3

        this.xAxis[1] = (int) (X + LENGTH * Math.cos(this.angle));
        this.yAxis[1] = (int) (Y - LENGTH * Math.sin(this.angle));
        this.xAxis[2] = (int) (X + LENGTH * Math.cos(this.angle) - WIDTH * Math.sin(this.angle));
        this.yAxis[2] = (int) (Y - LENGTH * Math.sin(this.angle) - WIDTH * Math.cos(this.angle));
        this.xAxis[3] = (int) (X - WIDTH * Math.sin(this.angle));
        this.yAxis[3] = (int) (Y - WIDTH * Math.cos(this.angle));
    }

    // cannon end position is the place where ball starts, right-upper corner
    protected int[] cannonEnd() {
        this.rotate();
        int[] endPosition = { this.xAxis[2], this.yAxis[2] };
        return endPosition;
    }

    protected Graphics drawCannon(Graphics g) {
        this.rotate();
        g.setColor(Color.BLACK);
        Polygon poly = new Polygon(this.xAxis, this.yAxis, 4);
        g.fillPolygon(poly);
        // Wheel
        /*
         * To draw a circle centered at x, y:
         * x = x-(r/2);
         * y = y-(r/2);
         * g.fillOval(x,y,r,r);
         */

        int[] bodyX = { X + 30, X + 30, X - 90, X - 90 };
        int[] bodyY = { Y, Y + 50, Y + 50, Y };
        g.setColor(Color.BLACK);
        g.fillPolygon(bodyX, bodyY, 4);
        g.setColor(Color.GRAY);
        g.fillOval(X - 20, Y + 29, 40, 40);
        g.setColor(Color.GRAY);
        g.fillOval(X - 80, Y + 29, 40, 40);
        g.setColor(Color.RED);
        g.fillOval(X - 10, Y + 39, 20, 20);
        g.setColor(Color.RED);
        g.fillOval(X - 70, Y + 39, 20, 20);
        g.setColor(Color.BLACK);
        g.fillRoundRect(X - 60, Y - 35, 60, 40, 15, 15);
        return g;
    }

}