package PTools;

import java.util.Scanner;

/**
 * Classe tools (boite à outils)
 * @author julien
 */
public class tools {

    /**
     * Constructeur bloqué
     */
    private tools() {}

    public static final Scanner sc = new Scanner(System.in);

    /**
     * Fonction pour savoir ce que l'utilisateur renvoie après un message
     * @param message Messaqe pour l'utilisateur
     * @return ce que l'utilisateur a répondue
     */
    public static String AskString(String message) {
        System.out.print(message);
        return sc.nextLine();
    }


    /**
     * Fonction pour qui attend que l'utilisateur renvoie un int
     * @param message Message pour l'utilisateur
     * @return int renvoyé par l'utilisateur
     */
    public static int AskInt(String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {//Tant que l'utilisateur envoie un int
            System.out.println("Erreur : Entrée invalide. Veuillez entrer un entier.");
            sc.next();
            System.out.print(message);
        }
        return sc.nextInt();
    }
}
