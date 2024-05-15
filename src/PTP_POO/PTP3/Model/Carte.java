package PTP_POO.PTP3.Model;

import java.util.Arrays;

/**La classe Carte représente une carte à jouer avec une valeur et une couleur.*/
public class Carte{

    /** L'énumération des couleurs possible de la carte. */
    public enum  e_couleur {pique, carreau, trefle, coeur}

    /** Les valeurs valides d'une carte. */
    private final String[] e_valeur = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    /** La valeur de la carte. */
    private String m_valeur;

    /** La couleur de la carte. */
    private e_couleur m_couleur;

    /**
     * Constructeur de la classe Carte.
     * @param Val La valeur de la carte.
     * @param Couleur La couleur de la carte.
     * @throws IllegalArgumentException si la valeur de la carte n'est pas valide.
     */
    public Carte(String Val, String Couleur) throws IllegalArgumentException {
        if (!Arrays.asList(e_valeur).contains(Val)) {
            throw new IllegalArgumentException("La valeur de la carte n'est pas valide.");
        }

        if (Val.equals("1")){
            Val = "A";
        }
        m_couleur = toE_Couleur(Couleur);

        m_valeur = Val;
    }

    /**
     * Constructeur de copie de la classe Carte.
     * @param carte L'objet Carte à copier.
     */
    public Carte(Carte carte){
        this.m_couleur = carte.m_couleur;
        this.m_valeur = carte.m_valeur;
    }

    /**
     * Surcharge de toString pour afficher le message que l'on voit quand on print ma carte
     * @return Message
     */
    @Override
    public String toString(){
        if (this.m_valeur.equals("1")){
            return "As de " + this.m_couleur;
        }
        return toWord(this.m_valeur) + " de " + this.m_couleur;
    }

    /**
     * Vérifie si une carte est égale à un autre objet.
     * @param obj L'objet à comparer.
     * @return true si les deux objets sont égaux, false sinon.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Carte autreCarte = (Carte) obj;
        return this.m_valeur.equals(autreCarte.m_valeur) && this.m_couleur.equals(autreCarte.m_couleur);
    }



    public void assign(Carte aCarte) {
        this.m_couleur = aCarte.m_couleur;
        this.m_valeur = aCarte.m_valeur;
    }

    public void setVal(String val) throws IllegalArgumentException{
        if (!Arrays.asList(e_valeur).contains(val)) {
            throw new IllegalArgumentException("La valeur de la carte n'est pas valide.\nRappel cette valeur doit être parmis cette liste \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\", \"9\", \"10\", \"J\", \"Q\", \"K\", \"A\"");
        }
        this.m_valeur = val;
    }

    public void setCouleur(String couleur) throws IllegalArgumentException{
        this.m_couleur = toE_Couleur(couleur);
    }

    public String getVal(){
        return this.m_valeur;
    }

    public e_couleur getCouleur(){
        return this.m_couleur ;
    }

    public String getSymbole() {
        return switch (this.m_couleur){
            case e_couleur.carreau ->"♦";
            case e_couleur.trefle ->"♣";
            case e_couleur.coeur ->"♥";
            case e_couleur.pique ->"♠";
        };
    }

    public e_couleur toE_Couleur(String couleur) throws IllegalArgumentException{
        return switch (couleur.toLowerCase()){
            case "pique"-> e_couleur.pique;
            case "carreau"-> e_couleur.carreau;
            case "trefle"-> e_couleur.trefle;
            case "coeur"-> e_couleur.coeur;
            default ->throw new IllegalArgumentException("La couleur de la carte n'est pas valide.");
        };
    }
    public String toWord(String letter) throws IllegalStateException {
        return switch (letter) {
            case "J" -> "Valet";
            case "Q" -> "Reine";
            case "K" -> "Roi";
            case "A" -> "As";
            default -> letter;
        };
    }
}

