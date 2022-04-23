import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class NewSlider extends JSlider {

    protected JLabel label;

    NewSlider(String title, int min, int max, int value, int spacing) {
        super(min, max, value);
        this.label = new JLabel();
        this.setPreferredSize(new Dimension(220, 100));
        this.setPaintTrack(true);
        this.setMajorTickSpacing(spacing);
        this.setPaintLabels(true);
        label.setText(title);
        label.setFont(new Font("MV Boli", Font.PLAIN, 15));
    }

}
