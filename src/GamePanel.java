import java.util.Timer;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GamePanel extends JPanel implements AncestorListener {
    
    public static int WIDTH = 1200;
	public static int HEIGHT = 600;
    public static int UNIT_SIZE = 25; // maybe this is ball size

    public final int DELAY = 75; // ?????

    private boolean running = false;

    private CannonTarget target;
    Timer timer;
    // private Cannon cannon = new Cannon();
    // private SliderInput angleSlider = new SliderInput(50, 155, 157, 0, "Angle");
    // private SliderInput powerSlider = new SliderInput(50, 295, 150, 0, "Power");


	GamePanel() {
        // optiton: super();
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFocusable(true);
        // this.addMouseListener(this);
        // this.addMouseMotionListener(this);
        this.addMouseListener(new MyKeyAdapter());
        startGame();
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
        // **********   fill target color - should be in Target.java ***********
        g.setColor(Color.BLUE);
        g.fillOval(this.target.getX(), this.target.getY(), UNIT_SIZE, UNIT_SIZE);

    }

    public void newTarget() {
        this.target = new CannonTarget();
    }

 

    public class MyKeyAdapter  implements MouseListener{

        

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }
    }

    @Override
    public void ancestorAdded(AncestorEvent event) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void ancestorRemoved(AncestorEvent event) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void ancestorMoved(AncestorEvent event) {
        // TODO Auto-generated method stub
        
    }
}
