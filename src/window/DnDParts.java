package window;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

public class DnDParts extends JLabel implements MouseListener {
    Point previousPoint = new Point(0,0);
    public Point currentPoint;
    public Point startPoint;
    int x;
    int y;
    Point centerPoint;
    public int index;
    String text;
    boolean draggable = true;
    int fontSize;
    DnDParts(int x, int y, int fontSize, Object border, Color color, String text, int index){
        this.index = index;
        this.text = text;
        this.fontSize = fontSize;
        this.x = x;
        this.y = y;
        this.startPoint = new Point(x,y);
        this.setOpaque(true);
        this.setBounds(x, y,100,100);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setBackground(new Color(150,150,150));
        this.setFont(new Font("MV Boli",Font.BOLD,fontSize));
        this.setText(text);
        this.setForeground(color);
        this.setBorder((Border)border);
        this.addMouseListener(this);
        DragListener dragListener = new DragListener();
        this.addMouseMotionListener(dragListener);
    }
    public void move(){
        this.setBounds(x, y,100,100);
        centerPoint = new Point(x + 50, y + 50);
        AdvanceTicTacToe.highLight(centerPoint);
    }
    private class DragListener extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent e){
            if (draggable){
                if (
                        (text.equals("X") && AdvanceTicTacToe.xTurn) ||
                        (text.equals("O") && !AdvanceTicTacToe.xTurn)
                ){
                    currentPoint = e.getPoint();
                    x += (int) (currentPoint.getX() - previousPoint.getX());
                    y += (int) (currentPoint.getY() - previousPoint.getY());
                    move();
                }
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        previousPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (draggable) {
            if (
                            (text.equals("X") && AdvanceTicTacToe.xTurn) ||
                            (text.equals("O") && !AdvanceTicTacToe.xTurn)
            ) {
                AdvanceTicTacToe.addElement(index, text, fontSize);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
         if (draggable) {
             if (
                     (text.equals("X") && AdvanceTicTacToe.xTurn) ||
                             (text.equals("O") && !AdvanceTicTacToe.xTurn)
             ) {
                 this.setSize(133, 133);
             }
         }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (draggable) {
            if (
                    (text.equals("X") && AdvanceTicTacToe.xTurn) ||
                            (text.equals("O") && !AdvanceTicTacToe.xTurn)
            ) {
                this.setSize(100, 100);
            }
        }    }
}
