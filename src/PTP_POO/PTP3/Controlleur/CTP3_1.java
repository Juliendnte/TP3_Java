package PTP_POO.PTP3.Controlleur;

import PTP_POO.PTP3.Model.Carte;
import PTP_POO.PTP3.Model.Paquet;
import PTP_POO.PTP3.Vue.VSwing;
import PTools.tools;

import java.util.ArrayList;

import static PTP_POO.PTP3.Vue.VTP3_1.CreateCarte;

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
        String[] params = CreateCarte();
        Carte carte;
        try {
            carte = new Carte(params[0], params[1]);
        }catch (IllegalArgumentException e){
            System.err.println("Erreur -> "+ e);
            execute();
            return;
        }

        System.out.println(carte);
        v_mod.showCarte(carte);

        Paquet paquet = new Paquet(new ArrayList<>());

        while (true){
             switch (tools.AskInt("Voulez-vous ajouter une carte dans votre paquet(1) Ou montrer votre paquet(2) ")){
                 case 1 -> {
                     params = CreateCarte();
                     paquet.add(new Carte(params[0], params[1]));
                 }
                 case 2-> v_mod.showPaquetDeCartes(paquet);

                 default -> {
                     return;
                 }
             }
        }
    }
}
