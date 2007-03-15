/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.view.player;

import be.kdg.util.InputValidation;
import be.kdg.yahtzee.model.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.model.remoteObjects.users.Address;
import be.kdg.yahtzee.model.remoteObjects.users.Role;
import be.kdg.yahtzee.model.remoteObjects.users.User;
import be.kdg.yahtzee.view.YahtzeeSwing;
import be.kdg.yahtzee.view.game.GameRoomFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class ChangeProfileFrame extends YahtzeeSwing implements ActionListener {
    private JLabel usernameLbl;
    private JLabel orgPasswordLbl;
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
    private JLabel titleLbl;
    private JLabel errorLbl;
    private JLabel usernameTxt;
    private JTextField mailTxt;
    private JTextField firstnameTxt;
    private JTextField surnameTxt;
    private JTextField telephoneTxt;
    private JTextField streetTxt;
    private JTextField numberTxt;
    private JTextField zipTxt;
    private JTextField cityTxt;
    private JTextField countryTxt;
    private JPasswordField orgPasswordTxt;
    private JPasswordField passwordTxt;
    private JPasswordField repeatPasswordTxt;
    private JButton changePasswordBtn;
    private JButton okButton;
    private JButton cancelButton;

    private JPanel titlePnl;
    private JPanel inputPasswordPnl;
    private JPanel inputProfilePnl;
    private JPanel inputPnl;

    private GameRoomFrame gameRoomFrame;
    private ResourceBundle resources;
    private YahtzeeController yahtzeeController;
    private String username;
    private User user;

    public ChangeProfileFrame(String title, ResourceBundle resources, GameRoomFrame gameRoomFrame, String username) {
        setFrameTitle(title);

        this.resources = resources;
        this.yahtzeeController = findYahtzeeController();
        this.gameRoomFrame = gameRoomFrame;
        this.username = username;

        makeComponents();
        makeLayout();
        fillFields();
        addListeners();
        showFrame();
    }

    public void makeComponents() {
        String titleString = resources.getString("registerTitle");
        String usernameString = resources.getString("userName");
        String orgPasswordString = resources.getString("profileOldPw");
        String passwordString = resources.getString("profileNewPw");
        String repeatPasswordString = resources.getString("profileRePw");
        String mailString = resources.getString("mail");
        String firstnameString = resources.getString("firstname");
        String surnameString = resources.getString("surname");
        String telephoneString = resources.getString("telephone");
        String streetString = resources.getString("street");
        String numberString = resources.getString("number");
        String zipString = resources.getString("zip");
        String cityString = resources.getString("city");
        String countryString = resources.getString("country");
        String cancelString = resources.getString("cancel");
        String okString = resources.getString("profileTitle");
        String changePassString = resources.getString("profilePw");

        errorLbl = new JLabel();
        titleLbl = new JLabel(titleString);
        usernameLbl = new JLabel(usernameString);
        orgPasswordLbl = new JLabel(orgPasswordString);
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
        usernameTxt = new JLabel();
        mailTxt = new JTextField();
        firstnameTxt = new JTextField();
        surnameTxt = new JTextField();
        telephoneTxt = new JTextField();
        streetTxt = new JTextField();
        numberTxt = new JTextField();
        zipTxt = new JTextField();
        cityTxt = new JTextField();
        countryTxt = new JTextField();
        orgPasswordTxt = new JPasswordField();
        passwordTxt = new JPasswordField();
        repeatPasswordTxt = new JPasswordField();
        changePasswordBtn = new JButton(changePassString);
        okButton = new JButton(okString);
        cancelButton = new JButton(cancelString);

        titlePnl = new JPanel();
        inputPasswordPnl = new JPanel();
        inputProfilePnl = new JPanel();
        inputPnl = new JPanel();
    }

    public void makeLayout() {
        Container content = this.getContentPane();
        titlePnl.setLayout(new FlowLayout());
        titlePnl.add(titleLbl);

        inputPasswordPnl.setLayout(new GridLayout(5, 2, 2, 2));
        inputPasswordPnl.add(usernameLbl);
        inputPasswordPnl.add(usernameTxt);
        inputPasswordPnl.add(orgPasswordLbl);
        inputPasswordPnl.add(orgPasswordTxt);
        inputPasswordPnl.add(passwordLbl);
        inputPasswordPnl.add(passwordTxt);
        inputPasswordPnl.add(repeatPasswordLbl);
        inputPasswordPnl.add(repeatPasswordTxt);
        inputPasswordPnl.add(changePasswordBtn);

        inputProfilePnl.setLayout(new GridLayout(11, 2, 2, 2));
        inputProfilePnl.add(firstnameLbl);
        inputProfilePnl.add(firstnameTxt);
        inputProfilePnl.add(surnameLbl);
        inputProfilePnl.add(surnameTxt);
        inputProfilePnl.add(mailLbl);
        inputProfilePnl.add(mailTxt);
        inputProfilePnl.add(telephoneLbl);
        inputProfilePnl.add(telephoneTxt);
        inputProfilePnl.add(streetLbl);
        inputProfilePnl.add(streetTxt);
        inputProfilePnl.add(numberLbl);
        inputProfilePnl.add(numberTxt);
        inputProfilePnl.add(cityLbl);
        inputProfilePnl.add(cityTxt);
        inputProfilePnl.add(zipLbl);
        inputProfilePnl.add(zipTxt);
        inputProfilePnl.add(countryLbl);
        inputProfilePnl.add(countryTxt);
        inputProfilePnl.add(errorLbl);
        inputProfilePnl.add(new JLabel());
        inputProfilePnl.add(okButton);
        inputProfilePnl.add(cancelButton);

        inputPnl.add(inputPasswordPnl);
        inputPnl.add(inputProfilePnl);

        content.add(titlePnl, BorderLayout.NORTH);
        content.add(inputPnl, BorderLayout.CENTER);
    }

    private void fillFields() {

        try {
            user = yahtzeeController.findUser(username);
        } catch (RemoteException e) {

        }

        usernameTxt.setText(user.getUsername());

        firstnameTxt.setText(user.getFirstname());
        surnameTxt.setText(user.getSurname());
        mailTxt.setText(user.getPerson().getEmail());
        telephoneTxt.setText(user.getTelephone());
        streetTxt.setText(user.getAddress().getStreet());
        numberTxt.setText(user.getAddress().getNumber());
        cityTxt.setText(user.getAddress().getCity());
        zipTxt.setText(user.getAddress().getZip());
        countryTxt.setText(user.getAddress().getCountry());
    }

    public void addListeners() {
        changePasswordBtn.addActionListener(this);
        okButton.addActionListener(this);
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
        errorLbl.setText("");

        if (e.getSource() == okButton) {
            try {
                if (InputValidation.getInstance().isInputValid(usernameTxt.getText(), mailTxt.getText(), surnameTxt.getText(), firstnameTxt.getText(), telephoneTxt.getText(), streetTxt.getText(), numberTxt.getText(), zipTxt.getText(), cityTxt.getText(), countryTxt.getText()) && InputValidation.getInstance().isNumberValid(streetTxt.getText(), numberTxt.getText())) {
                    errorLbl.setText("Wrong Input");
                } else {
                    Address address = new Address(streetTxt.getText(), numberTxt.getText(), zipTxt.getText(), cityTxt.getText(), countryTxt.getText());
                    YahtzeeController yahtzeeController = findYahtzeeController();

                    user = yahtzeeController.findUser(usernameTxt.getText());

                    Role role = user.getRole();
                    yahtzeeController.changeUser(user, surnameTxt.getText(), firstnameTxt.getText(), mailTxt.getText(), telephoneTxt.getText(), address, role);
                    errorLbl.setText("User Changed");
                }
            } catch (RemoteException e1) {
            }
        }

        if (e.getSource() == changePasswordBtn) {
            String orgPassword = new String(orgPasswordTxt.getPassword());
            String password1 = new String(passwordTxt.getPassword());
            String password2 = new String(repeatPasswordTxt.getPassword());

            try {
                if (!InputValidation.getInstance().isInputValid(usernameTxt.getText(), orgPassword, password1, password2)) {
                    errorLbl.setText("Password Mismatch");
                } else {
                    user = yahtzeeController.findUser(usernameTxt.getText());

                    if (!yahtzeeController.changePassWord(user, orgPassword, password1, password2)) {
                        errorLbl.setText("Password Mismatch");
                    } else {
                        errorLbl.setText("Password Changed");
                    }
                }

                orgPasswordTxt.setText("");
                passwordTxt.setText("");
                repeatPasswordTxt.setText("");
            } catch (RemoteException e1) {
            }
        }

        if (e.getSource() == cancelButton) {
            gameRoomFrame.setVisible(true);
            this.dispose();
        }
    }

}
