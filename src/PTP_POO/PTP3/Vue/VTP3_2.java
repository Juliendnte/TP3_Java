package PTP_POO.PTP3.Vue;

import PTP_POO.PTP3.Model.CollectionTimbre;
import PTools.tools;

import java.util.HashMap;

public class VTP3_2 {
    public UpdateInfo updateAttributTimbre(CollectionTimbre collection) {
        int index = tools.AskInt("Quel timbre que vous souhaitez mettre à jour (ex : 1, 2, 3, etc...) :") - 1;
        tools.AskString("");
        if (index >= 0 && index < collection.getL_timbres().size())
            return new UpdateInfo(index, tools.AskString("Entrez le nom de l'attribut à mettre à jour :"), tools.AskString("Entrez la nouvelle valeur de l'attribut :"));
        else
            throw new IllegalArgumentException("Index invalide");
    }

    public HashMap<String, String> addTimbre() {
        HashMap<String, String> attributs = new HashMap<>();
        tools.AskString("");
        attributs.put("Pays", tools.AskString("Veuillez saisir les attributs du timbre :\nPays : "));
        attributs.put("Valeur", tools.AskString("Valeur : "));
        attributs.put("Année", tools.AskString("Année : "));
        attributs.put("SignatureDessinateur", tools.AskString("Signature du Dessinateur :"));
        attributs.put("Designation",tools.AskString("Designation :"));
        attributs.put("Dentelure", tools.AskString("Dentelure :"));
        attributs.put("Oeuvre", tools.AskString("Oeuvre :"));
        return attributs;
    }

    public record UpdateInfo(int index, String cle, String val) {
    }
}
