package window;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class AdvanceTicTacToe extends Frame {
    Border border = BorderFactory.createLineBorder(new Color(50, 50, 50),1);
    JPanel field = new JPanel();
    public static AdvanceFieldParts[] fieldParts = new AdvanceFieldParts[9];
    static DnDParts[] xParts = new DnDParts[9];
    static DnDParts[] oParts = new DnDParts[9];
    static JLayeredPane playZone = new JLayeredPane();
    static int highLightedPanel = -1;
    static boolean xTurn = true;
    public AdvanceTicTacToe(){
        frame.setLayout(null);
        frame.setSize(900, 640);
        createScorePanel(900);


        playZone.setVisible(true);
        playZone.setBounds(0,100,900,440);


        for (int i = 2;i >= 0;i--) {
            xParts[i] = new DnDParts(15 + 60 * i, 5 + 15*i,75,border,Color.RED, "X", i);
            playZone.add(xParts[i]);
            //fieldParts[i].addActionListener(this);
        }
        for (int i = 5;i > 2;i--) {
            xParts[i] = new DnDParts(15 + 60 * (i%3), 90 + 15*i,50,border,Color.RED, "X", i);
            playZone.add(xParts[i]);
            //fieldParts[i].addActionListener(this);
        }
        for (int i = 8;i > 5;i--) {
            xParts[i] = new DnDParts(15 + 60 * (i%3), 175 + 15*i,25,border,Color.RED, "X", i);
            playZone.add(xParts[i]);
            //fieldParts[i].addActionListener(this);
        }
        for (int i = 0;i < 3;i++) {
            oParts[i] = new DnDParts(665 + 53 * (i%3), 35 - 15*i,75,border,Color.BLUE, "O", i);
            playZone.add(oParts[i]);
            //fieldParts[i].addActionListener(this);
        }
        for (int i = 3;i < 6;i++) {
            oParts[i] = new DnDParts(665 + 53 * (i%3), 210 - 15*i,50,border,Color.BLUE, "O", i);
            playZone.add(oParts[i]);
            //fieldParts[i].addActionListener(this);
        }
        for (int i = 6;i < 9;i++) {
            oParts[i] = new DnDParts(665 + 53 * (i%3), 385 - 15*i,25,border,Color.BLUE, "O", i);
            playZone.add(oParts[i]);
            //fieldParts[i].addActionListener(this);
        }

        title_panel.setBounds(0,0,900,100);

        field.setBounds(250,0,400,400);
        field.setLayout(new GridLayout(3,3));

       //


        for (int i = 0; i < 9; i++) {
            fieldParts[i] = new AdvanceFieldParts();
            field.add(fieldParts[i]);
        }
        playZone.add(field);
        frame.add(playZone);
        //frame.add(oPanel);
    }

    public static void highLight(Point currentPoint){
        for (int i =0;i<9;i++) {
            fieldParts[i].setBackground(Color.GREEN);
        }
        highLightedPanel = -1;
        if (currentPoint.getX() > 250 && currentPoint.getX() < 383){
            if (currentPoint.getY() > 0 && currentPoint.getY() < 133) {
                highLightedPanel = 0;
                fieldParts[highLightedPanel].setBackground(Color.WHITE);
            }
            if (currentPoint.getY() > 133 && currentPoint.getY() < 266) {
                highLightedPanel = 3;
                fieldParts[highLightedPanel].setBackground(Color.WHITE);
            }
            if (currentPoint.getY() > 266 && currentPoint.getY() < 399) {
                highLightedPanel = 6;
                fieldParts[highLightedPanel].setBackground(Color.WHITE);
            }
        }
        if (currentPoint.getX() > 383 && currentPoint.getX() < 513){
            if (currentPoint.getY() > 0 && currentPoint.getY() < 133) {
                highLightedPanel = 1;
                fieldParts[highLightedPanel].setBackground(Color.WHITE);
            }
            if (currentPoint.getY() > 133 && currentPoint.getY() < 266) {
                highLightedPanel = 4;
                fieldParts[highLightedPanel].setBackground(Color.WHITE);
            }
            if (currentPoint.getY() > 266 && currentPoint.getY() < 399) {
                highLightedPanel = 7;
                fieldParts[highLightedPanel].setBackground(Color.WHITE);
            }
        }
        if (currentPoint.getX() > 513 && currentPoint.getX() < 646){
            if (currentPoint.getY() > 0 && currentPoint.getY() < 133) {
                highLightedPanel = 2;
                fieldParts[highLightedPanel].setBackground(Color.WHITE);
            }
            if (currentPoint.getY() > 133 && currentPoint.getY() < 266) {
                highLightedPanel = 5;
                fieldParts[highLightedPanel].setBackground(Color.WHITE);
            }
            if (currentPoint.getY() > 266 && currentPoint.getY() < 399) {
                highLightedPanel = 8;
                fieldParts[highLightedPanel].setBackground(Color.WHITE);
            }
        }
    }
    public static void addElement(int i, String text, int fontSize){
        if (highLightedPanel == -1 ||
                fieldParts[highLightedPanel].getComponentCountInLayer(fontSize/25) > 0 ||
                (fontSize < 75 && fieldParts[highLightedPanel].getComponentCountInLayer(3) > 0) ||
                (fontSize < 50 && fieldParts[highLightedPanel].getComponentCountInLayer(2) > 0)){
            if (text.equals("X")){
                xParts[i].setBounds((int) xParts[i].startPoint.getX(), (int) xParts[i].startPoint.getY(),xParts[i].getWidth(),xParts[i].getHeight());
            }else {
                oParts[i].setBounds((int) oParts[i].startPoint.getX(), (int) oParts[i].startPoint.getY(),oParts[i].getWidth(),oParts[i].getHeight());
            }
        } else if (text.equals("X")){
            xParts[i].setVisible(false);
            xParts[i].setVisible(true);
            xParts[i].setBounds(0, 0, 133, 133);
            fieldParts[highLightedPanel].add(xParts[i], Integer.valueOf(fontSize/25));
            fieldParts[highLightedPanel].setText("X");
            xParts[i].draggable = false;
            highLightedPanel = -1;
            playZone.remove(xParts[i]);
            Check();
        }else {
            oParts[i].setVisible(false);
            oParts[i].setVisible(true);
            oParts[i].setBounds(0, 0, 133, 133);
            fieldParts[highLightedPanel].add(oParts[i], Integer.valueOf(fontSize / 25));
            fieldParts[highLightedPanel].setText("O");
            oParts[i].draggable = false;
            highLightedPanel = -1;
            playZone.remove(oParts[i]);
            Check();
        }

    }
    public static void Check(){
        turn();
        if(
                fieldParts[0].getText().equals(fieldParts[1].getText()) &&
                        fieldParts[0].getText().equals(fieldParts[2].getText())&&!fieldParts[0].getText().isEmpty()
        ) {
            whoWins();
        }
        if(
                fieldParts[0].getText().equals(fieldParts[3].getText()) &&
                        fieldParts[0].getText().equals(fieldParts[6].getText())&&!fieldParts[0].getText().isEmpty()
        ) {
            whoWins();
        }
        if(
                fieldParts[0].getText().equals(fieldParts[4].getText()) &&
                        fieldParts[0].getText().equals(fieldParts[8].getText())&&!fieldParts[0].getText().isEmpty()
        ) {
            whoWins();
        }
        if(
                fieldParts[1].getText().equals(fieldParts[4].getText()) &&
                        fieldParts[1].getText().equals(fieldParts[7].getText())&&!fieldParts[1].getText().isEmpty()
        ) {
            whoWins();
        }
        if(
                fieldParts[2].getText().equals(fieldParts[5].getText()) &&
                        fieldParts[2].getText().equals(fieldParts[8].getText())&&!fieldParts[2].getText().isEmpty()
        ) {
            whoWins();
        }
        if(
                fieldParts[2].getText().equals(fieldParts[4].getText()) &&
                        fieldParts[2].getText().equals(fieldParts[6].getText())&&!fieldParts[2].getText().isEmpty()
        ) {
            whoWins();
        }
        if(
                fieldParts[3].getText().equals(fieldParts[4].getText()) &&
                        fieldParts[3].getText().equals(fieldParts[5].getText())&&!fieldParts[3].getText().isEmpty()
        ) {
            whoWins();
        }
        if(
                fieldParts[6].getText().equals(fieldParts[7].getText()) &&
                        fieldParts[6].getText().equals(fieldParts[8].getText())&&!fieldParts[6].getText().isEmpty()
        ) {
            whoWins();
        }

    }
    public static void turn(){
        if (!xTurn){
            if (!xParts[0].draggable && !xParts[1].draggable && !xParts[2].draggable) {
                for (int i = 0; i < 9; i++) {
                    if (fieldParts[i].getComponentCountInLayer(2) == 0) {
                        AdvanceTicTacToe.xTurn = true;
                        textField.setText("X turn");
                    }
                }
            }else {
                AdvanceTicTacToe.xTurn = true;
                textField.setText("X turn");
            }
        }else if (!oParts[0].draggable && !oParts[1].draggable && !oParts[2].draggable) {
            for (int i = 0; i < 9; i++) {
                if (fieldParts[i].getComponentCountInLayer(2) == 0) {
                    AdvanceTicTacToe.xTurn = false;
                    textField.setText("O turn");
                }
            }
        }else {
            AdvanceTicTacToe.xTurn = false;
            textField.setText("O turn");
        }
    }

    public static void whoWins(){
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
    public static void xWins() {
        xWin++;
        scoreField.setText("X " + xWin + " : " + oWin + " O");
        for(int i=0;i<9;i++) {
            fieldParts[i].setForeground(Color.GRAY);
            oParts[i].draggable = false;
            xParts[i].draggable = false;
        }
        textField.setText("X wins");

    }
    public static void oWins() {
        oWin++;
        scoreField.setText("X " + xWin + " : " + oWin + " O");
        for(int i=0;i<9;i++) {
            fieldParts[i].setForeground(Color.GRAY);
            oParts[i].draggable = false;
            xParts[i].draggable = false;
        }
        textField.setText("O wins");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==resetButton){
            for (int i = 0; i < 9; i++) {
                fieldParts[i].setBackground(Color.GREEN);
                fieldParts[i].setText("");
                oParts[i].draggable = true;
                xParts[8-i].draggable = true;
                for (int j = 0; j < 9; j++){
                    fieldParts[i].remove(oParts[j]);
                    fieldParts[i].remove(xParts[j]);
                }
                xParts[8-i].setBounds((int) xParts[8-i].startPoint.getX(), (int) xParts[8-i].startPoint.getY(),100,100);
                oParts[i].setBounds((int) oParts[i].startPoint.getX(), (int) oParts[i].startPoint.getY(),100,100);
                oParts[i].setVisible(false);
                xParts[8-i].setVisible(false);
                oParts[i].setVisible(true);
                xParts[8-i].setVisible(true);
                playZone.remove(xParts[8-i]);
                playZone.remove(oParts[i]);
                playZone.add(xParts[8-i],Integer.valueOf(5));
                playZone.add(oParts[i],Integer.valueOf(5));
            }
            turn();
            turn();
            try {
                Sounds.playResetSound();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
