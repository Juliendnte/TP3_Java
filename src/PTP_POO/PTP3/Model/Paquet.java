package PTP_POO.PTP3.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Paquet implements Iterable<Carte>{
    private final ArrayList<Carte> L_cartes;

    public Paquet(ArrayList<Carte> listcarte){
        if (listcarte.size() >= 52){
            throw new IllegalArgumentException("Il ne peut avoir que 52 carte dans le Jeu");
        }

        if (ElementIdentique(listcarte)) {
            throw new IllegalArgumentException("La liste de cartes ne doit contenir que des éléments uniques");
        }

        L_cartes = listcarte;
    }

    private boolean ElementIdentique(ArrayList<Carte> liste) {
        Set<Carte> elementsUniques = new HashSet<>();
        for (Carte carte : liste) {
            if (!elementsUniques.add(carte)) {
                return true;
            }
        }
        return false;
    }

    public void add(Carte carte){
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
    public Iterator<Carte> iterator() {
        return L_cartes.iterator();
    }

    public ArrayList<Carte> getL_cartes(){
        return L_cartes;
    }
}
