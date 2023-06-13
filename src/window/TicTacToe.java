package window;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
public class TicTacToe extends Frame {
    boolean xTurn = true;
    public TicTacToe(){
        frame.setLayout(new BorderLayout());
        createScorePanel(600);
        createButtons(9,75);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel,BorderLayout.CENTER);
        Turn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==resetButton){
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(true);
                buttons[i].setText("");
            }
            try {
                Sounds.playResetSound();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                throw new RuntimeException(ex);
            }
        }
        for (JButton button:buttons) {
           if (e.getSource()==button){
                if (button.getText().isBlank()) {
                    if (xTurn){
                        button.setForeground(new Color(255,0,0));
                        button.setText("X");
                        try {
                            Sounds.playXSound();
                        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                            throw new RuntimeException(ex);
                        }
                        xTurn = false;
                    }else{
                        button.setForeground(new Color(0,0,255));
                        button.setText("O");
                        try {
                            Sounds.playOSound();
                        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                            throw new RuntimeException(ex);
                        }
                        xTurn = true;
                    }
                }
            }
        }
        Check();

    }
    public void Turn(){
        if (xTurn){
            textField.setText("X turn");
        }else {
            textField.setText("O turn");
        }
    }
    public void Check(){
        if(
                buttons[0].getText().equals(buttons[1].getText()) &&
                        buttons[0].getText().equals(buttons[2].getText())&&!buttons[0].getText().isEmpty()
        ) {
            whoWins();
        }
        if(
                buttons[0].getText().equals(buttons[3].getText()) &&
                        buttons[0].getText().equals(buttons[6].getText())&&!buttons[0].getText().isEmpty()
        ) {
            whoWins();
        }
        if(
                buttons[0].getText().equals(buttons[4].getText()) &&
                        buttons[0].getText().equals(buttons[8].getText())&&!buttons[0].getText().isEmpty()
        ) {
            whoWins();
        }
        if(
                buttons[1].getText().equals(buttons[4].getText()) &&
                        buttons[1].getText().equals(buttons[7].getText())&&!buttons[1].getText().isEmpty()
        ) {
            whoWins();
        }
        if(
                buttons[2].getText().equals(buttons[5].getText()) &&
                        buttons[2].getText().equals(buttons[8].getText())&&!buttons[2].getText().isEmpty()
        ) {
            whoWins();
        }
        if(
                buttons[2].getText().equals(buttons[4].getText()) &&
                        buttons[2].getText().equals(buttons[6].getText())&&!buttons[2].getText().isEmpty()
        ) {
            whoWins();
        }
        if(
                buttons[3].getText().equals(buttons[4].getText()) &&
                        buttons[3].getText().equals(buttons[5].getText())&&!buttons[3].getText().isEmpty()
        ) {
            whoWins();
        }
        if(
                buttons[6].getText().equals(buttons[7].getText()) &&
                        buttons[6].getText().equals(buttons[8].getText())&&!buttons[6].getText().isEmpty()
        ) {
            whoWins();
        }
        Turn();
    }
    public void whoWins(){
        try {
            Sounds.playWinSound();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            throw new RuntimeException(ex);
        }
        if (!xTurn){
            xWins();
        }else {
            oWins();
        }
    }
    public void xWins() {
        xWin++;
        scoreField.setText("X " + xWin + " : " + oWin + " O");
        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("X wins");

    }
    public void oWins() {
        oWin++;
        scoreField.setText("X " + xWin + " : " + oWin + " O");
        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("O wins");
    }
}
