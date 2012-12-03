import java.awt.*;
import javax.swing.*;

public class SquareIconTest {
    public static void main(String[] args) {
        SquareIcon icon = new SquareIcon(50,Color.BLUE);
        JOptionPane.showMessageDialog(
            null,
            "Blue SquareIcon!",
            "SquareIcon Test",
            JOptionPane.INFORMATION_MESSAGE,
            icon
        );
    }
}