package PTP_POO.PTP3.Vue;

import PTP_POO.PTP3.Model.MTP3_1;
import PTP_POO.PTP3.Model.Paquet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class VSwing extends JFrame {

    // Constantes pour les dimensions des cartes
    private static final int LARGEUR_CARTE = 100;
    private static final int HAUTEUR_CARTE = 150;
    private static final int LARGEUR_CARTE_PAQUET = 50;
    private static final int HAUTEUR_CARTE_PAQUET = 75;

    public VSwing(){
    }

    public VSwing(Paquet paquet) {
        setTitle("Affichage de Paquet de Cartes");
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(afficherPaquet(paquet), BorderLayout.CENTER);

        setContentPane(contentPane);
    }

    public VSwing(String valeur, String symbole) {
        setTitle("Affichage de Carte");
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel(new BorderLayout());

        JPanel cartePanel = affichageCarte(valeur, symbole, LARGEUR_CARTE, HAUTEUR_CARTE);
        contentPane.add(cartePanel, BorderLayout.NORTH);


        setContentPane(contentPane);
    }

    private JPanel affichageCarte(String valeur, String symbole, int largeur, int hauteur) {
        JPanel cartePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                int x = (getWidth() - largeur) / 2;
                int y = (getHeight() - hauteur) / 2;
                g2d.setColor(Color.WHITE);
                g2d.fillRect(x, y, largeur, hauteur);
                g2d.setColor(Color.BLACK);
                g2d.drawRect(x, y, largeur, hauteur);

                g2d.drawString(valeur, x + 10, y + 20);
                g2d.drawString(symbole, x + 10, y + 40);
            }
        };

        cartePanel.setPreferredSize(new Dimension(largeur + 10, hauteur + 10));
        return cartePanel;
    }

    // Méthode pour afficher le paquet de cartes
    private JPanel afficherPaquet(Paquet paquet) {
        JPanel paquetPanel = new JPanel();

        for (MTP3_1.Carte carte : paquet) {
            JPanel cartePanel = affichageCarte(carte.getVal(), carte.getSymbole(), LARGEUR_CARTE_PAQUET, HAUTEUR_CARTE_PAQUET);
            paquetPanel.add(cartePanel);
        }

        return paquetPanel;
    }

    public void showCarte(MTP3_1.Carte carte){
        SwingUtilities.invokeLater(() -> {
            VSwing cartesGUI = new VSwing(carte.getVal(), carte.getSymbole());
            cartesGUI.setVisible(true);
        });
    }

    public void showPaquetDeCartes(Paquet paquet) {
        SwingUtilities.invokeLater(() -> {
            VSwing cartesGUI = new VSwing(paquet);
            cartesGUI.setVisible(true);
        });
    }
}
