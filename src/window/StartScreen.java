package window;
import java.awt.event.ActionEvent;
public class StartScreen extends Frame {
    public StartScreen(){
        createButtons(2);
        buttons[0].setText("Classic");
        buttons[1].setText("Advanced");
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[0]) {
            this.frame.setVisible(false);
            new TicTacToe();
        }
    }
}
