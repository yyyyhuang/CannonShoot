import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.io.InputStream;
import javax.sound.sampled.*;

public class GamePanel extends JPanel implements Runnable, ActionListener {

    protected static int WIDTH = 1200;
    protected static int HEIGHT = 600;
    protected static int UNIT_SIZE = 20;

    private final int TIME = 35;
    private boolean running = false;
    Graphics g;

    private Graph image = new Graph();
    private CannonTarget target;
    private int x; // x-axis of ball
    private int y; // y-axis of ball
    private double gravityTime = 0;
    private boolean click = false;
    private double flicker = 3;
    Clip bgm;
    Clip throwSound;
    Clip boom;
    boolean playBoom = false;

    NewSlider angleSlider;
    NewSlider powerSlider;

    private BufferedImage pang;
    // private BufferedImage bgImage;

    GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFocusable(true);
        this.setBackground(new Color(230, 255, 255));

        JButton fire = new JButton("FIRE");
        JButton restart = new JButton("RESTART");
        angleSlider = new NewSlider("Angle", 0, 90, 45, 20);
        powerSlider = new NewSlider("Power", 15, 30, 22, 5);

        fire.addActionListener(this);
        restart.addActionListener(this);

        try {
            pang = ImageIO.read(new File("Picture4.jpg"));
        } catch (IOException e) {}

        add(fire);
        add(restart);
        add(angleSlider);
        add(angleSlider.label);
        add(powerSlider);
        add(powerSlider.label);

        try {
            bgm = AudioSystem.getClip();
            InputStream isBGM = this.getClass().getClassLoader().getResourceAsStream("kongfu.wav");
            AudioInputStream aisBGM = AudioSystem.getAudioInputStream(isBGM);
            bgm.open(aisBGM);
            bgm.start();
            bgm.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            System.out.println("Sound Error " + e);
            e.printStackTrace();
        }

        startGame();
    }

    public void startGame() {
        running = true;
        newTarget();
        this.angleSlider.setEnabled(true);
        this.powerSlider.setEnabled(true);
    }

    // ----------------- TARGET -----------------//

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // g.drawImage(bgImage, 0, 0, null);
        drawTarget(g);
    }

    public void newTarget() {
        this.target = new CannonTarget();
    }

    public void drawTarget(Graphics g) {

        // x, y is the position of left-upper corner of this image
        // adjust the coordinate to make the graph centered at getx() and gety()
        g.drawImage(pang, this.target.getX() - 30, this.target.getY() - 30, 60, 60, this);
        // g.setColor(Color.BLACK);
        // g.fillOval(this.target.getX() - UNIT_SIZE / 2, this.target.getY() - UNIT_SIZE
        // / 2, UNIT_SIZE, UNIT_SIZE);
    }

    // ----------------- BUTTONS -----------------//

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "FIRE":
                this.click = true;
                this.x = image.ballStartPos(angleSlider.getValue())[0];
                this.y = image.ballStartPos(angleSlider.getValue())[1];
                this.gravityTime = 0;
                bgm.stop();

                try {
                    throwSound = AudioSystem.getClip();
                    InputStream isThrow = this.getClass().getClassLoader().getResourceAsStream("throwSound.wav");
                    AudioInputStream aisThrow = AudioSystem.getAudioInputStream(isThrow);
                    throwSound.open(aisThrow);
                    throwSound.start();
                } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
                    e1.printStackTrace();
                }
                break;
            case "RESTART":
                this.click = false;
                this.x = 0;
                this.y = 0;
                this.gravityTime = 0;
                this.startGame();
                bgm.start();
                this.playBoom = false;
                boom.stop();

                break;
        }

    }

    // ----------------- RUN THE GAME -----------------//
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(28, 232, 119));
        g.fillRect(0, HEIGHT - 50, WIDTH, 50);
        image.drawGraph(g, angleSlider.getValue(), this.x, this.y, this.target.getX(), this.target.getY(), this.click,
                this.flicker);
        this.g = g;
    }

    public void run() {
        while (running) {
            if (this.click == true) {
                this.gravityTime = this.gravityTime + 0.1;
                this.x = this.x + (int) (powerSlider.getValue() * Math.cos(angleSlider.getValue() * Math.PI / 180));
                // delta_x = velocity_x * delta_t
                this.y = this.y - (int) ((powerSlider.getValue() * Math.sin(angleSlider.getValue() * Math.PI / 180)
                        - 0.5 * 9.8 * this.gravityTime));
                // delta_y = (velocity_y + delta_velocity_y * delta_t) * delta_t
                this.angleSlider.setEnabled(false);
                this.powerSlider.setEnabled(false);
            }

            if (this.x > WIDTH || this.y > HEIGHT) {
                this.click = false;
                this.angleSlider.setEnabled(true);
                this.powerSlider.setEnabled(true);
                throwSound.stop();
                bgm.start();
            }
            // since the image is not perfect circle, we take off 7 from radius for
            // adjustment
            if (Math.abs(this.x - this.target.getX()) < 40 && Math.abs(this.y - this.target.getY()) < 40) {
                // when the ball in the boom range, make it static and show the boomed
                if (this.flicker > 1) {
                    this.flicker = this.flicker - 0.1;
                }
                this.click = false;
                if (this.playBoom == false) {
                    this.playBoom = true;
                    this.throwSound.stop();
                    try {
                        boom = AudioSystem.getClip();
                        InputStream isBoom = this.getClass().getClassLoader().getResourceAsStream("boom4.wav");
                        AudioInputStream aisBoom = AudioSystem.getAudioInputStream(isBoom);
                        boom.open(aisBoom);
                        boom.start();
                    } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            try {
                Thread.sleep(TIME);
            } catch (Exception e) {
            }

            repaint();
        }
    }

}
