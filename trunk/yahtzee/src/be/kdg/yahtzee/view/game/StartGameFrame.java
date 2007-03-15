package be.kdg.yahtzee.view.game;

import be.kdg.yahtzee.model.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.model.remoteObjects.users.User;
import be.kdg.yahtzee.view.YahtzeeSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class StartGameFrame extends YahtzeeSwing implements ActionListener {
    private JPanel titlePnl;
    private JPanel inputPnl;
    private JPanel buttonPnl;

    private JLabel titleLbl;
    private JLabel gameNameLbl;
    private JLabel numberLbl;
    private JLabel errorLbl;

    private JComboBox numberCombo;
    private DefaultComboBoxModel comboModel;
    private JTextField gameNameTxt;

    private JButton okBtn;
    private JButton cancelBtn;

    private GameRoomFrame gameRoomFrame;
    private ResourceBundle resources;
    private YahtzeeController yahtzeeController;
    private String username;

    public StartGameFrame(String title, ResourceBundle resources, GameRoomFrame gameRoomFrame, String username) {
        setFrameTitle(title);

        this.resources = resources;
        this.yahtzeeController = findYahtzeeController();
        this.gameRoomFrame = gameRoomFrame;
        this.username = username;

        makeComponents();
        makeLayout();
        addListeners();
        showFrame();
    }

    public void makeComponents() {
        titlePnl = new JPanel();
        inputPnl = new JPanel();
        buttonPnl = new JPanel();

        titleLbl = new JLabel("Start a new game:");
        gameNameLbl = new JLabel("Game Name");
        numberLbl = new JLabel("Number of Players");
        errorLbl = new JLabel();

        gameNameTxt = new JTextField();
        comboModel = new DefaultComboBoxModel();
        for (int i = 0; i < 4; i++) {
            comboModel.addElement(i + 1);
        }

        numberCombo = new JComboBox(comboModel);


        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");
    }

    public void makeLayout() {
        Container content = this.getContentPane();

        titlePnl.add(titleLbl);

        inputPnl.setLayout(new GridLayout(3, 2, 2, 2));
        inputPnl.add(gameNameLbl);
        inputPnl.add(gameNameTxt);
        inputPnl.add(numberLbl);
        inputPnl.add(numberCombo);
        inputPnl.add(errorLbl);

        buttonPnl.add(okBtn);
        buttonPnl.add(cancelBtn);

        content.add(titlePnl, BorderLayout.NORTH);
        content.add(inputPnl, BorderLayout.CENTER);
        content.add(buttonPnl, BorderLayout.SOUTH);


    }

    public void addListeners() {
        okBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
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
        if (e.getSource() == okBtn) {
            User user = null;

            try {
                user = yahtzeeController.findUser(username);

                if (yahtzeeController.createGame(gameNameTxt.getText(), numberCombo.getSelectedIndex() + 1, user)) {
                    gameRoomFrame.addGame(gameNameTxt.getText());
                    new GameFrame(gameNameTxt.getText(), resources, numberCombo.getSelectedIndex() + 1);
                    this.dispose();
                } else {
                    errorLbl.setText("U zit reeds in een game!");
                }
            } catch (RemoteException e1) {
            }
        }

        if (e.getSource() == cancelBtn) {
            gameRoomFrame.setVisible(true);
            this.dispose();
        }

    }
}

