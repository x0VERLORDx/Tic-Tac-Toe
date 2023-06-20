package window;
import java.awt.event.ActionEvent;
public class StartScreen extends Frame {
    public StartScreen(){
        createButtons(2,50);
        buttons[0].setText("Classic");
        buttons[1].setText("Advanced");
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[0]) {
            new TicTacToe();
        }
        if (e.getSource() == buttons[1]) {
            new AdvanceTicTacToe();
        }
        frame.dispatchEvent(e);
    }
}
