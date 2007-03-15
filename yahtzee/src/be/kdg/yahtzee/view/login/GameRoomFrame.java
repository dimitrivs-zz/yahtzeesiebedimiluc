/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.view.login;

import be.kdg.yahtzee.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.remoteObjects.game.Game;
import be.kdg.yahtzee.remoteObjects.users.User;
import be.kdg.yahtzee.view.game.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class GameRoomFrame extends YahtzeeSwing implements ActionListener {
    private JLabel titletableLbl;
    private JList gameList;
    private DefaultListModel listModel;
    private JButton startBtn;
    private JButton joinBtn;
    private JButton profileBtn;
    private JButton logoutBtn;

    private JPanel titlePnl;
    private JScrollPane gamePane;
    private JPanel gameSummaryPnl;
    private JPanel buttonPnl;

    private ResourceBundle resources;
    private YahtzeeController yahtzeeController;
    private String username;

    public GameRoomFrame(String title, ResourceBundle resources, String username) {
        setFrameTitle(title);

        this.resources = resources;
        this.username = username;
        this.yahtzeeController = findYahtzeeController();

        makeComponents();
        makeLayout();
        fillGameList();
        addListeners();
        showFrame();
    }

    private void makeComponents() {
        String titletableString = resources.getString("roomTitle");
        String startString = resources.getString("roomStart");
        String joinString = resources.getString("roomJoin");
        String profileString = resources.getString("roomProfile");
        String logoutString = resources.getString("logout");

        titletableLbl = new JLabel(titletableString);
        startBtn = new JButton(startString);
        joinBtn = new JButton(joinString);
        profileBtn = new JButton(profileString);
        logoutBtn = new JButton(logoutString);

        listModel = new DefaultListModel();
        gameList = new JList(listModel);

        titlePnl = new JPanel();
        gamePane = new JScrollPane(gameList);
        gameSummaryPnl = new JPanel();
        buttonPnl = new JPanel();
    }

    private void makeLayout() {
        Container content = this.getContentPane();

        titlePnl.add(titletableLbl);

        buttonPnl.setLayout(new GridLayout(4, 1, 3, 3));
        buttonPnl.add(startBtn);
        buttonPnl.add(joinBtn);
        buttonPnl.add(profileBtn);
        buttonPnl.add(logoutBtn);

        gameSummaryPnl.add(gamePane, BorderLayout.CENTER);
        gameSummaryPnl.add(buttonPnl, BorderLayout.EAST);

        content.add(titlePnl, BorderLayout.NORTH);
        content.add(gameSummaryPnl, BorderLayout.CENTER);
    }

    private void fillGameList() {
        try {
            java.lang.Object[] games = yahtzeeController.getGames();

            for (int i = 0; i < games.length; i++) {
                Game game = (Game) games[i];
                listModel.addElement(game);
            }
        } catch (RemoteException e) {
        }
    }

    private void addListeners() {
        startBtn.addActionListener(this);
        joinBtn.addActionListener(this);
        profileBtn.addActionListener(this);
        logoutBtn.addActionListener(this);
    }

    private void showFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        Dimension d = this.getToolkit().getScreenSize();
        setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
        pack();
        setVisible(true);
        setResizable(false);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startBtn) {
            new StartGameFrame("Yahtzee Game", resources, this, username);
            this.setVisible(false);
        }

        if (e.getSource() == joinBtn) {
            User user = null;
            Game game = null;

            try {
                user = yahtzeeController.findUser(username);
                game = (Game) gameList.getSelectedValue();

                if (!yahtzeeController.joinGame(game.getGameName(), user)) {

                } else {
                    new GameFrame(game.getGameName(), resources, game.getMaxPlayer());
                    this.dispose();
                }
            } catch (RemoteException e1) {
            }
        }

        if (e.getSource() == profileBtn) {
            new ChangeProfileFrame("Yahtzee Profile", resources, this, username);
            this.setVisible(false);
        }

        if (e.getSource() == logoutBtn) {
            new LoginFrame("Yahtzee", resources);
            this.dispose();
        }
    }

    protected void addGame(String gamename) {
        Game game = null;

        try {
            game = yahtzeeController.getGame(gamename);
        } catch (RemoteException e) {
        }

        listModel.addElement(game);
    }
}
