package PTP_POO.PTP3.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * La classe Paquet représente un paquet de cartes
 */
public class Paquet implements Iterable<Carte>{
    /** La liste des cartes dans le paquet. */
    private final ArrayList<Carte> L_cartes;

    /**
     * Constructeur de la classe Paquet.
     * @param listcarte La liste initiale de cartes à inclure dans le paquet.
     * @throws IllegalArgumentException si le paquet contient plus de 52 cartes ou si la liste contient des éléments identiques.
     */
    public Paquet(ArrayList<Carte> listcarte){
        if (listcarte.size() >= 52){
            throw new IllegalArgumentException("Il ne peut y avoir que 52 cartes dans le paquet");
        }

        if (ElementIdentique(listcarte)) {
            throw new IllegalArgumentException("La liste de cartes ne doit contenir que des éléments uniques");
        }

        L_cartes = listcarte;
    }

    /**
     * Vérifie si une liste de cartes contient des éléments identiques.
     * @param liste La liste de cartes à vérifier.
     * @return true si des éléments identiques sont trouvés, false sinon.
     */
    private boolean ElementIdentique(ArrayList<Carte> liste) {
        Set<Carte> uniqueElements = new HashSet<>();
        for (Carte carte : liste) {
            if (!uniqueElements.add(carte)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Ajoute une carte au paquet.
     * @param carte La carte à ajouter.
     * @throws IllegalArgumentException si la carte est déjà présente dans le paquet ou si le paquet est complet.
     */
    public void add(Carte carte){
        if (containsCarte(carte)) {
            throw new IllegalArgumentException("Cette carte est déjà dans le paquet de cartes");
        } else if (L_cartes.size() >= 52) {
            throw new IllegalArgumentException("Le paquet est rempli");
        } else {
            L_cartes.add(carte);
            System.out.println(carte + " ajoutée avec succès.");
        }
    }

    @Override
    public Iterator<Carte> iterator() {
        return L_cartes.iterator();
    }

    /**
     * Obtient le paquet de cartes.
     * @return le paquet de cartes.
     */
    public ArrayList<Carte> getL_cartes(){
        return L_cartes;
    }

    /**
     * Vérifie si le paquet contient une carte spécifique.
     * @param carte La carte à rechercher.
     * @return true si la carte est présente dans le paquet, false sinon.
     */
    public boolean containsCarte(Carte carte) {
        return L_cartes.contains(carte);
    }

    /**
     * Surcharge de toString pour afficher le message que l'on voit quand on print mon paquet
     * @return Le message
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paquet de cartes:\n");
        for (Carte carte : L_cartes) {
            sb.append(carte.toString()).append("\n");
        }
        return sb.toString();
    }
}
