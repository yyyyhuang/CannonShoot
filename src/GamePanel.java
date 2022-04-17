package CannonShoot;

import java.lang.annotation.Target;
import javax.swing.GrayFilter;
import javax.swing.JPanel;



public class GamePanel extends JPanel implements Runnable, MouseListener, MouseMotionListener{
    //yes
    public static int WIDTH = 1200;
	public static int HEIGHT = 600;
    public static int UNIT_SIZE = 25; // maybe this is ball size

    private boolean running;

    private Target target = new Target();
    private Cannon cannon = new Cannon();
    private SliderInput angleSlider = new SliderInput(50, 155, 157, 0, "Angle");
    private SliderInput powerSlider = new SliderInput(50, 295, 150, 0, "Power");


	GamePanel() {
        // optiton: super();
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFocusable(true);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void startGame() {
        running = true;

        newTarget();
        // timer????
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        // **********   fill target color - should be in Cannon.java ***********
        g.fillOval(this.target.getX(), this.target.getY(), UNIT_SIZE, UNIT_SIZE);
    }

    public void newTarget() {
        this.target = new Target();
    }
}
