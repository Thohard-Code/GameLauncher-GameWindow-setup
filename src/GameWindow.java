import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    public GameWindow() {
        setTitle("Game Window");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Example game window panel
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());
        gamePanel.add(new JLabel("Welcome to the Game!", SwingConstants.CENTER), BorderLayout.CENTER);

        add(gamePanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GameWindow gameWindow = new GameWindow();
                gameWindow.setVisible(true);
            }
        });
    }
}