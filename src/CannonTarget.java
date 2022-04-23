import java.util.Random;

public class CannonTarget {

    private int x;
    private int y;

    CannonTarget() {
        Random random = new Random();
        this.x = random.nextInt(GamePanel.WIDTH / 2, GamePanel.WIDTH);
        this.y = random.nextInt(150, GamePanel.HEIGHT - 80);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}