package PTP_POO.PTP3.Vue;

import PTP_POO.PTP3.Model.Carte;
import PTP_POO.PTP3.Model.Paquet;

import javax.swing.*;
import java.awt.*;

public class VSwing extends JFrame {

    public VSwing() {
    }

    public VSwing(Paquet paquet) {
        setTitle("Affichage de Paquet de Cartes");
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Change to DISPOSE_ON_CLOSE
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(affichagePaquet(paquet), BorderLayout.CENTER);

        setContentPane(contentPane);
    }

    public VSwing(Carte carte) {
        setTitle("Affichage de Carte");
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Change to DISPOSE_ON_CLOSE
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel(new BorderLayout());

        JPanel cartePanel = affichageCarte(carte.getVal(), carte.getSymbole(), 100, 150);
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
                g2d.drawString(symbole, x + 10, y + 35);

                g2d.drawString(symbole, x + largeur - 20, y + hauteur - 20);
                g2d.drawString(valeur, x + largeur - 20, y + hauteur - 5);
            }
        };

        cartePanel.setPreferredSize(new Dimension(largeur + 10, hauteur + 10));
        return cartePanel;
    }

    private JPanel affichagePaquet(Paquet paquet) {
        JPanel paquetPanel = new JPanel();

        for (Carte carte : paquet) {
            JPanel cartePanel = affichageCarte(carte.getVal(), carte.getSymbole(), 50, 75);
            paquetPanel.add(cartePanel);
        }

        return paquetPanel;
    }

    public void showCarte(Carte carte) {
        SwingUtilities.invokeLater(() -> {
            VSwing cartesGUI = new VSwing(carte);
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
