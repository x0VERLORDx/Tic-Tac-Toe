package window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class TicTacToe implements ActionListener {
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean xTurn = true;
    public TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free",Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,600,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for (int i =0;i<9;i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        
        title_panel.add(textField);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        ImageIcon image = new ImageIcon(Objects.requireNonNull(TicTacToe.class.getResource("/logo.png")));
        frame.setIconImage(image.getImage());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Turn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton button:buttons) {
           if (e.getSource()==button){
                if (button.getText().isBlank()) {
                    if (xTurn){
                        button.setForeground(new Color(255,0,0));
                        button.setText("X");
                        xTurn = false;
                    }else{
                        button.setForeground(new Color(0,0,255));
                        button.setText("O");
                        xTurn = true;
                    }
                }
            }
        }
        Turn();
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
            whoWins(0,1,2);
        }
        if(
                buttons[3].getText().equals(buttons[4].getText()) &&
                        buttons[3].getText().equals(buttons[5].getText())&&!buttons[3].getText().isEmpty()
        ) {
            whoWins(3,4,5);
        }
        if(
                buttons[6].getText().equals(buttons[7].getText()) &&
                        buttons[6].getText().equals(buttons[8].getText())&&!buttons[6].getText().isEmpty()
        ) {
            whoWins(6,7,8);
        }
        if(
                buttons[0].getText().equals(buttons[3].getText()) &&
                        buttons[0].getText().equals(buttons[6].getText())&&!buttons[0].getText().isEmpty()
        ) {
            whoWins(0,3,6);
        }
        if(
                buttons[1].getText().equals(buttons[4].getText()) &&
                        buttons[1].getText().equals(buttons[7].getText())&&!buttons[1].getText().isEmpty()
        ) {
            whoWins(1,4,7);
        }
        if(
                buttons[2].getText().equals(buttons[5].getText()) &&
                        buttons[2].getText().equals(buttons[8].getText())&&!buttons[2].getText().isEmpty()
        ) {
            whoWins(2,5,8);
        }
        if(
                buttons[0].getText().equals(buttons[4].getText()) &&
                        buttons[0].getText().equals(buttons[8].getText())&&!buttons[0].getText().isEmpty()
        ) {
            whoWins(0,4,8);
        }
        if(
                buttons[0].getText().equals(buttons[4].getText()) &&
                        buttons[0].getText().equals(buttons[6].getText())&&!buttons[0].getText().isEmpty()
        ) {
            whoWins(2,4,6);
        }
    }
    public void whoWins(int a,int b,int c){
        if (buttons[a].getText().equals("X")){
            xWins(a,b,c);
        }else {
            oWins(a,b,c);
        }
    }
    public void xWins(int a,int b,int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("X wins");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        for(int i=0;i<9;i++) {
//            buttons[i].setEnabled(true);
//            buttons[i].setText("");
//        }
    }
    public void oWins(int a,int b,int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("O wins");
    }
}