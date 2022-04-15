package CannorShoot;


public class Ball {
    private int x;
    private int y;
    private int diameter;

    private int speedX;
    private int speedY;

    private double velocity;

    public Ball(int x, int y, int diameter, int speedX, int speedY){
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public int getX() {return x;}
	public int getY() {return y;}
	public int getDiameter() {return diameter;}
}
