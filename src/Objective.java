import java.util.Random;
// import javax.swing.JPanel;
// import CannonShoot.GamePanel;

public class Objective {
    
    private int x;
    private int y;

    public Objective() {
        Random random = new Random();
        this.x = random.nextInt(GamePanel.WIDTH / 2);
        this.y = random.nextInt(GamePanel.HEIGHT);
    }

    public int getX(){return this.x;}
    public int getY(){return this.y;}
}
