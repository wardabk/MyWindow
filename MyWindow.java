import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.*;

public class MyWindow extends JFrame {
    private Clip clip;

    public MyWindow() {
        setTitle("My Demo Window");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Ajouter une image
        JLabel imageLabel = new JLabel(new ImageIcon("mac.jpg"));
        add(imageLabel, BorderLayout.CENTER);

        // Panel des boutons
        JPanel buttonPanel = new JPanel();
        JButton playButton = new JButton("Play");
        JButton stopButton = new JButton("Stop");

        playButton.addActionListener(e -> playSound("sonnerie.wav"));
        stopButton.addActionListener(e -> stopSound());

        buttonPanel.add(playButton);
        buttonPanel.add(stopButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void playSound(String soundFile) {
        try {
           File file = new File(soundFile);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void stopSound() {
        if (clip != null) clip.stop();
    }
}