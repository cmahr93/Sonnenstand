package view;

import controller.MainController;

import javax.swing.*;
import java.awt.*;

/** Die View-Klasse enthält nur die Präsentation. Hier sollte man keinerlei Programmlogik finden.
 * Alle Berechnungen und Reaktionen auf Benutzeraktionen sollten im Controller stehen
 */
public class View extends JFrame {

    private JLabel label;

    public View() {
        init();
    }

    /**
     * Die JForm initialisieren und alle Steuerelemente darauf positionieren
     */
    private void init() {
        label = new JLabel(" ");
        label.setHorizontalAlignment(JLabel.CENTER);
        JButton button = new JButton("klick");
        button.addActionListener(new MainController(this));
        this.add(label, BorderLayout.NORTH);
        this.add(button, BorderLayout.CENTER);
        this.pack();
        this.setTitle("MVC");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void setText(String s) {
        label.setText(s);
    }

}