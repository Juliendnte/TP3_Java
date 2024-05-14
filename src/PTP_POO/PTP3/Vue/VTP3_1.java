package PTP_POO.PTP3.Vue;

import PTools.tools;

public class VTP3_1 {
    public static String[] CreateCarte(){
        return new String[]{tools.AskString("Saisissez la valeur de la carte"), tools.AskString("Saisissez la couleur de la carte")};
    }
}
