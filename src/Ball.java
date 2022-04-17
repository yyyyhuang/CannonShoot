package CannonShoot;


public class Ball {
    private int x;
    private int y;
    static int DIAMETER = 25;

    private int speedX;
    private int speedY;

    private double velocity;

    public Ball(int x, int y, int speedX, int speedY){
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public int getX() {return x;}
	public int getY() {return y;}
	public int getDiameter() {return diameter;}

    // NOT SURE IF NEEDED
    public void update() {

    }
}
