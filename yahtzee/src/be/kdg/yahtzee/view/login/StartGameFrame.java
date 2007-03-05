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

    private JLabel titleLbl;
    private JLabel gameNameLbl;
    private JLabel numberLbl;
    private JComboBox numberCombo;
    private DefaultComboBoxModel comboModel;
    private JTextField gameNameTxt;

    private JButton okBtn;
    private JButton cancelBtn;

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

        titleLbl = new JLabel("Start a new game:");
        gameNameLbl = new JLabel("Game Name");
        numberLbl = new JLabel("Number of Players");

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

        inputPnl.setLayout(new GridLayout(2, 2, 2, 2));
        inputPnl.add(gameNameLbl);
        inputPnl.add(gameNameTxt);
        inputPnl.add(numberLbl);
        inputPnl.add(numberCombo);

        buttonPnl.add(okBtn);
        buttonPnl.add(cancelBtn);

        content.add(titlePnl, BorderLayout.NORTH);
        content.add(inputPnl, BorderLayout.CENTER);
        content.add(buttonPnl, BorderLayout.SOUTH);


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
