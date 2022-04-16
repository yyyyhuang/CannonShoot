package CannonShoot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Cannon {
    private int angle;
	private int size;
	private int power;
    private int diameter = 100;
	private int width = 300;
	
	private int x = 200;
	// private int y = GamePanel.HEIGHT - diameter - 50;
    private int y = 50;

public Cannon() {
}

public Graphics2D draw(Graphics2D g, int angle, int size, int power) {
		
    this.angle = angle;
    this.size = size;
    this.power = power;

    
    //g = drawBalls(g);
    g = drawCannon(g);
    //g = drawButtons(g);
    //g = drawColorSelection(g);
    
    return g;
    
    
}

private Graphics2D drawCannon(Graphics2D g) {
	
    diameter = size + 50;
    
    //-------- Turn Cannon ----------//
    int xPoly[] = {x, x + width, x + width, x}; 
    // four corners of cannon, left-down, right-down, right uppper, left-upper
    int yPoly[] = {y, y, y + diameter,y + diameter};
    
    int i;
    for (i = 0; i < xPoly.length; i++){
        int newXY[] = rotateXY(xPoly[i], yPoly[i], angle, x, y + diameter);
        xPoly[i] = newXY[0];
        yPoly[i] = newXY[1];
    }
    for (i = 0; i < xPoly.length; i++){
        yPoly[i] = yPoly[i] + y + 100 - yPoly[3]; //keeps it fixed to the corner
    }
    
    /*
    // Where the ball will be spawning
    ballX = xPoly[1];
    ballY = yPoly[1];
    ballX += xPoly[2] - xPoly[1] - diameter - 2;
    */
    //Cannon
    g.setColor(Color.BLACK);
    Polygon poly = new Polygon(xPoly, yPoly, xPoly.length);
    g.fillPolygon(poly);
    //Wheel
    g.setColor(new Color(139,69,19));
    g.fillOval(300, 500, 100, 100);
    
    return g;
}

}