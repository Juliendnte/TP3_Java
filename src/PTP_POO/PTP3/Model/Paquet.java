package PTP_POO.PTP3.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Paquet implements Iterable<MTP3_1.Carte>{
    private final ArrayList<MTP3_1.Carte> L_cartes;

    public Paquet(ArrayList<MTP3_1.Carte> listcarte){
        if (listcarte.size() >= 52){
            throw new IllegalArgumentException("Il ne peut avoir que 52 carte dans le Jeu");
        }

        if (ElementIdentique(listcarte)) {
            throw new IllegalArgumentException("La liste de cartes ne doit contenir que des éléments uniques");
        }

        L_cartes = listcarte;
    }

    private boolean ElementIdentique(ArrayList<MTP3_1.Carte> liste) {
        Set<MTP3_1.Carte> elementsUniques = new HashSet<>();
        for (MTP3_1.Carte carte : liste) {
            if (!elementsUniques.add(carte)) {
                return true;
            }
        }
        return false;
    }

    public void add(MTP3_1.Carte carte){
        L_cartes.add(carte);
        if (ElementIdentique(L_cartes)) {
            L_cartes.removeLast();
            throw new IllegalArgumentException("Cette carte est déjà dans le paquet de carte");
        }else if(L_cartes.size()>52){
            L_cartes.removeLast();
            throw new IllegalArgumentException("Le paquet est remplie");
        }
    }

    @Override
    public Iterator<MTP3_1.Carte> iterator() {
        return L_cartes.iterator();
    }
}
