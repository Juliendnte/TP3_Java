package PTP_POO.PTP3.Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;

/**La classe CollectionTimbre représente une Liste de timbre*/
public class CollectionTimbre{

    /** Collection de timbre */
    private ArrayList<Timbre> L_timbres ;

    /**
     * Constructeur de la classe CollectionTimbre.
     * @param lTimbres La liste des timbres initiale.
     */
    public CollectionTimbre(ArrayList<Timbre> lTimbres) {
        L_timbres = lTimbres;
    }

    /**
     * Obtient la collection de timbre
     * @return la collection de timbre
     */
    public ArrayList<Timbre> getL_timbres(){
        return L_timbres;
    }


    /**
     * Surcharge de toString pour afficher le message que l'on voit quand on print ma collection
     * @return Le message
     */
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("Collection de timbres:\n");
        for (Timbre timbre : L_timbres) {
            result.append(timbre.toString()).append("\n");
        }
        return result.toString();
    }

    /**
     * Sauvegarde la collection de timbres dans un fichier JSON
     */
    public void saveCollection(){
        int totalElements = L_timbres.size();
        int count1 = 0;

        try (FileWriter writer = new FileWriter("src/PTP_POO/PTP3/DB/ListTimbre.json")) {
            writer.write("[\n");
            for (Timbre timbre : this.L_timbres) {
                ++count1;
                writer.write(timbre.toJson());

                writer.write(count1 < totalElements ? ",\n" : "\n");
            }
            writer.write("]");
        } catch (IOException e) {
            System.out.println("err -> " + e);
        }
    }

    /**
     * Récupère la collection de timbres depuis un fichier JSON.
     * @return La collection de timbre
     */
    public ArrayList<Timbre> recupCollection() {
        try {
            //jsonContent = le json en string
            String jsonContent = new String(Files.readAllBytes(Paths.get("src/PTP_POO/PTP3/DB/ListTimbre.json")));
            ArrayList<Timbre> lsttimbres = new ArrayList<>();

            //Pour savoir ou commence et finit mon tableau
            int start = jsonContent.indexOf("[");
            int end = jsonContent.lastIndexOf("]");

            //Si un des deux est égal a -1 cela signifie qu'il ne sont pas la donc que le format du json n'est pas bon
            if (start != -1 && end != -1) {
                //J'enlève les []
                String jsonArrayContent = jsonContent.substring(start + 1, end);
                //Je prend timbre par timbre
                String[] timbres = jsonArrayContent.split("}\\s*,\\s*");

                for (String timbre : timbres) {
                    //La je prend juste le contenu entre les accolades
                    timbre = timbre.replaceAll("\\{", "").replaceAll("}", "");
                    HashMap<String, String> attributs = extractAttributs(timbre);

                    //Je cast ma map en timbres et l'ajoute dans la collection
                    lsttimbres.add(new Timbre(attributs));
                }
            }


            L_timbres = lsttimbres;
        }catch (IOException e) {
            System.out.println("erreur : "+e);
        }
        return L_timbres;
    }

    /**
     * Extrait les attributs d'un timbre depuis un JSON sous forme de string
     * @param timbre Le JSON du timbre.
     * @return Une map des attributs du timbre.
     */
    private HashMap<String, String> extractAttributs(String timbre) {
        //Ici je sépare les attributs des autres
        String[] attribut = timbre.split("\\s*,\\s*");
        HashMap<String, String> attributs = new HashMap<>();

        for (String cleval : attribut) {
            //Séparation clé et valeur
            String[] attribute = cleval.split("\\s*:\\s*");
            //J'ajoute a ma map mes clés valeurs et j'enlève les ""
            attributs.put(attribute[0].replaceAll("\"", ""), attribute[1].replaceAll("\"", ""));
        }
        return attributs;
    }
}
