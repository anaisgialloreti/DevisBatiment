package com.mycompany.devisbatiment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Peinture {
    
    public static int nbPiece;
    public static int revChoisi;
    public static double[][] prixMur;
    public static int[] nbMur;
    public static String[] nomPiece;
    public static double[][] surfaceMur;
    public static double prixUnitaire;
    public static double[] prixSol;
    public static double[] surfaceSolPiece;
    public static int idRevetement;

    public static double devisMur(int nbPiece, int revChoisi, double[][] prixMur, String[] nomPiece, double[][] surfaceMur, int[] nbMur) throws FileNotFoundException, IOException {
        ArrayList<Revetement> ListeRevetement = Revetement.liste_revetements("/Users/anais/Documents/NetBeansProjects/NetBeansProjects/PROJETINFOS2/src/main/java/com/mycompany/projetinfos2/CatalogueRevetement.txt");
        System.out.println("Passons au choix du revêtement pour les murs");
        for (int i = 0; i < nbPiece; i++) {
            for (int j = 0; j < nbMur[i]; j++) {
                System.out.println("Veuillez choisir un revêtement pour le mur n°" + (j + 1)+" de la pièce : "+nomPiece[i]);
                revChoisi = Lire.i();
                for (Revetement revetement : ListeRevetement) {
                    int idRevetement = revetement.getIdRevetement();
                    if (idRevetement == revChoisi) {
                        System.out.println(revetement);
                        if (revetement.getPourMur()) {
                            double prixUnitaire = revetement.getPrixUnitaire();
                            prixMur[i][j] = surfaceMur[i][j] * prixUnitaire;
                        } else {
                            System.out.println("Ce revêtement ne s'applique pas à cette surface");
                            j = j - 1;
                        }
                    }
                }
            }
        }
        return 0;
    }
    public static double devisPlafond(int nbPiece, int revChoisi, String[] nomPiece, double[][] prixMur, double[] surfacePlafondPiece, double[] prixPlafond) throws IOException {
        ArrayList<Revetement> ListeRevetement = Revetement.liste_revetements("/Users/anais/Documents/NetBeansProjects/NetBeansProjects/PROJETINFOS2/src/main/java/com/mycompany/projetinfos2/CatalogueRevetement.txt");
        System.out.println("Passons au choix du revêtement pour les plafonds");
        for (int i = 0; i < nbPiece; i++) {
            System.out.println("Veuillez choisir un revêtement pour la pièce : "+nomPiece[i]);
            revChoisi = Lire.i();
            for (Revetement revetement : ListeRevetement) {
                int idRevetement = revetement.getIdRevetement();
                if (idRevetement == revChoisi) {
                    System.out.println(revetement);
                    if (revetement.getPourPlafond()) {
                        double prixUnitaire = revetement.getPrixUnitaire();
                        prixPlafond[i] = surfacePlafondPiece[i] * prixUnitaire;
                    } else {
                        System.out.println("Ce revêtement ne s'applique pas à cette surface");
                        i = i - 1;
                    }
                }
            }
        }
        return 0;
    }
    
}
