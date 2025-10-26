package br.com.dio.ui.custom.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class btnFinishGame extends JButton {
    public btnFinishGame(final ActionListener actionListener) {
        super("Finish Game");
        this.setText("Finish the current game.");
        this.addActionListener(actionListener);
    }
}
