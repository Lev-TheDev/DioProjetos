package br.com.dio.ui.custom.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class btnCheckGameStatus extends JButton {
    public btnCheckGameStatus(final ActionListener actionListener) {
        super("Check Game Status");
        this.setText("CHECK GAME STATUS");
        this.addActionListener(actionListener);
    }
}
