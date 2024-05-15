package PTP_POO.PTP3.Vue;

import PTP_POO.PTP3.Model.CollectionTimbre;
import PTools.tools;

import java.util.HashMap;

public class VTP3_2 {
    public UpdateInfo updateAttributTimbre(CollectionTimbre collection) {
        int index = tools.AskInt("Indiquez l'index du timbre que vous souhaitez mettre à jour :");
        tools.AskString("");
        if (index >= 0 && index < collection.getL_timbres().size()) {
            String cle = tools.AskString("Entrez le nom de l'attribut à mettre à jour :");
            String val = tools.AskString("Entrez la nouvelle valeur de l'attribut :");
            return new UpdateInfo(index, cle, val);
        } else {
            throw new IllegalArgumentException("Index invalide");
        }
    }

    public HashMap<String, String> addTimbre() {
        HashMap<String, String> attributs = new HashMap<>();
        attributs.put("Pays", tools.AskString("Veuillez saisir les attributs du timbre :\nPays : "));
        attributs.put("Valeur", tools.AskString("Valeur : "));
        attributs.put("Année", tools.AskString("Année : "));

        /*
        "Designation": "Timbre-poste ordinaire",
	"Filet": "Filet décoratif rouge",
	"Facial": "Portrait de Louis Pasteur",
	"SignatureDessinateur": "Pierre Gandon",
	"Pays": "France",
	"SignatureGraveur": "Albert Decaris",
	"Dentelure": "12 1/2 x 12 1/2",
	"Oeuvre": "Louis Pasteur en laboratoire"
         */
        return attributs;
    }

    public class UpdateInfo {
        private final int index;
        private final String cle;
        private final String val;

        public UpdateInfo(int index, String cle, String val) {
            this.index = index;
            this.cle = cle;
            this.val = val;
        }

        public int getIndex() {
            return index;
        }

        public String getCle() {
            return cle;
        }

        public String getVal() {
            return val;
        }
    }
}
