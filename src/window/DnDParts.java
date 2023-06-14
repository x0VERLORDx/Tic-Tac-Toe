package window;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DnDParts extends JLabel {
    Point previousPoint = new Point(0,0);
    int x;
    int y;
    DnDParts(int x, int y, int fontSize, Object border, Color color, String text){
        this.x = x;
        this.y = y;
        this.setOpaque(true);
        this.setBounds(x, y,100,100);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setBackground(new Color(150,150,150));
        this.setFont(new Font("MV Boli",Font.BOLD,fontSize));
        this.setText(text);
        this.setForeground(color);
        this.setBorder((Border)border);
        ClickListener clickListener = new ClickListener();
        this.addMouseListener(clickListener);
        DragListener dragListener = new DragListener();
        this.addMouseMotionListener(dragListener);
    }
    public void move(){
        this.setBounds(x, y,100,100);
    }

    private class ClickListener extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            previousPoint = e.getPoint();
        }
    }
    private class DragListener extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent e){
            Point currentPoint = e.getPoint();
            x += (int)(currentPoint.getX() - previousPoint.getX());
            y += (int)(currentPoint.getY() - previousPoint.getY());
            move();
        }
    }
}
