package CannorShoot;

import javax.swing.JFrame;

public class Game {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new GamePanel());
        window.pack(); // sizes the frame so that all its contents are at or above their preferred sizes
        window.setVisible(true);
        window.setResizable(false);
    }
}
