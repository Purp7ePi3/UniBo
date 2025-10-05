package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int RESIZE = 5;
    private static final Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();

    private final JFrame frame = new JFrame("MiGiraLaTesta");

    private SimpleGUI(final Controller strg) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JTextArea text = new JTextArea();
        final JPanel panel = new JPanel(new BorderLayout());
        //final LayoutManager layout = new BorderLayout();
        //panel.setLayout(layout);

        final JButton save = new JButton("Save");

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

        panel.add(text, BorderLayout.CENTER);
        panel.add(save, BorderLayout.SOUTH);
        frame.setContentPane(panel);
        //SetScreenSize
        frame.setSize((int) SCREENSIZE.getWidth() / RESIZE, (int) SCREENSIZE.getHeight() / RESIZE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * 
     * @param a
     */
    public static void main(final String... a) {
       new SimpleGUI(new Controller());
    }
}

