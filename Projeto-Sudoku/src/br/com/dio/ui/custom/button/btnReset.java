package br.com.dio.ui.custom.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class btnReset extends JButton {
    public btnReset(final ActionListener actionListener) {
        super("Reset Game");
        this.setText("Reset the current game.");
        this.addActionListener(actionListener);
    }
}
