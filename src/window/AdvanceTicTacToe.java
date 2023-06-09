package window;
import javax.swing.*;
import java.awt.*;

public class AdvanceTicTacToe extends Frame {

    JLayeredPane xPanel = new JLayeredPane();
    JLayeredPane oPanel = new JLayeredPane();
    public AdvanceTicTacToe(){
        frame.setLayout(new BorderLayout());
        createScorePanel();
        xPanel.setVisible(true);
        oPanel.setVisible(true);
        xPanel.setBackground(Color.green);
        oPanel.setBackground(Color.red);
        frame.add(xPanel,BorderLayout.WEST);
        frame.add(oPanel,BorderLayout.EAST);
    }
}
