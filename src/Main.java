import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main implements KeyListener, ActionListener {
    int runningCount = 0;
    int totalDecks  = 4;
    int trueCount = 0;
    String windowTitle = "CountTracker v2.0.0";

    JLabel runningCountLabel = new JLabel("0");
    JLabel trueCountLabel = new JLabel("0");
    JLabel totalDecksLabel = new JLabel(Integer.toString(totalDecks));

    Font mainFont = new Font("Arial", Font.BOLD, 25);
    Color backgroundColor = new Color(40, 40, 40);
    Color textColor = new Color(251, 191, 53);

    public static void main(String[] args) {
        Main main = new Main();
        main.setUpWindow();
    }

    void setUpWindow() {
        // set up window frame
        JFrame window = new JFrame();
        window.setSize(300, 200);
        window.setTitle(windowTitle);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.addKeyListener(this);
        window.getContentPane().setBackground(backgroundColor);
        window.setLocationRelativeTo(null);

        // set up main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 15, 30));
        mainPanel.setLayout(new GridLayout(0, 1));
        mainPanel.setBackground(backgroundColor);

        // set up running count panel
        JPanel runningCountPanel = new JPanel();
        runningCountPanel.setBackground(backgroundColor);

        JLabel runningText = new JLabel("Run:");
        runningText.setFont(mainFont);
        runningText.setForeground(textColor);

        runningCountLabel.setFont(mainFont);
        runningCountLabel.setForeground(new Color(240,240,240));

        runningCountPanel.add(runningText);
        runningCountPanel.add(runningCountLabel);

        // set up true count panel
        JPanel trueCountPanel = new JPanel();
        trueCountPanel.setBackground(backgroundColor);

        JLabel trueText = new JLabel("True:");
        trueText.setFont(mainFont);
        trueText.setForeground(textColor);

        trueCountLabel.setFont(mainFont);
        trueCountLabel.setForeground(new Color(221, 160, 221));

        trueCountPanel.add(trueText);
        trueCountPanel.add(trueCountLabel);

        // set up total decks panel
        JPanel totalDecksPanel = new JPanel();
        totalDecksPanel.setBackground(backgroundColor);

        JLabel totalText = new JLabel("Total decks:");
        totalText.setForeground(new Color(153, 153, 153));

        JButton totalDecksEdit = new JButton("Edit");
        totalDecksEdit.setFocusable(false);
        totalDecksEdit.addActionListener(this);

        totalDecksLabel.setForeground(new Color(240, 240, 240));
        totalDecksLabel.setFont(new Font("Arial", Font.BOLD, 22));

        totalDecksPanel.add(totalText);
        totalDecksPanel.add(totalDecksLabel);
        totalDecksPanel.add(totalDecksEdit);

        // add count panels to main panel
        mainPanel.add(runningCountPanel);
        mainPanel.add(trueCountPanel);
        mainPanel.add(totalDecksPanel);

        // add main panel to window
        window.add(mainPanel, BorderLayout.WEST);
        window.pack();
        window.setVisible(true);
    }

    void updateRunningCountLabel() {
        runningCountLabel.setText(Integer.toString(runningCount));
    }

    void updateTrueCountLabel() {
        trueCount = runningCount / totalDecks;
        trueCountLabel.setText(Integer.toString(trueCount));
    }

    void updateTotalDecksLabel() {
        totalDecksLabel.setText(Integer.toString(totalDecks));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case 37:
                runningCount--;
                break;
            case 39:
                runningCount++;
                break;
            case 82:
                runningCount = 0;
                break;
        }

        updateRunningCountLabel();
        updateTrueCountLabel();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        displayNumDecksDialog();
    }

    void displayNumDecksDialog() {
        String decks = JOptionPane.showInputDialog("Number of decks:", totalDecks);

        if (decks != null && isInteger(decks)) {
            totalDecks = Integer.parseInt(decks);
            updateTotalDecksLabel();
            updateTrueCountLabel();
        }
    }

    boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
