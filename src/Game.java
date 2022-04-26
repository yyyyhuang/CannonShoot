import javax.swing.JFrame;

public class Game {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        GamePanel panel = new GamePanel();
        Thread t = new Thread(panel);
        t.start();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Cannon Shoot");
        frame.pack(); // sizes the frame so that all its contents are at or above their preferred
                      // sizes
        frame.setVisible(true);
        frame.setResizable(false);

    }
}