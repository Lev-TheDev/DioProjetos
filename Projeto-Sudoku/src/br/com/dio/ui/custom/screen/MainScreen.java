package br.com.dio.ui.custom.screen;

import br.com.dio.service.BoardService;
import br.com.dio.ui.custom.button.btnCheckGameStatus;
import br.com.dio.ui.custom.button.btnFinishGame;
import br.com.dio.ui.custom.button.btnReset;
import br.com.dio.ui.custom.frame.MainFrame;
import br.com.dio.ui.custom.panel.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class MainScreen {

    private final static Dimension dimension = new Dimension(600, 600);

    private final BoardService boardService;

    private JButton finishGameButton;
    private JButton checkGameStatusButton;

    private JButton resetButton;

    public MainScreen(final Map<String, String>gameConfig) {
        this.boardService = new BoardService(gameConfig);
    }

    public void buildMainScreen(){
        JPanel mainPanel = new MainPanel(dimension);
        JFrame mainFrame = new MainFrame(dimension, mainPanel);
        addResetButton(mainPanel);
        addCheckGameStatusButton(mainPanel);
        addFinishGameButton(mainPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void addResetButton(final JPanel mainPanel) {
        resetButton = new btnReset(e -> {
            var dialogResult = JOptionPane.showConfirmDialog(
                    mainPanel,
                    "Are you sure you want to reset the board?",
                    "Reset Board",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (dialogResult == 0) {
                boardService.reset();
            }
        });
        mainPanel.add(resetButton);
    }

    private void addCheckGameStatusButton(final JPanel mainPanel) {
        checkGameStatusButton = new btnCheckGameStatus(e -> {
            var hasErrors = boardService.hasErrors();
            var gameStatus = boardService.getStatus();
            var message = switch (gameStatus) {
                case NON_STARTED -> "The game has not started yet";
                case INCOMPLETE -> "The game is still in progress";
                case COMPLETE -> "The game is completed";
            };
            message += hasErrors ? ", although it has errors." : ", by the way it has no errors.";
            JOptionPane.showMessageDialog(null, message);
        });
        mainPanel.add(checkGameStatusButton);
    }

    private void addFinishGameButton(final JPanel mainPanel) {
        finishGameButton = new btnFinishGame(e -> {
            if (boardService.gameIsFinished()) {
                JOptionPane.showMessageDialog(null, "Congratulations! You have completed the game successfully.");
                resetButton.setEnabled(false);
                checkGameStatusButton.setEnabled(false);
                finishGameButton.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "The game is not yet complete or has errors. Keep trying!");
            }
        });
        mainPanel.add(finishGameButton);
    }
}
