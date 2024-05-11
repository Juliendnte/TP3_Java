package PTP_POO.PTP3.Controlleur;

import PTP_POO.PTP3.Model.MTP3_1;
import PTP_POO.PTP3.Vue.VTP3_1;
import PTools.tools;

public class CTP3_1 implements IControlleur {
    private final MTP3_1 m_mod;
    private final VTP3_1 v_mod;


    public static void main(String[] args) {
        execute();
    }

    public static void execute(){
        new CTP3_1(new MTP3_1(),new VTP3_1()).lancer();
    }
    public CTP3_1(MTP3_1 mMod, VTP3_1 vMod) {
        this.m_mod = mMod;
        this.v_mod = vMod;
    }

    @Override
    public void lancer(){
        String[] params = this.v_mod.CreateCarte();
        MTP3_1.Carte carte;
        try {
            carte = this.m_mod.new Carte(params[0], params[1]);
        }catch (IllegalArgumentException e){
            System.err.println("Erreur -> "+ e);
            execute();
            return;
        }
        while (true){
            try {
                switch (tools.AskInt("Quel test voulez-vous réaliser ?\n1-Afficher dans un message de ma carte\n2-Afficher la carte\n3-Changer de carte\n4-Changer de valeur \n5-Changer de couleur\n7-Pour quitter")){
                    case 1->System.out.println(carte);
                    case 2->this.v_mod.afficherCarte(carte.getVal(),carte.getCouleur().name());
                    case 3->{
                        params = this.v_mod.CreateCarte();
                        carte = this.m_mod.new Carte(params[0], params[1]);
                    }
                    case 4->carte.setVal(tools.AskString("Quel est la nouvelle valeur de la carte : "));
                    case 5->carte.setCouleur(tools.AskString("Quel est la nouvelle couleur de la carte : "));
                    case 7-> {
                        return;
                    }
                }
            }catch (Exception e){
                System.err.println("Erreur -> "+ e);
            }
        }

    }
}
