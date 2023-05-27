package com.mycompany.devisbatiment;

import static com.mycompany.devisbatiment.Immeuble.nbMur;
import static com.mycompany.devisbatiment.Immeuble.nbPiece;
import static com.mycompany.devisbatiment.Immeuble.nomPiece;
import static com.mycompany.devisbatiment.Immeuble.prixMur;
import static com.mycompany.devisbatiment.Immeuble.prixPlafond;
import static com.mycompany.devisbatiment.Immeuble.prixSol;
import static com.mycompany.devisbatiment.Immeuble.prixTotal;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Fichier {
    
    public static void afficherDevisPiece(int nbPiece, int[] nbMur, String[] nomPiece, double[][] prixMur, double[] prixSol, double[] prixPlafond) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("devisBat.txt"))) {
            writer.println("- Devis Bâtiment -");
            writer.println();
            for (int i = 0; i < nbPiece; i++) {
                for (int j = 0; j < nbMur[i]; j++) {
                    writer.println("Le prix du mur n°" + (j + 1) + " de la pièce : " + nomPiece[i] + " est de " + (prixMur[i][j]) + " €");
                }
                writer.println("Le prix du sol de la pièce : " + nomPiece[i] + " est de " + (prixSol[i]) + " €");
                writer.println("Le prix du plafond de la pièce : " + nomPiece[i] + " est de " + (prixPlafond[i]) + " €");
                writer.println();
                writer.println("-------------------------------------------------------------------");
                writer.println();
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de l'enregistrement du devis : " + e.getMessage());
        }
    }

    public static double afficherDevisTotal(int nbPiece, int[] nbMur, double[][] prixMur, double[] prixSol, double[] prixPlafond, double prixTotal) {
        for (int i = 0; i < nbPiece; i++) {
            prixTotal = prixTotal + prixSol[i] + prixPlafond[i];
        }
        for (int i = 0; i < nbPiece; i++) {
            for (int j = 0; j < nbMur[i]; j++) {
                prixTotal = prixTotal + prixMur[i][j];
            }
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter("devisBat.txt", true))) {
            writer.println();
            writer.println();
            writer.println("Le prix total du devis est de : " + prixTotal + " €");
            writer.println();
            writer.println("Merci d'avoir fait appel à nos services !");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'enregistrement du devis : " + e.getMessage());
        }
        return prixTotal;
    }
    
    public static void afficherDevisImmeuble(int nbNiveau, int[] nbAppartement) throws IOException{
        try (PrintWriter writer = new PrintWriter(new FileWriter("devisBat.txt", true))) {
            writer.println("- Devis Bâtiment -");
            writer.println();
        
            for(int i=0; i< nbNiveau; i++){
                for (int j = 0; j < nbAppartement[i]; j++) {
                    writer.println();
                    writer.println();
                    writer.println("Devis de l'appartement n°"+(j+1)+" au niveau "+(i+1));
                    Fichier.afficherDevisPiece(nbPiece, nbMur, nomPiece, prixMur, prixSol, prixPlafond);
                    Fichier.afficherDevisTotal(nbPiece, nbMur, prixMur, prixSol, prixPlafond, prixTotal);
                    writer.println();
                    writer.println("----------------------------------------");
                }
            }
        }
    }
    
}
