package window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class StartScreen implements ActionListener {
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JButton[] buttons = new JButton[2];
    JLabel textField = new JLabel();
    public StartScreen(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free",Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,600,100);

        button_panel.setBounds(150,200,300,200);
        button_panel.setLayout(new GridLayout(2,1));
        button_panel.setBackground(new Color(150,150,150));
        for (int i =0;i<2;i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,50));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        button_panel.add(buttons[0]);
        button_panel.add(buttons[1]);
        buttons[0].setText("Classic");
        buttons[1].setText("Advanced");
        title_panel.add(textField);

        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel,BorderLayout.CENTER);

        ImageIcon image = new ImageIcon(Objects.requireNonNull(TicTacToe.class.getResource("/logo.png")));
        frame.setIconImage(image.getImage());
    }
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttons[0]) {
            this.frame.setVisible(false);
            new TicTacToe();
        }
    }
}
