import java.util.Random;
import javax.swing.JPanel;
import CannonShoot.GamePanel;

public class Target {
    
    private int x;
    private int y;

    Target() {
        Random random = new Random();
        this.x = random.nextInt(GamePanel.WIDTH / 2);
        this.y = random.nextInt(GamePanel.HEIGHT);
    }
}
