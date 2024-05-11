package PTP_POO.PTP3.Vue;

import PTools.tools;

public class VTP3_1 {

    public String[] CreateCarte(){
        return new String[]{tools.AskString(""), tools.AskString("")};
    }

    public void afficherCarte(String valeur, String couleur) {
        System.out.println(" _______ ");
        System.out.println("|       |");
        System.out.println("|  " + valeur + "    |");
        System.out.println("|  / \\  |");
        System.out.println("| ( " + couleur + " ) |");
        System.out.println("|  \\ /  |");
        System.out.println("|   " + valeur + "   |");
        System.out.println("|_______|");
    }
}
