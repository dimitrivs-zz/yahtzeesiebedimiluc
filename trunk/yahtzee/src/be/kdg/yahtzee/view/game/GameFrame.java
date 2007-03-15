package be.kdg.yahtzee.view.game;

import be.kdg.yahtzee.view.bundles.ChooseLanguageFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class GameFrame extends JFrame implements ActionListener {
    private JPanel titlePnl;
    private JPanel dicePnl;
    private JPanel scorePnl;
    private JPanel buttonPnl;

    private JLabel titleLbl;
    private JToggleButton dice1Btn;
    private JToggleButton dice2Btn;
    private JToggleButton dice3Btn;
    private JToggleButton dice4Btn;
    private JToggleButton dice5Btn;
    private JTable scoreTbl;
    private JButton startBtn;
    private JButton rollBtn;
    private JButton leaveBtn;

    private ResourceBundle resources;

    public GameFrame(String title, ResourceBundle resources, int players) {
        super(title);
        this.resources = resources;

        makeComponents(players);
        makeLayout();
        addListeners();
        showFrame();
    }

    public void makeComponents(int players) {
        titlePnl = new JPanel();
        dicePnl = new JPanel();
        scorePnl = new JPanel();
        buttonPnl = new JPanel();

        titleLbl = new JLabel("YAHTZEE");

        ImageIcon die1 = createImageIcon("../images/die1.png");
        ImageIcon die2 = createImageIcon("../images/die2.png");
        ImageIcon die3 = createImageIcon("../images/die3.png");
        ImageIcon die4 = createImageIcon("../images/die4.png");
        ImageIcon die5 = createImageIcon("../images/die5.png");
        ImageIcon die6 = createImageIcon("../images/die6.png");

        dice1Btn = new JToggleButton(die1);
        dice2Btn = new JToggleButton(die2);
        dice3Btn = new JToggleButton(die3);
        dice4Btn = new JToggleButton(die4);
        dice5Btn = new JToggleButton(die5);

        scoreTbl = new JTable(15, players + 1);
        String stringStart = resources.getString("gameStart");
        String stringRoll = resources.getString("gameRoll");
        String stringLeave = resources.getString("gameLeave");
        startBtn = new JButton(stringStart);
        rollBtn = new JButton(stringRoll);
        rollBtn.setEnabled(false);
        leaveBtn = new JButton(stringLeave);
    }

    public void makeLayout() {

        Container content = this.getContentPane();

        titlePnl.add(titleLbl);

        dicePnl.setLayout(new GridLayout(5, 1, 3, 3));
        dicePnl.add(dice1Btn);
        dicePnl.add(dice2Btn);
        dicePnl.add(dice3Btn);
        dicePnl.add(dice4Btn);
        dicePnl.add(dice5Btn);

        scorePnl.add(scoreTbl);

        buttonPnl.setLayout(new GridLayout(3, 1, 3, 3));
        buttonPnl.add(startBtn);
        buttonPnl.add(rollBtn);
        buttonPnl.add(leaveBtn);

        content.add(titlePnl, BorderLayout.NORTH);
        content.add(dicePnl, BorderLayout.WEST);
        content.add(scorePnl, BorderLayout.CENTER);
        content.add(buttonPnl, BorderLayout.EAST);
    }

    public void addListeners() {
        startBtn.addActionListener(this);
        rollBtn.addActionListener(this);
        leaveBtn.addActionListener(this);
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
        if (e.getSource() == startBtn) {
            startBtn.setEnabled(false);
            rollBtn.setEnabled(true);
        }

        if (e.getSource() == rollBtn) {

        }

        if (e.getSource() == leaveBtn) {
            this.dispose();
        }
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ChooseLanguageFrame.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
