package com.mycompany.devisbatiment;

import java.io.IOException;

public class DevisBatiment {

    public static int nbPiece;
    public static int typeBat;
    public static double hauteurFenetre;
    public static double longueurFenetre;
    public static double hauteurPorte;
    public static double longueurPorte;
    public static int nbNiveau;
    public static double prixMur;
    public static int nbRev;
    public static double hauteurPlafond;
    public static int[] nbAppartement;
    public static String[] nomPiece;
    public static int[] nbMur;
    public static int[] nbFenetre;
    public static int[] nbPorte;
    public static double longueurPiece[];
    public static double largeurPiece[];
    public static double surfaceSolPiece[];
    public static double[][] longueurMur;
    public static double[][] surfaceMur;
    public static double[][] surfacePorte;
    public static double[][] surfaceFenetre;
    public static double prixTotal = 0;
    public static double[] prixSol;
    public static double[] prixPlafond;

    public static double surfacePlafondPiece[];

    public static void main(String[] args) throws IOException {

        typeBat = 0;

        DemanderTypeBatiment();
        ExecuterMaisonImmeuble();
    }

    public static int DemanderTypeBatiment() {
        System.out.println("Quel est le type du batiment ? 1 pour maison, 2 pour immeuble");
        typeBat = Lire.i();
        return typeBat;
    }

    public static void ExecuterMaisonImmeuble() throws IOException {
        if (typeBat == 1) {
            Maison.executerMaison();
        }
        if (typeBat == 2) {
            Immeuble.executerImmeuble(nbAppartement, nbNiveau);
        }
    }
}
