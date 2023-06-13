package window;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AdvanceTicTacToe extends Frame {
    Border border = BorderFactory.createLineBorder(new Color(50, 50, 50),1);
    JLayeredPane field = new JLayeredPane();
    JPanel[] fieldParts = new JPanel[9];
    JLabel xParts = new JLabel();
    JLabel oParts = new JLabel();
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

        xParts.setOpaque(true);
        oParts.setOpaque(true);
        xParts.setBackground(Color.RED);
        oParts.setBackground(Color.BLUE);
        xPanel.add(xParts);
        oPanel.add(oParts);
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
