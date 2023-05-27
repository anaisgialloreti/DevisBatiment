package com.mycompany.devisbatiment;

import java.io.IOException;

public class Maison {
    
    public static int nbPiece;
    public static int nbRev;
    public static double hauteurFenetre;
    public static double longueurFenetre;
    public static double hauteurPorte;
    public static double longueurPorte;
    public static double hauteurPlafond;
    public static double surfacePorte;
    public static double surfaceFenetre;
    public static double prixUnitaire;
    public static String[] nomPiece;
    public static int[] nbMur;
    public static int[] nbFenetre;
    public static int[] nbPorte;
    public static double[] longueurPiece;
    public static double[] largeurPiece;
    public static double[] surfaceSolPiece;
    public static double[] surfacePlafondPiece;
    public static double[] prixPlafond;
    public static double[] prixSol;
    public static double[][] prixMur;
    public static int[][] nbOuvertureFenetre;
    public static int[][] nbOuverturePorte;
    public static double[][] largeurMur;
    public static double[][] surfaceMur;
    public static double prixTotal = 0;

    public static void executerMaison() throws IOException {

        nbPiece = Piece.demanderNombrePiece(nbPiece);

        //Initialisation des tableaux à 1 dimension qui stock les infos
        nomPiece = new String[nbPiece];
        nbMur = new int[nbPiece];
        nbFenetre = new int[nbPiece];
        nbPorte = new int[nbPiece];
        longueurPiece = new double[nbPiece];
        largeurPiece = new double[nbPiece];
        surfaceSolPiece = new double[nbPiece];
        surfacePlafondPiece = new double[nbPiece];
        prixSol = new double[nbPiece];
        prixPlafond = new double[nbPiece];
        
        for (int i = 0; i < nbPiece; i++) {
            nbMur[i] = 4;
        }

        for (int i = 0; i < nbPiece; i++) {
            nbOuvertureFenetre = new int[nbPiece][nbMur[i]];
        }

        for (int i = 0; i < nbPiece; i++) {
            nbOuverturePorte = new int[nbPiece][nbMur[i]];
        }

        for (int i = 0; i < nbPiece; i++) {
            largeurMur = new double[nbPiece][nbMur[i]];
        }

        for (int i = 0; i < nbPiece; i++) {
            surfaceMur = new double[nbPiece][nbMur[i]];
        }

        for (int i = 0; i < nbPiece; i++) {
            prixMur = new double[nbPiece][nbMur[i]];
        }

        hauteurPlafond = Piece.demanderInfoPiece(nbPiece, nbOuverturePorte, nbOuverturePorte, nomPiece, nbMur, nbFenetre, nbPorte, hauteurPlafond);
        Piece.afficherInfoPiece(nbPiece, nomPiece, nbMur, nbFenetre, nbPorte, hauteurPlafond);
        Mur.calculerSurfaceMur(nbPiece, nbFenetre, nbPorte, nomPiece, nbMur, largeurMur, hauteurPlafond, surfaceMur, surfaceFenetre, surfacePorte, nbOuvertureFenetre, nbOuverturePorte);
        Mur.afficherSurfaceMur(nbPiece, nbMur, nomPiece, surfaceMur);
        Sol.appliquerMesurePiece(nbPiece, largeurMur, longueurPiece, largeurPiece, surfaceSolPiece);
        Sol.CalculerSurfaceSol(nbPiece, longueurPiece, largeurPiece, surfaceSolPiece);
        Plafond.CalculerSurfacePlafond(nbPiece, longueurPiece, largeurPiece, surfacePlafondPiece);
        Plafond.afficherSurfacePiece(surfacePlafondPiece);
        Peinture.devisMur(nbPiece, nbRev, prixMur, nomPiece, surfaceMur, nbMur);
        Peinture.devisPlafond(nbPiece, nbRev, nomPiece, prixMur, surfacePlafondPiece, prixPlafond);
        Carrelage.devisSol(nbPiece, nbRev, nomPiece, prixMur, surfaceSolPiece, prixSol);
        System.out.println();
        System.out.println();
        System.out.println("DEVIS :");
        System.out.println();
        System.out.println();
        Carrelage.afficherDevisPiece(nbPiece, nbMur, nomPiece, prixMur, prixSol, prixPlafond);
        Carrelage.afficherDevisTotal(nbPiece, nbMur, prixMur, prixSol, prixPlafond, prixTotal);
        Fichier.afficherDevisPiece(nbPiece, nbMur, nomPiece, prixMur, prixSol, prixPlafond);
        prixTotal = Fichier.afficherDevisTotal(nbPiece, nbMur, prixMur, prixSol, prixPlafond, prixTotal);

    }
    
}
