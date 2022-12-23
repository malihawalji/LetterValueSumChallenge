package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.Component.CENTER_ALIGNMENT;
import static java.awt.Font.BOLD;

public class LetterSumUI implements ActionListener {

    protected JPanel panel;
    protected JFrame frame;
    protected JLabel enterWord;
    protected JTextField word;
    protected JButton okay;

    public LetterSumUI() {
        frame = new JFrame("Word Sum Calculator");
        frame.setSize(500, 400);
        panel = new JPanel();
        panel.setSize(500, 400);
        panel.setBackground(new Color(204, 204, 255));
        setUp();
        WindowListener windowListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        };
        frame.setVisible(true);
    }

    public void setUp() {
        enterWord = new JLabel("Enter in a word below: ");
        enterWord.setFont(new Font("ComicSans", BOLD, 20));
        word = new JTextField();
        Dimension d = new Dimension(100, 30);
        word.setMaximumSize(d);
        okay = new JButton("ok");
        okay.addActionListener(this);
        okay.setActionCommand("ok");
        frame.add(panel);
        enterWord.setAlignmentX(CENTER_ALIGNMENT);
        word.setAlignmentX(CENTER_ALIGNMENT);
        okay.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(enterWord);
        panel.add(word);
        panel.add(okay);
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
        panel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if(action.equals("ok")) {
            LetterSum ls = new LetterSum();
            int total = ls.calculateWordTotal(word.getText());
            JOptionPane.showMessageDialog(panel, "the word total is: " + String.valueOf(total));
        }
    }
}
