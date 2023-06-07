package window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public abstract class Frame extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JButton[] buttons;
    JLabel textField = new JLabel();
    public Frame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
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

        title_panel.add(textField);

        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel,BorderLayout.CENTER);

        ImageIcon image = new ImageIcon(Objects.requireNonNull(TicTacToe.class.getResource("/logo.png")));
        frame.setIconImage(image.getImage());

    }

    public void createButtons(int numberOfButtons){
        buttons = new JButton[numberOfButtons];
        for (int i =0;i<buttons.length;i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,50));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
