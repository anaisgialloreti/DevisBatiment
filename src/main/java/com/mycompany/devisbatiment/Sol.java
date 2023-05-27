package com.mycompany.devisbatiment;

public class Sol {

    public static int nbPiece;
    public static double longueurPiece[];
    public static double largeurPiece[];
    public static double surfaceSolPiece[];
    public static double[][] largeurMur;
    public static double[][] surfaceMur;

    public static double appliquerMesurePiece(int nbPiece, double[][] largeurMur, double longueurPiece[], double largeurPiece[], double surfaceSolPiece[]) {
        for (int i = 0; i < nbPiece; i++) {
            longueurPiece[i] = largeurMur[i][0];
            largeurPiece[i] = largeurMur[i][1];
        }
        return 0;
    }

    public static double CalculerSurfaceSol(int nbPiece, double longueurPiece[], double largeurPiece[], double surfaceSolPiece[]) {
        for (int i = 0; i < nbPiece; i++) {
            surfaceSolPiece[i] = longueurPiece[i] * largeurPiece[i];
        }
        return 0;
    }

}
