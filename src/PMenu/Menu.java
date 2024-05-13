package PMenu;

import PTools.tools;
import PTP_POO.PTP3.Controlleur.*;

public class Menu {
    public static void main(String[] args) {
        execute();
    }

    public static void execute(){
        while (true){
            try {
                switch (tools.AskString("Quels TP voulez-vous essayer?\n1-TP.31\n2-TP.32\nq.quitter\n")){
                    case "1" -> CTP3_1.execute();

                    case "q","Q" -> {
                        return;
                    }
                    default -> System.out.println("Résultat inconnue");
                }
            }catch (Exception e){
                System.out.flush();
                System.err.println("Erreur trouvé => "+ e);
            }
        }
    }
}
