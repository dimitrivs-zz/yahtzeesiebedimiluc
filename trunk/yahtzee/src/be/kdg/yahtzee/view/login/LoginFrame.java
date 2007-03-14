/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.view.login;

import be.kdg.util.Security;
import be.kdg.yahtzee.model.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.model.remoteObjects.users.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class LoginFrame extends YahtzeeSwing implements ActionListener {
    private JLabel titleLbl;
    private JLabel usernameLbl;
    private JLabel passwordLbl;
    private JLabel errorLbl;
    private JTextField usernameTxt;
    private JPasswordField passwordTxt;
    private JButton loginBtn;
    private JButton registerBtn;

    private JPanel titlePnl;
    private JPanel inputPnl;
    private JPanel buttonPnl;
    private JPanel errorPnl;

    private ResourceBundle resources;
    private YahtzeeController yahtzeeController;

    public LoginFrame(String title, ResourceBundle resources) {
        setFrameTitle(title);

        this.resources = resources;
        this.yahtzeeController = findYahtzeeController();

        makeComponents();
        makeLayout();
        addListeners();
        showFrame();
    }

    private void makeComponents() {
        String titleString = resources.getString("login");
        String usernameString = resources.getString("userName");
        String passwordString = resources.getString("password");
        String registerString = resources.getString("registerButton");

        titleLbl = new JLabel(titleString);
        errorLbl = new JLabel();

        usernameLbl = new JLabel(usernameString);
        usernameTxt = new JTextField(10);
        passwordLbl = new JLabel(passwordString);
        passwordTxt = new JPasswordField(10);

        loginBtn = new JButton(titleString);
        registerBtn = new JButton(registerString);

        titlePnl = new JPanel();
        inputPnl = new JPanel();
        buttonPnl = new JPanel();
        errorPnl = new JPanel();
    }

    private void makeLayout() {
        Container content = this.getContentPane();

        titlePnl.add(titleLbl);
        errorPnl.add(errorLbl);

        inputPnl.setLayout(new GridLayout(2, 2, 1, 1));
        inputPnl.add(usernameLbl);
        inputPnl.add(usernameTxt);
        inputPnl.add(passwordLbl);
        inputPnl.add(passwordTxt);

        buttonPnl.add(loginBtn);
        buttonPnl.add(registerBtn);

        content.setLayout((new GridLayout(4, 1, 1, 1)));
        content.add(titlePnl);
        content.add(inputPnl);
        content.add(buttonPnl);
        content.add(errorPnl);
    }

    private void addListeners() {
        loginBtn.addActionListener(this);
        registerBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            User user = null;
            try {
                user = yahtzeeController.findUser(usernameTxt.getText());
                String password = Security.getInstance().encrypt(new String(passwordTxt.getPassword()));

                if (user != null) {
                    if (user.getPassword().equals(password) && !user.isBlocked()) {
                        yahtzeeController.setOnline(user, true);
                        new GameRoomFrame("Yahtzee GameRoom", resources, usernameTxt.getText());
                        this.dispose();
                    } else {
                        changeMessage(resources.getString("swingLoginError"));
                    }
                } else {
                    changeMessage(resources.getString("swingLoginError"));
                }
            } catch (RemoteException e1) {

            }
        }

        if (e.getSource() == registerBtn) {
            new RegisterFrame("Yahtzee Register", resources, this);
            this.setVisible(false);
        }
    }

    private void showFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        Dimension d = this.getToolkit().getScreenSize();
        setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
        pack();
        setVisible(true);
        setResizable(false);
    }

    public void changeMessage(String message) {
        errorLbl.setText(message);
    }
}
