/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.view.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class ChooseLanguageFrame extends YahtzeeSwing implements ActionListener {
    private JButton dutchBtn;
    private JButton frenchBtn;
    private JButton germanBtn;
    private JButton englishBtn;
    private JButton spanishBtn;

    private JLabel titleLbl;
    private JPanel overviewPnl;

    private ResourceBundle resources;


    public ChooseLanguageFrame(String title) {
        setFrameTitle(title);

        makeComponents();
        makeLayout();
        addListeners();
        showFrame();
    }

    private void makeComponents() {

        ImageIcon dutchFlag = createImageIcon("images/netherlands.gif");
        ImageIcon frenchFlag = createImageIcon("images/france.gif");
        ImageIcon ukFlag = createImageIcon("images/UnitedKingdom.gif");
        ImageIcon germanFlag = createImageIcon("images/germany.gif");
        ImageIcon spanishFlag = createImageIcon("images/spain.gif");

        dutchBtn = new JButton("Nederlands", dutchFlag);
        dutchBtn.setHorizontalAlignment(SwingConstants.LEFT);
        frenchBtn = new JButton("Français", frenchFlag);
        frenchBtn.setHorizontalAlignment(SwingConstants.LEFT);
        englishBtn = new JButton("English", ukFlag);
        englishBtn.setHorizontalAlignment(SwingConstants.LEFT);
        spanishBtn = new JButton("Espanõl", spanishFlag);
        spanishBtn.setHorizontalAlignment(SwingConstants.LEFT);
        germanBtn = new JButton("Deutsch", germanFlag);
        germanBtn.setHorizontalAlignment(SwingConstants.LEFT);

        titleLbl = new JLabel("Choose your language...");

        overviewPnl = new JPanel();
    }

    private void makeLayout() {
        Container content = this.getContentPane();

        overviewPnl.setLayout(new GridLayout(6, 1, 5, 5));

        overviewPnl.add(titleLbl);
        overviewPnl.add(dutchBtn);
        overviewPnl.add(frenchBtn);
        overviewPnl.add(englishBtn);
        overviewPnl.add(germanBtn);
        overviewPnl.add(spanishBtn);
        content.add(new JLabel("Welcome to YAHTZEE"), BorderLayout.NORTH);
        content.add(overviewPnl, BorderLayout.CENTER);
    }

    private void addListeners() {
        dutchBtn.addActionListener(this);
        frenchBtn.addActionListener(this);
        englishBtn.addActionListener(this);
        spanishBtn.addActionListener(this);
        germanBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dutchBtn) {
            resources =
                    ResourceBundle.getBundle("bundles.resources_nl");
        }
        if (e.getSource() == frenchBtn) {
            resources =
                    ResourceBundle.getBundle("bundles.resources_fr");
        }
        if (e.getSource() == germanBtn) {
            resources =
                    ResourceBundle.getBundle("bundles.resources_de");
        }
        if (e.getSource() == englishBtn) {
            resources =
                    ResourceBundle.getBundle("bundles.resources_en");
        }
        if (e.getSource() == spanishBtn) {
            resources =
                    ResourceBundle.getBundle("bundles.resources_es");
        }

        new LoginFrame("Yahtzee Login", resources);
        this.dispose();
    }


    private void showFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(150, 200);
        Dimension d = this.getToolkit().getScreenSize();
        setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
        setVisible(true);
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
