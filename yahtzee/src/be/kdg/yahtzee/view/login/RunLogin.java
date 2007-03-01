package be.kdg.yahtzee.view.login;

import javax.swing.*;

public class RunLogin {
    public static void main(String[] args) {

        try {

            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

        } catch (Exception e) {
            //foutjes opvangen
        }

        new ChooseLanguageFrame("Yahtzee");
    }
}
