import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class NewSlider extends JSlider {

    protected JLabel label;

    NewSlider(String title) {
        super();
        this.label = new JLabel();
        this.setPreferredSize(new Dimension(220, 100));
        this.setPaintTicks(true);
        this.setMinorTickSpacing(15);
        label.setText(title);
        label.setFont(new Font("MV Boli", Font.PLAIN, 15));
    }

}
