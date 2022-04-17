package CannonShoot;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JPanel p = new JPanel();
        p.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        // p.setLayout(new GridLayout(0, 1));
<<<<<<< HEAD
        JButton b = new JButton("restart");
        
=======
        JButton b = new JButton("click");
        Cannon c = new Cannon();
>>>>>>> 2716ac95f4170a8e06982ad26903e3b9418a44b5
        p.add(b);
        p.add(c);
        frame.add(p, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setContentPane(new GamePanel());
        frame.setTitle("Cannon Shoot");
        frame.pack(); // sizes the frame so that all its contents are at or above their preferred sizes
        frame.setVisible(true);
        frame.setResizable(false);


        
    }
}
