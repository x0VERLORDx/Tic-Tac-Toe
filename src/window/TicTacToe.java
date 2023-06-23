package window;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
public class TicTacToe extends Frame {
    boolean xTurn = true;
    JButton menu = new JButton();
    public TicTacToe(){
        frame.setLayout(null);
        frame.setSize(600,630);
        createScorePanel(600);
        createButtons(9,75);
        menu.setFont(new Font("MV Boli",Font.BOLD,15));
        menu.setText("MENU");
        menu.setFocusable(false);
        menu.setVisible(true);
        menu.setBounds(450, 20, 90, 60);
        menu.addActionListener(this);
        title_panel.setLayout(null);
        title_panel.setBounds(0,0,600,100);
        title_panel.setBackground(new Color(25,25,25));
        title_panel.add(menu);

        textField.setBounds(0,0,450,100);
        button_panel.setBounds(100,100,400,400);
        score_panel.setBounds(0,500,600,100);
       // frame.add(title_panel);
        frame.add(button_panel);
        frame.add(score_panel);
        Turn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==menu){
            for (int i = 0; i < 9; i++) {
                buttons[i].setEnabled(true);
                buttons[i].setText("");
            }
            frame.dispose();
            new StartScreen();
        }

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
                        xTurn = false;
                        try {
                            Sounds.playXSound();
                        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                            throw new RuntimeException(ex);
                        }

                    }else{
                        button.setForeground(new Color(0,0,255));
                        button.setText("O");
                        xTurn = true;
                        try {
                            Sounds.playOSound();
                        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                            throw new RuntimeException(ex);
                        }

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

        if (!xTurn){
            xWins();
        }else {
            oWins();
        }
        try {
            Sounds.playWinSound();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            throw new RuntimeException(ex);
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
