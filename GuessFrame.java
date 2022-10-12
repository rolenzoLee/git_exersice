package rolenzo.java2.ex1;
import javax.swing.*;

import rolenzo.java2.ex1.NewGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GuessFrame extends JFrame {
    private NewGame newGame;
    private JButton newGameButton;
    private JButton guessButton;
    private JTextField inputField;
    private JTextArea displayArea;
    private String displayString = "";
    

    public GuessFrame() {
        super("Guess1A2B!");
        
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        newGameButton = new JButton("New Game");
        guessButton = new JButton("Guess");
        inputField = new JTextField(10);
        displayArea = new JTextArea(10,20);
        displayArea.setEditable(false);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        // JPanel boxPanel1 = new JPanel();
        // boxPanel1.setLayout(new BoxLayout(boxPanel1, BoxLayout.PAGE_AXIS));
        // JPanel boxPanel2 = new JPanel();
        // boxPanel2.setLayout(new BoxLayout(boxPanel2, BoxLayout.PAGE_AXIS));

        MyEventHandler handler = new MyEventHandler();
        newGameButton.addActionListener(handler);
        guessButton.addActionListener(handler);
        add(inputField);
        add(guessButton);

        add(newGameButton);
        add(displayArea);

        newGame = new NewGame();
        System.out.println(newGame.getAns());
        setVisible(true);

    }
    private class MyEventHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == guessButton) {
                guess();
            }
            else if (e.getSource() == newGameButton) {
                newGame = new NewGame();
                guessButton.setEnabled(true);
                displayString = "";
                displayArea.setText(displayString);
                System.out.println(newGame.getAns());
            }
        }
    }
    public void guess() {
        displayString += inputField.getText() + " ";
        int A = 0, B = 0;
        char[] ans = newGame.getAns();
        char[] guess = inputField.getText().toCharArray();

        inputField.setText("");
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (ans[i] == guess[j] && i == j) {
                    A++;
                }
                if (ans[i] == guess[j] && i != j) {
                    B++;
                }
            }
        }
        displayString += A + "A" + B + "B\n";
        if (A == 4) {
            displayString += "Congratulations! Click \"New Game\" to play again!";
            guessButton.setEnabled(false);
        }
        displayArea.setText(displayString);
        
    }
}
