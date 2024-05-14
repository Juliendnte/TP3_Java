package PTP_POO.PTP3.Vue;

import PTP_POO.PTP3.Model.Carte;
import PTP_POO.PTP3.Model.Paquet;


import javax.swing.*;
import java.awt.*;

public class VSwing extends JFrame {

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

        // Constantes pour les dimensions des cartes
        int LARGEUR_CARTE = 100;
        int HAUTEUR_CARTE = 150;
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

    private JPanel afficherPaquet(Paquet paquet) {
        JPanel paquetPanel = new JPanel();

        int LARGEUR_CARTE_PAQUET = 50;
        int HAUTEUR_CARTE_PAQUET = 75;

        for (Carte carte : paquet) {
            JPanel cartePanel = affichageCarte(carte.getVal(), carte.getSymbole(), LARGEUR_CARTE_PAQUET, HAUTEUR_CARTE_PAQUET);
            paquetPanel.add(cartePanel);
        }

        return paquetPanel;
    }

    public void showCarte(Carte carte){
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
