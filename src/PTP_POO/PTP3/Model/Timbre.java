package PTP_POO.PTP3.Model;

import java.util.HashMap;

/** La classe Timbre représente un timbre avec des attributs*/
public class Timbre{

    /** Les attributs du timbre stockés dans une map. */
    private final HashMap<String, String> Attribut;

    /**
     * Constructeur de la classe Timbre
     * @param attribut La map des attributs du timbre
     */
    public Timbre(HashMap<String, String> attribut) {
        Attribut = attribut;
    }

    /**
     * Met à jour la valeur d'un attribut du timbre
     * @param cle La clé de l'attribut à mettre à jour
     * @param val La nouvelle valeur de l'attribut
     */
    public void update(String cle, String val){
        this.Attribut.replace(cle,val);
    }

    /**
     * Obtient la map
     * @return La map
     */
    public HashMap<String, String> getTimbre(){
        return this.Attribut;
    }

    /**
     * Obtient la valeur d'un attribut spécifique du timbre
     * @param cle La clé de l'attribut dont on veut obtenir la valeur
     * @return La valeur de l'attribut
     */
    public String getValTimbre(String cle){
        return this.Attribut.get(cle);
    }

    /**
     * Surcharge de toString pour afficher le message que l'on voit quand on print mon timbre
     * @return Le message
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Timbre:\n");
        for (String key : Attribut.keySet()) {
            result.append(key).append(": ").append(Attribut.get(key)).append("\n");
        }
        return result.toString();
    }

    /**
     * Obtient la version Json de ma classe timbre
     * @return Le Json de ma classe timbre
     */
    public String toJson() {
        return String.format("{\"Designation\":\"%s\",\"SignatureDessinateur\":\"%s\",\"Année\":\"%s\",\"Valeur\":\"%s\",\"Pays\":\"%s\",\"Dentelure\":\"%s\",\"Oeuvre\":\"%s\"}", this.Attribut.get("Designation"), this.Attribut.get("SignatureDessinateur"), this.Attribut.get("Année"), this.Attribut.get("Valeur"), this.Attribut.get("Pays"), this.Attribut.get("Dentelure"), this.Attribut.get("Oeuvre"));
    }
}
