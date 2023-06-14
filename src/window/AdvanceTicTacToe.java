package window;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AdvanceTicTacToe extends Frame {
    Border border = BorderFactory.createLineBorder(new Color(50, 50, 50),1);
    JLayeredPane field = new JLayeredPane();
    JPanel[] fieldParts = new JPanel[9];
    DnDParts[] xParts = new DnDParts[9];
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
            xParts[i] = new DnDParts(15 + 60 * i, 5 + 15*i,75,border,Color.RED, "X");
            xPanel.add(xParts[i]);
            //fieldParts[i].addActionListener(this);
        }
        for (int i = 5;i > 2;i--) {
            xParts[i] = new DnDParts(15 + 60 * (i%3), 90 + 15*i,50,border,Color.RED, "X");
            xPanel.add(xParts[i]);
            //fieldParts[i].addActionListener(this);
        }
        for (int i = 8;i > 5;i--) {
            xParts[i] = new DnDParts(15 + 60 * (i%3), 175 + 15*i,25,border,Color.RED, "X");
            xPanel.add(xParts[i]);
            //fieldParts[i].addActionListener(this);
        }
        for (int i = 0;i < 3;i++) {
            oParts[i] = new DnDParts(15 + 53 * (i%3), 35 - 15*i,75,border,Color.BLUE, "O");
            oPanel.add(oParts[i]);
            //fieldParts[i].addActionListener(this);
        }
        for (int i = 3;i < 6;i++) {
            oParts[i] = new DnDParts(15 + 53 * (i%3), 210 - 15*i,50,border,Color.BLUE, "O");
            oPanel.add(oParts[i]);
            //fieldParts[i].addActionListener(this);
        }
        for (int i = 6;i < 9;i++) {
            oParts[i] = new DnDParts(15 + 53 * (i%3), 385 - 15*i,25,border,Color.BLUE, "O");
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
            field.setComponentZOrder(fieldParts[i],0);
            //fieldParts[i].addActionListener(this);
        }

        frame.add(field);
        frame.add(xPanel);
        frame.add(oPanel);

    }
}
