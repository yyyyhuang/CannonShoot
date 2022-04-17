
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Cannon {
    private double angle;
	private int size;
	private int power;
    private int cannonWidth = 100;
	private int cannonLength = 300;
	
	private int x = 200;
	// private int y = GamePanel.HEIGHT - diameter - 50;
    private int y = 50;

public Cannon() {}

// draw a graph, not only draw the cannon
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
    // initially set the cannon laid horizontally where its left corners has the same heititude as corresponding right corners
    int[] xAxis = {this.x, this.x + cannonLength, this.x, this.x + cannonLength};
    // four corners of cannon, left-down 0, right-down 1, left-upper 2 , right uppper 3
    int[] yAxis = {this.y, this.y, this.y + cannonWidth, this.y + cannonWidth};
    // Turn cannon with degree of angle
    for(int i = 1; i < 4; i++){
        xAxis[i] = rotateX(xAxis[i], yAxis[i], this.angle);
        yAxis[i] = rotateY(xAxis[i], yAxis[i], this.angle);
    }

    g.setColor(Color.BLACK);
    Polygon poly = new Polygon(xAxis, yAxis, 4);
    g.fillPolygon(poly);
    //Wheel
    g.setColor(new Color(139,69,19));
    g.fillOval(300, 500, 100, 100);
    
    return g;
}

private int rotateX(int xPos, double yPos, double angle){
    // allow the cannon to rotate around left-lower-corner
    double rotatedX = (xPos - this.x)*Math.cos(angle / 100) - (yPos - y)*Math.sin(angle/100);
    int newX =(int) (this.x + rotatedX);
    return newX;
}
private int rotateY(double xPos, double yPos, double angle){
    double rotatedY = (xPos - this.x)*Math.sin(angle / 100) + (yPos - this.y)*Math.cos(angle/100);
    int newY =(int) (this.y + rotatedY);
    return newY;
}
}