package PTP_POO.PTP3.Controlleur;

import PTP_POO.PTP3.Model.MTP3_1;
import PTP_POO.PTP3.Model.Paquet;
import PTP_POO.PTP3.Vue.VSwing;

import java.util.ArrayList;

public class CTP3_1 implements IControlleur {
    private final MTP3_1 m_mod;
    private final VSwing v_mod;


    public static void main(String[] args) {
        execute();
    }

    public static void execute(){
        new CTP3_1(new MTP3_1(),new VSwing()).lancer();
    }
    public CTP3_1(MTP3_1 mMod, VSwing vMod) {
        this.m_mod = mMod;
        this.v_mod = vMod;
    }

    @Override
    public void lancer(){
        MTP3_1.Carte carte = this.m_mod.new Carte("10", "pique");


        System.out.println(carte);

        MTP3_1.Carte carte2 = this.m_mod.new Carte(carte);

        carte2.setVal("9");
        carte2.setCouleur("carreau");

        System.out.println(carte2);

        v_mod.showCarte(carte);

        Paquet paquet = new Paquet(new ArrayList<>());

        paquet.add(carte);
        paquet.add(carte2);

        v_mod.showPaquetDeCartes(paquet);
    }
}
