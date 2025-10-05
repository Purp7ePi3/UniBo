package it.unibo.mvc;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final Controller controller;    //NOPMD
    private final JFrame frame = new JFrame();

    private SimpleGUI(final Controller cntr) {
        this.controller = cntr; //NOPMD
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel panel = new JPanel(new BorderLayout());
        final JTextField text = new JTextField();
        panel.add(text, BorderLayout.NORTH);
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        panel.add(textArea, BorderLayout.CENTER);
        final JPanel south = new JPanel();
        south.setLayout(new BoxLayout(south, BoxLayout.LINE_AXIS));
        final JButton printButton = new JButton("Print");
        final JButton showButton = new JButton("Show");
        south.add(printButton, BorderLayout.EAST);
        south.add(showButton, BorderLayout.WEST);
        panel.add(south, BorderLayout.SOUTH);
        frame.setContentPane(panel);
         /*
         * Handlers
         */
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    SimpleGUI.this.controller.nextString(text.getText());
                    SimpleGUI.this.controller.printCurret();
                } catch (IOException e1) {
                    e1.printStackTrace();   //NOPMD
                }
            }
        });
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final StringBuilder text = new StringBuilder();
                final List<String> history = SimpleGUI.this.controller.getAllStrings();
                for (final String toPrint: history) {
                    text.append(toPrint).append('\n');
                }
                textArea.setText(text.toString());
            }
        });

        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screenSize.getWidth();
        final int sh = (int) screenSize.getHeight();
        frame.setSize(sw, sh);
        frame.setSize(sw / 2, sh / 2);
        frame.setLocationByPlatform(true);

    }


    private void display() {
        frame.setVisible(true);
    }

    /**
     *
     * @param args
     *            ignored
     */
    public static void main(final String[] args) {
        new SimpleGUI(new SimpleController()).display();
    }
}

