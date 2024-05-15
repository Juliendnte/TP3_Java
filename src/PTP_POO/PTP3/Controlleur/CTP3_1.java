package PTP_POO.PTP3.Controlleur;

import PTP_POO.PTP3.Model.Carte;
import PTP_POO.PTP3.Model.Paquet;
import PTP_POO.PTP3.Vue.VSwing;
import PTools.tools;

import java.util.ArrayList;


public class CTP3_1 implements IControlleur {
    private final VSwing v_mod;


    public static void main(String[] args) {
        execute();
    }

    public static void execute(){
        new CTP3_1(new VSwing()).lancer();
    }
    public CTP3_1( VSwing vMod) {
        this.v_mod = vMod;
    }

    @Override
    public void lancer(){
        String[] params;
        Carte carte;
        Paquet paquet = new Paquet(new ArrayList<>());
        while (true) {
            switch (tools.AskInt("Choisissez une action: \n1. Ajouter une carte\n2. Afficher une carte\n3. Afficher le paquet de cartes\n4. Quitter\n")) {
                case 1 -> {
                    try {
                        tools.AskString("");
                        params = new String[]{tools.AskString("Entrez la valeur de la carte (1, 2, ..., 10, J, Q, K, A): "), tools.AskString("Entrez la couleur de la carte (pique, carreau, trefle, coeur): ")};
                        carte = new Carte(params[0], params[1]);
                        paquet.add(carte);
                    }catch (IllegalArgumentException err){
                        System.out.println("erreur : "+ err);
                    }
                }
                case 2 -> {
                    try {
                        tools.AskString("");
                        params =  new String[]{tools.AskString("Entrez la valeur de la carte (1, 2, ..., 10, J, Q, K, A): "), tools.AskString("Entrez la couleur de la carte (pique, carreau, trefle, coeur): ")};
                        carte = new Carte(params[0], params[1]);
                        v_mod.showCarte(carte);
                    }catch (IllegalArgumentException err){
                        System.out.println("erreur : "+ err);
                    }
                }
                case 3 -> v_mod.showPaquetDeCartes(paquet);
                case 4 -> {
                    return;
                }
                default -> System.out.println("Choix invalide.");
            }
        }
    }
}
