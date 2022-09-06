import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main implements KeyListener {
    int count = 0;
    String windowTitle = "CountTracker v1.1.0";

    JLabel countLabel = new JLabel("0");
    Color backgroundColor = new Color(40, 40, 40);
    Color labelColor = new Color(251, 191, 53);
    // 250, 189, 47

    public static void main(String[] args) {
        Main main = new Main();
        main.createWindow();
    }

    void createWindow() {
        // window frame set up
        JFrame window = new JFrame();
        window.setVisible(true);
        window.setSize(250, 150);
        window.setTitle(windowTitle);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.addKeyListener(this);
        window.getContentPane().setBackground(backgroundColor);
        window.setLocationRelativeTo(null);

        // count label set up
        countLabel.setHorizontalAlignment(JLabel.CENTER);
        countLabel.setVerticalAlignment(JLabel.CENTER);
        countLabel.setFont(new Font("Arial", Font.BOLD, 60));
        countLabel.setForeground(labelColor);

        // add label to frame
        window.add(countLabel);
    }

    void updateCountLabel() {
        countLabel.setText(Integer.toString(count));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case 37:
                count--;
                break;
            case 39:
                count++;
                break;
            case 82:
                count = 0;
                break;
        }
        updateCountLabel();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
