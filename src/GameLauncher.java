import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLauncher {
    public static void main(String[] args) {
        // Ensure the GUI creation is done on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        // Creating the "main frame" (window)
        JFrame frame = new JFrame("Game Launcher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400); // Set the size of the window/game launcher

        // Use BorderLayout for the main frame
        frame.setLayout(new BorderLayout());

        // Creating and adding a logo panel at the top :)
        JPanel logoPanel = new JPanel();
        logoPanel.setPreferredSize(new Dimension(600, 100));
        logoPanel.add(new JLabel("Game Logo")); // Placeholder for a logo
        frame.add(logoPanel, BorderLayout.NORTH);

        // Creating and adding a news panel on the left for updates or other info
        JPanel newsPanel = new JPanel();
        newsPanel.setPreferredSize(new Dimension(200, 300));
        newsPanel.setBorder(BorderFactory.createTitledBorder("News"));
        // Add a text area to the news panel
        JTextArea newsArea = new JTextArea(10, 15);
        newsArea.setText("News and updates will appear here.");
        newsArea.setWrapStyleWord(true);
        newsArea.setLineWrap(true);
        newsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(newsArea);
        newsPanel.add(scrollPane);
        frame.add(newsPanel, BorderLayout.WEST);

        // Creating and adding a settings panel on the right for launcher settings like version, ram-usage or graphics ???
        JPanel settingsPanel = new JPanel();
        settingsPanel.setPreferredSize(new Dimension(100, 300));
        JButton settingsButton = new JButton("Settings");
        settingsButton.setPreferredSize(new Dimension(80, 40)); // Set button size
        settingsPanel.add(settingsButton);
        frame.add(settingsPanel, BorderLayout.EAST);

        // Creating and adding the play button at the bottom
        JPanel bottomPanel = new JPanel();
        JButton playButton = new JButton("Play");
        playButton.setPreferredSize(new Dimension(100, 50)); // Set button size
        bottomPanel.add(playButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Add action listener to the play button
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Dispose of the launcher frame / Close the game launcher
                frame.dispose();

                // Launch the game window by calling the GameWindow class ._.
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        GameWindow gameWindow = new GameWindow();
                        gameWindow.setVisible(true);
                    }
                });
            }
        });

        // Adding action listener to the settings button
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Placeholder action for settings
                JOptionPane.showMessageDialog(frame, "Opening settings...");
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}