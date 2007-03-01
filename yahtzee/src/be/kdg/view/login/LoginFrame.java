/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.view.login;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

public class LoginFrame extends JFrame {
    private JLabel titleLbl;
    private JLabel usernameLbl;
    private JLabel passwordLbl;
    private JTextField usernameTxt;
    private JPasswordField passwordTxt;
    private JButton loginBtn;
    private JButton registerBtn;

    private JPanel titlePnl;
    private JPanel inputPnl;
    private JPanel buttonPnl;

    private ResourceBundle resources;

    public LoginFrame(String title) {
        super(title);

        resources = ResourceBundle.getBundle("bundles.resources");

        makeComponents();
        makeLayout();
        addListeners();
        showFrame();
    }

    private void makeComponents() {
        String titleString = resources.getString("login");
        String usernameString = resources.getString("userName");
        String passwordString = resources.getString("password");
        String registerString = resources.getString("loginRegister");

        titleLbl = new JLabel(titleString);

        usernameLbl = new JLabel(usernameString);
        usernameTxt = new JTextField(10);
        passwordLbl = new JLabel(passwordString);
        passwordTxt = new JPasswordField(10);

        loginBtn = new JButton(titleString);
        registerBtn = new JButton(registerString);

        titlePnl = new JPanel();
        inputPnl = new JPanel();
        buttonPnl = new JPanel();
    }

    private void makeLayout() {
        Container content = this.getContentPane();

        titlePnl.add(titleLbl);

        inputPnl.setLayout(new GridLayout(2, 2, 1, 1));
        inputPnl.add(usernameLbl);
        inputPnl.add(usernameTxt);
        inputPnl.add(passwordLbl);
        inputPnl.add(passwordTxt);

        buttonPnl.add(loginBtn);
        buttonPnl.add(registerBtn);

        content.add(titlePnl, BorderLayout.NORTH);
        content.add(inputPnl, BorderLayout.CENTER);
        content.add(buttonPnl, BorderLayout.SOUTH);
    }

    private void addListeners() {

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

}
