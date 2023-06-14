package window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DnDParts extends JLabel {
    Point label_corner;
    Point previousPoint;
    DnDParts(){
        label_corner = new Point(0,0);
        ClickListener clickListener = new ClickListener();
        this.addMouseListener(clickListener);
        DragListener dragListener = new DragListener();
        this.addMouseMotionListener(dragListener);
    }
    public void move(){
        this.setBounds((int)(label_corner.getX()), (int)label_corner.getY(),100,100);
    }

    private class ClickListener extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            previousPoint = e.getPoint();
        }
    }

    private class DragListener extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent e){
            Point currentPoint = e.getPoint();
            label_corner.translate((int)(currentPoint.getX() - previousPoint.getX()),
                                    (int)(currentPoint.getY() - previousPoint.getY()));

            previousPoint = currentPoint;
            move();
        }
    }
}
