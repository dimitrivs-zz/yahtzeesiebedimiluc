package be.kdg.yahtzee.view.register;

import be.kdg.yahtzee.model.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.model.remoteObjects.users.Address;
import be.kdg.yahtzee.view.YahtzeeSwing;
import be.kdg.yahtzee.view.login.LoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class RegisterFrame extends YahtzeeSwing implements ActionListener {
    private JLabel usernameLbl;
    private JLabel passwordLbl;
    private JLabel repeatPasswordLbl;
    private JLabel mailLbl;
    private JLabel firstnameLbl;
    private JLabel surnameLbl;
    private JLabel telephoneLbl;
    private JLabel streetLbl;
    private JLabel numberLbl;
    private JLabel zipLbl;
    private JLabel cityLbl;
    private JLabel countryLbl;
    private JLabel languageLbl;
    private JLabel titleLbl;
    private JLabel errorLbl;
    private JTextField usernameTxt;
    private JTextField mailTxt;
    private JTextField firstnameTxt;
    private JTextField surnameTxt;
    private JTextField telephoneTxt;
    private JTextField streetTxt;
    private JTextField numberTxt;
    private JTextField zipTxt;
    private JTextField cityTxt;
    private JTextField countryTxt;
    private JPasswordField passwordTxt;
    private JPasswordField repeatPasswordTxt;
    private JList languageLst;
    private JButton registerButton;
    private JButton cancelButton;
    private LoginFrame loginFrame;

    private JPanel titlePnl;
    private JPanel inputPnl;
    private JPanel buttonPnl;

    private ResourceBundle resources;
    private YahtzeeController yahtzeeController;

    public RegisterFrame(String title, ResourceBundle resources, LoginFrame loginFrame) {
        setFrameTitle(title);

        this.resources = resources;
        this.yahtzeeController = findYahtzeeController();

        this.loginFrame = loginFrame;
        makeComponents();
        makeLayout();
        addListeners();
        showFrame();
    }

    public void makeComponents() {
        String titleString = resources.getString("registerTitle");
        String usernameString = resources.getString("userName");
        String passwordString = resources.getString("password");
        String repeatPasswordString = resources.getString("repeatPassword");
        String mailString = resources.getString("mail");
        String firstnameString = resources.getString("firstname");
        String surnameString = resources.getString("surname");
        String telephoneString = resources.getString("telephone");
        String streetString = resources.getString("street");
        String numberString = resources.getString("number");
        String zipString = resources.getString("zip");
        String cityString = resources.getString("city");
        String countryString = resources.getString("country");
        String languageString = resources.getString("language");
        String cancelString = resources.getString("cancel");
        String registerString = resources.getString("registerButton");

        errorLbl = new JLabel();
        titleLbl = new JLabel(titleString);
        usernameLbl = new JLabel(usernameString);
        passwordLbl = new JLabel(passwordString);
        repeatPasswordLbl = new JLabel(repeatPasswordString);
        mailLbl = new JLabel(mailString);
        firstnameLbl = new JLabel(firstnameString);
        surnameLbl = new JLabel(surnameString);
        telephoneLbl = new JLabel(telephoneString);
        streetLbl = new JLabel(streetString);
        numberLbl = new JLabel(numberString);
        zipLbl = new JLabel(zipString);
        cityLbl = new JLabel(cityString);
        countryLbl = new JLabel(countryString);
        languageLbl = new JLabel(languageString);
        usernameTxt = new JTextField();
        mailTxt = new JTextField();
        firstnameTxt = new JTextField();
        surnameTxt = new JTextField();
        telephoneTxt = new JTextField();
        streetTxt = new JTextField();
        numberTxt = new JTextField();
        zipTxt = new JTextField();
        cityTxt = new JTextField();
        countryTxt = new JTextField();
        languageLst = new JList();
        passwordTxt = new JPasswordField();
        repeatPasswordTxt = new JPasswordField();
        registerButton = new JButton(registerString);
        cancelButton = new JButton(cancelString);

        titlePnl = new JPanel();
        inputPnl = new JPanel();
        buttonPnl = new JPanel();
    }

    public void makeLayout() {
        Container content = this.getContentPane();
        titlePnl.setLayout(new FlowLayout());
        titlePnl.add(titleLbl);

        inputPnl.setLayout(new GridLayout(14, 2, 2, 2));
        inputPnl.add(usernameLbl);
        inputPnl.add(usernameTxt);
        inputPnl.add(passwordLbl);
        inputPnl.add(passwordTxt);
        inputPnl.add(repeatPasswordLbl);
        inputPnl.add(repeatPasswordTxt);
        inputPnl.add(firstnameLbl);
        inputPnl.add(firstnameTxt);
        inputPnl.add(surnameLbl);
        inputPnl.add(surnameTxt);
        inputPnl.add(mailLbl);
        inputPnl.add(mailTxt);
        inputPnl.add(telephoneLbl);
        inputPnl.add(telephoneTxt);
        inputPnl.add(streetLbl);
        inputPnl.add(streetTxt);
        inputPnl.add(numberLbl);
        inputPnl.add(numberTxt);
        inputPnl.add(cityLbl);
        inputPnl.add(cityTxt);
        inputPnl.add(zipLbl);
        inputPnl.add(zipTxt);
        inputPnl.add(countryLbl);
        inputPnl.add(countryTxt);
        inputPnl.add(languageLbl);
        inputPnl.add(languageLst);
        inputPnl.add(errorLbl);

        buttonPnl.setLayout(new FlowLayout());
        buttonPnl.add(registerButton);
        buttonPnl.add(cancelButton);

        content.add(titlePnl, BorderLayout.NORTH);
        content.add(inputPnl, BorderLayout.CENTER);
        content.add(buttonPnl, BorderLayout.SOUTH);
    }

    public void addListeners() {
        registerButton.addActionListener(this);
        cancelButton.addActionListener(this);
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
        if (e.getSource() == registerButton) {
            String password1 = new String(passwordTxt.getPassword());
            String password2 = new String(repeatPasswordTxt.getPassword());

            if (usernameTxt.getText().equals("") || password1.equals("") || password2.equals("") || mailTxt.getText().equals("")) {
                errorLbl.setText("Parameters not found in request");
            } else {
                if (!password1.equals(password2)) {
                    errorLbl.setText("Passwords Mismatch");
                } else {
                    Address address = new Address(streetTxt.getText(), numberTxt.getText(), zipTxt.getText(), cityTxt.getText(), countryTxt.getText());

                    try {
                        yahtzeeController.createPlayer(usernameTxt.getText(), password1, surnameTxt.getText(), firstnameTxt.getText(), mailTxt.getText(), telephoneTxt.getText(), address);
                    } catch (RemoteException e1) {
                    }

                    loginFrame.changeMessage("Registratie voltooid");
                    loginFrame.setVisible(true);
                    this.dispose();
                }
            }
        }

        if (e.getSource() == cancelButton) {
            loginFrame.changeMessage("");
            loginFrame.setVisible(true);
            this.dispose();
        }

    }
}
