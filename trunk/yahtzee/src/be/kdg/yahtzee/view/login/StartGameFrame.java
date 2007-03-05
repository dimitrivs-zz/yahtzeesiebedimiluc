package be.kdg.yahtzee.view.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class StartGameFrame extends JFrame implements ActionListener {
    private JPanel titlePnl;
    private JPanel inputPnl;
    private JPanel buttonPnl;
    private GameRoomFrame gameRoomFrame;
    private ResourceBundle resources;

    public StartGameFrame(String title, ResourceBundle resources, GameRoomFrame gameRoomFrame) {
        super(title);
        this.resources = resources;
        this.gameRoomFrame = gameRoomFrame;
        makeComponents();
        makeLayout();
        addListeners();
        showFrame();
    }

    public void makeComponents() {

        titlePnl = new JPanel();
        inputPnl = new JPanel();
        buttonPnl = new JPanel();
    }

    public void makeLayout() {

    }

    public void addListeners() {
    }

    public void showFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        Dimension d = this.getToolkit().getScreenSize();
        setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
        pack();
        setVisible(true);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
