package com.mycompany.devisbatiment;

import java.io.IOException;
import java.util.ArrayList;

public class Carrelage {
    
    public static int nbPiece;
    public static int revChoisi;
    public static double prixUnitaire;
    public static double[] prixPlafond;
    public static String[] nomPiece;
    public static double[] surfacePlafondPiece;
    public static double[][] prixMur;
    public static double[] prixSol;
    public static int[] nbMur;
    public static String DevisBat;
    public static double prixTotal = 0;

    
    public static double devisSol(int nbPiece, int revChoisi, String[] nomPiece, double[][] prixMur, double[] surfaceSolPiece, double[] prixSol) throws IOException {
        ArrayList<Revetement> ListeRevetement = Revetement.liste_revetements("/Users/anais/Documents/NetBeansProjects/NetBeansProjects/PROJETINFOS2/src/main/java/com/mycompany/projetinfos2/CatalogueRevetement.txt");
        System.out.println("Passons au choix du revêtement pour les sols");
        for (int i = 0; i < nbPiece; i++) {
            System.out.println("Veuillez choisir un revêtement de sol pour la pièce : "+nomPiece[i]);
            revChoisi = Lire.i();
            for (Revetement revetement : ListeRevetement) {
                int idRevetement = revetement.getIdRevetement();
                if (idRevetement == revChoisi) {
                        System.out.println(revetement);
                        if (revetement.getPourSol()) {
                            double prixUnitaire = revetement.getPrixUnitaire();
                            prixSol[i] = surfaceSolPiece[i] * prixUnitaire;
                        } else {
                            System.out.println("Ce revêtement ne s'applique pas à cette surface");
                            i = i - 1;
                        }
                    }
            }
        }
        return 0;
    }

    public static void afficherDevisPiece(int nbPiece, int[] nbMur,String[] nomPiece, double[][] prixMur, double[] prixSol, double[] prixPlafond) {
        for (int i = 0; i < nbPiece; i++) {
            for (int j = 0; j < nbMur[i]; j++) {
                System.out.println("Le prix du mur n°" + (j + 1) + " de la pièce : "+nomPiece[i] + " est de " + (prixMur[i][j]) + " €");
            }
            System.out.println("Le prix du sol de la pièce : "+ nomPiece[i] + " est de " + (prixSol[i]) + " €");
            System.out.println("Le prix du sol de la pièce : "+ nomPiece[i] + " est de " + (prixPlafond[i]) + " €");
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
        System.out.println();
        System.out.println();
        System.out.println("Le prix total du devis est de : "+prixTotal+" €");
        System.out.println();
        System.out.println("Merci d'avoir fait appel à nos services !");
        return 0;
    }
    
}
