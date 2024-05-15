package PTP_POO.PTP3.Controlleur;

import PTP_POO.PTP3.Model.CollectionTimbre;
import PTP_POO.PTP3.Model.Timbre;
import PTP_POO.PTP3.Vue.VTP3_2;
import PTools.tools;

import java.util.ArrayList;

public class CTP3_2 implements IControlleur {

    private final VTP3_2 v_mod ;
    public CTP3_2(VTP3_2 vMod){
        v_mod = vMod;
    }

    public static void main(String[] args) {
        execute();
    }

    public static void execute(){
        new CTP3_2(new VTP3_2()).lancer();
    }

    @Override
    public void lancer(){
        CollectionTimbre collectionTimbre = new CollectionTimbre(new ArrayList<>());
        while (true){
            switch (tools.AskInt("1. Afficher la collection\n2. Ajouter un timbre\n3. Mettre à jour un attribut d'un timbre\n4. Sauvegarder la collection\n5. Récupérer la collection\n6. Quitter\n")){
                case 1 -> System.out.println(collectionTimbre);
                case 2 -> {
                    collectionTimbre.getL_timbres().add(new Timbre(v_mod.addTimbre()));
                    System.out.println("Le timbre a été ajouté à la collection !");
                }
                case 3->{
                    VTP3_2.UpdateInfo params = v_mod.updateAttributTimbre(collectionTimbre);
                    collectionTimbre.getL_timbres().get(params.getIndex()).update(params.getCle(), params.getVal());
                }
                case 4 ->{
                    collectionTimbre.saveCollection();
                    System.out.println("La collection a été sauvegardée avec succès !");
                }
                case 5 -> {
                    collectionTimbre.recupCollection();
                    System.out.println("La collection a été récupérée avec succès !");
                }
                case 6 -> {
                    return;
                }
                default -> {
                    System.out.println("Choix invalide");
                }
            }
        }
    }
}
