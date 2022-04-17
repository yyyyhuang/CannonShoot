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
        JButton b = new JButton("click");
        Cannon c = new Cannon();
        p.add(b);
        p.add(c);
        frame.add(p, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setContentPane(new GamePanel());
        frame.setTitle("Cannon Shoot");
        frame.pack(); // sizes the frame so that all its contents are at or above their preferred sizes
        frame.setVisible(true);
        frame.setResizable(true);


        
    }
}
