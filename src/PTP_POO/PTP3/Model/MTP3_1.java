package PTP_POO.PTP3.Model;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

public class MTP3_1 {

    public enum  e_couleur {pique, carreau, trefle, coeur}
    public final String[] e_valeur = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Reine", "Roi", "As"};

    public class Carte{
        private String m_valeur;
        private e_couleur m_couleur;

        public Carte(String Val, String Couleur) {
            if (!Arrays.asList(e_valeur).contains(Val)) {
                throw new IllegalArgumentException("La valeur de la carte n'est pas valide.");
            }

            if (Val.equals("1")){
                Val = "As";
            }

            switch (Couleur.toLowerCase(Locale.ROOT)){
                case "pique"-> m_couleur = e_couleur.pique;
                case "carreau"-> m_couleur = e_couleur.carreau;
                case "trefle"-> m_couleur = e_couleur.trefle;
                case "coeur"-> m_couleur = e_couleur.coeur;
                default ->throw new IllegalArgumentException("La couleur de la carte n'est pas valide.");
            }

            m_valeur = Val;
        }

        public Carte(Carte carte){
            this.m_couleur = carte.m_couleur;
            this.m_valeur = carte.m_valeur;
        }

        @Override
        public String toString(){
            if (this.m_valeur.equals("1")){
               return "As de " + this.m_couleur;
            }
            return this.m_valeur + " de " + this.m_couleur;
        }

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

        public void setVal(String val){
            if (!Arrays.asList(e_valeur).contains(val)) {
                throw new IllegalArgumentException("La valeur de la carte n'est pas valide.");
            }
            this.m_valeur = val;
        }

        public void setCouleur(String couleur){
            switch (couleur.toLowerCase(Locale.ROOT)){
                case "pique"-> this.m_couleur = e_couleur.pique;
                case "carreau"-> this.m_couleur = e_couleur.carreau;
                case "trefle"-> this.m_couleur = e_couleur.trefle;
                case "coeur"-> this.m_couleur = e_couleur.coeur;
                default ->throw new IllegalArgumentException("La couleur de la carte n'est pas valide.");
            }
        }

        public String getVal(){
            return this.m_valeur;
        }

        public e_couleur getCouleur(){
            return this.m_couleur ;
        }
    }
}
