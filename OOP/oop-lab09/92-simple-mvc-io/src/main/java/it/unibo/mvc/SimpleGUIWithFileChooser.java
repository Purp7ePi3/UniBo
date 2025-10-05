package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int RESIZE = 5;
    private static final Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();

    private final JFrame frame = new JFrame();

    private SimpleGUIWithFileChooser(final Controller strg) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel panel1 = new JPanel(new BorderLayout());
        final JTextArea text = new JTextArea();
        final JButton save = new JButton("Save");
        panel1.add(text, BorderLayout.CENTER);
        panel1.add(save, BorderLayout.SOUTH);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent event) {
                try {
                    strg.stamp(text.getText());
                } catch (IOException e) {
                    e.printStackTrace();    //NOPMD
                }
            }
        });
        final JTextField filePath = new JTextField(strg.getCurrentFilePath());
        filePath.setEditable(false);
        final JButton choose = new JButton("Browse");
        choose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent event) {
                final JFileChooser fileChooser = new JFileChooser("Where to save");
                fileChooser.setSelectedFile(strg.getCurrentFile());
                final int result = fileChooser.showSaveDialog(frame);
                switch (result) {
                    case JFileChooser.APPROVE_OPTION:
                        final File newDest = fileChooser.getSelectedFile();
                        strg.setDestination(newDest);
                        filePath.setText(newDest.getPath());
                        break;
                    case JFileChooser.CANCEL_OPTION:
                        break;
                    default:
                        JOptionPane.showMessageDialog(frame, result, "ZioBello", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.add(filePath, BorderLayout.CENTER);
        panel2.add(choose, BorderLayout.LINE_END);
        panel1.add(panel2, BorderLayout.NORTH);
        frame.setContentPane(panel1);
        frame.setSize((int) SCREENSIZE.getWidth() / RESIZE, (int) SCREENSIZE.getHeight() / RESIZE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * 
     * @param a
     */
    public static void main(final String... a) {
        new SimpleGUIWithFileChooser(new Controller());
    }

}
