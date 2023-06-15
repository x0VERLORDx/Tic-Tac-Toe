package window;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
public class AdvanceFieldParts extends JLayeredPane {
    Border border = BorderFactory.createLineBorder(new Color(50, 50, 50),1);
    String text = "";
    public AdvanceFieldParts(){
        this.setOpaque(true);
        this.setBackground(new Color(0,250,0));
        this.setBorder(border);
    }
    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return text;
    }
}
