package window;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AdvanceTicTacToe extends Frame {
    Border border = BorderFactory.createLineBorder(new Color(50, 50, 50),1);
    JLayeredPane field = new JLayeredPane();
    JPanel[] fieldParts = new JPanel[9];
    JLabel[] xParts = new JLabel[9];
    JLabel[] oParts = new JLabel[9];
    JLayeredPane xPanel = new JLayeredPane();
    JLayeredPane oPanel = new JLayeredPane();
    public AdvanceTicTacToe(){
        frame.setLayout(null);
        frame.setSize(900, 640);
        createScorePanel(900);


        xPanel.setVisible(true);
        oPanel.setVisible(true);
        xPanel.setBounds(0,100,250,440);
        oPanel.setBounds(650,100,250,440);
        xPanel.setPreferredSize(new Dimension(200,100));
        oPanel.setPreferredSize(new Dimension(200,100));

        for (int i = 2;i >= 0;i--) {
            xParts[i] = new JLabel();
            xParts[i].setOpaque(true);
            xParts[i].setBounds(15 + 60 * i, 5 + 15*i,100,100);
            xParts[i].setFont(new Font("MV Boli",Font.BOLD,75));
            xParts[i].setText("X");
            xParts[i].setHorizontalAlignment(JLabel.CENTER);
            xParts[i].setVerticalAlignment(JLabel.CENTER);
            xParts[i].setBackground(new Color(150,150,150));
            xParts[i].setForeground(Color.RED);
            xParts[i].setBorder(border);
            xPanel.add(xParts[i]);
            //fieldParts[i].addActionListener(this);
        }
        for (int i = 5;i > 2;i--) {
            xParts[i] = new JLabel();
            xParts[i].setOpaque(true);
            xParts[i].setBounds(15 + 60 * (i%3), 90 + 15*i,100,100);
            xParts[i].setFont(new Font("MV Boli",Font.BOLD,50));
            xParts[i].setText("X");
            xParts[i].setHorizontalAlignment(JLabel.CENTER);
            xParts[i].setVerticalAlignment(JLabel.CENTER);
            xParts[i].setBackground(new Color(150,150,150));
            xParts[i].setForeground(Color.RED);
            xParts[i].setBorder(border);
            xPanel.add(xParts[i]);
            //fieldParts[i].addActionListener(this);
        }
        for (int i = 8;i > 5;i--) {
            xParts[i] = new JLabel();
            xParts[i].setOpaque(true);
            xParts[i].setBounds(15 + 60 * (i%3), 175 + 15*i,100,100);
            xParts[i].setFont(new Font("MV Boli",Font.BOLD,25));
            xParts[i].setText("X");
            xParts[i].setHorizontalAlignment(JLabel.CENTER);
            xParts[i].setVerticalAlignment(JLabel.CENTER);
            xParts[i].setBackground(new Color(150,150,150));
            xParts[i].setForeground(Color.RED);
            xParts[i].setBorder(border);
            xPanel.add(xParts[i]);
            //fieldParts[i].addActionListener(this);
        }
        for (int i = 0;i < 3;i++) {
            oParts[i] = new JLabel();
            oParts[i].setOpaque(true);
            oParts[i].setBounds(15 + 53 * i, 35 - 15*i,100,100);
            oParts[i].setFont(new Font("MV Boli",Font.BOLD,75));
            oParts[i].setText("O");
            oParts[i].setHorizontalAlignment(JLabel.CENTER);
            oParts[i].setVerticalAlignment(JLabel.CENTER);
            oParts[i].setBackground(new Color(150,150,150));
            oParts[i].setForeground(Color.BLUE);
            oParts[i].setBorder(border);
            oPanel.add(oParts[i]);
            //fieldParts[i].addActionListener(this);
        }
        for (int i = 3;i < 6;i++) {
            oParts[i] = new JLabel();
            oParts[i].setOpaque(true);
            oParts[i].setBounds(15 + 53 * (i%3), 210 - 15*i,100,100);
            oParts[i].setFont(new Font("MV Boli",Font.BOLD,50));
            oParts[i].setText("O");
            oParts[i].setHorizontalAlignment(JLabel.CENTER);
            oParts[i].setVerticalAlignment(JLabel.CENTER);
            oParts[i].setBackground(new Color(150,150,150));
            oParts[i].setForeground(Color.BLUE);
            oParts[i].setBorder(border);
            oPanel.add(oParts[i]);
            //fieldParts[i].addActionListener(this);
        }
        for (int i = 6;i < 9;i++) {
            oParts[i] = new JLabel();
            oParts[i].setOpaque(true);
            oParts[i].setBounds(15 + 53 * (i%3), 385 - 15*i,100,100);
            oParts[i].setFont(new Font("MV Boli",Font.BOLD,25));
            oParts[i].setText("O");
            oParts[i].setHorizontalAlignment(JLabel.CENTER);
            oParts[i].setVerticalAlignment(JLabel.CENTER);
            oParts[i].setBackground(new Color(150,150,150));
            oParts[i].setForeground(Color.BLUE);
            oParts[i].setBorder(border);
            oPanel.add(oParts[i]);
            //fieldParts[i].addActionListener(this);
        }

        title_panel.setBounds(0,0,900,100);

        field.setBounds(250,100,400,400);
        field.setLayout(new GridLayout(3,3));


        for (int i =0;i<9;i++) {
            fieldParts[i] = new JPanel();
            field.add(fieldParts[i]);
            //fieldParts[i].setFont(new Font("MV Boli",Font.BOLD,fontSize));
            fieldParts[i].setOpaque(true);
            fieldParts[i].setBackground(new Color(0,250,0));
            fieldParts[i].setBorder(border);
            //fieldParts[i].addActionListener(this);
        }

        frame.add(field);
        frame.add(xPanel);
        frame.add(oPanel);

    }
}
