import javax.swing.JButton;
import javax.swing.JPanel;
//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements Runnable, ActionListener {

    protected static int WIDTH = 1200;
    protected static int HEIGHT = 600;
    protected static int UNIT_SIZE = 20;

    private final int TIME = 30;
    private boolean running = false;
    Graphics g;

    private Graph image = new Graph();
    private CannonTarget target;
    private int x; // x-axis of ball
    private int y; // y-axis of ball
    private boolean click = false;

    NewSlider angleSlider;
    NewSlider powerSlider;

    GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFocusable(true);

        JButton fire = new JButton("FIRE");
        JButton restart = new JButton("RESTART");
        angleSlider = new NewSlider("Angle");
        //angleSlider.addChangeListener(this);
        powerSlider = new NewSlider("Power");
        //powerSlider.addChangeListener(this);

        //add(fire);
        //add(restart);
        //add(angleSlider);
        //add(angleSlider.label);
        //add(powerSlider);
        //add(powerSlider.label);
        fire.addActionListener(this);
        restart.addActionListener(this);
        fire.setBounds(130, 230, 80, 30);
        restart.setBounds(990, 80, 120, 30);
        
        add(fire);//
        add(restart);//
        add(angleSlider);//
        add(angleSlider.label);//
        add(powerSlider);//
        add(powerSlider.label);//
        startGame();
    }

    public void startGame() {
        running = true;
        newTarget();
    }

    // ----------------- TARGET -----------------//

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTarget(g);
    }

    public void newTarget() {
        this.target = new CannonTarget();
    }

    public void drawTarget(Graphics g) {
        g.setColor(Color.BLUE);
        // centered at getx() and gety()
        g.fillOval(this.target.getX() - UNIT_SIZE / 2, this.target.getY() - UNIT_SIZE / 2, UNIT_SIZE, UNIT_SIZE);
    }

    // ----------------- SLIDERS -----------------//

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "FIRE":
                this.click = true;
                this.x = image.ballStartPos(angleSlider.getValue())[0];
                this.y = image.ballStartPos(angleSlider.getValue())[1];
                break;
            case "RESTART":
                this.click = false;
                this.x = 0;
                this.y = 0;
                this.startGame();
                break;
        }

    }
/*
    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == angleSlider) {
            angleSlider.label.setText("angle: " + angleSlider.getValue());
        }
        if (e.getSource() == powerSlider) {
            powerSlider.label.setText("power: " + powerSlider.getValue());
        }
    }
*/
    // ----------------- RUN THE GAME -----------------//
    public void paint(Graphics g) {
        super.paint(g);
        image.drawGraph(g, angleSlider.getValue(), this.x, this.y, this.target.getX(), this.target.getY(), this.click);
        this.g = g;
    }

    public void run() {
        while (running) {
            if (this.click == true) {
                this.x = this.x + (int) (powerSlider.getValue() * Math.cos(angleSlider.getValue() * Math.PI / 180));
                // delta_x = velocity_x * delta_t
                this.y = this.y - (int) ((powerSlider.getValue() * Math.sin(angleSlider.getValue() * Math.PI / 180)
                        - 0.5 * 9.8));
                // delta_y = (velocity_y + delta_velocity_y) * delta_t
            }

            if (this.x > WIDTH || this.y > HEIGHT) {
                this.click = false;
                // pop dialog to restart
            }
            if (Math.abs(this.x - this.target.getX()) < 20 && Math.abs(this.y - this.target.getY()) < 20) {
                // when the ball in the boom range, make it static and show the boomed
                //this.x = this.target.getX();
                //this.y = this.target.getY();
                this.click = false;
            }

            try {
                Thread.sleep(TIME);
            } catch (Exception e) {
            }
            ;
            repaint();
        }
    }

}