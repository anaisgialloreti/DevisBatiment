package com.mycompany.devisbatiment;

public class Plafond {
    
    public static int nbPiece;
    public static double longueurPiece[];
    public static double largeurPiece[];
    public static double surfacePlafondPiece[];
    
    public static double CalculerSurfacePlafond(int nbPiece, double longueurPiece[], double largeurPiece[], double surfacePlafondPiece[]){
        for (int i=0; i< nbPiece; i++){
            surfacePlafondPiece[i] = longueurPiece[i]*largeurPiece[i];
        }
        return 0;
    }
    
    public static void afficherSurfacePiece(double[] surfacePlafondPiece){
        for (int i=0; i< nbPiece; i++){
            System.out.println("La surface de la pièce n°"+(i+1)+" est de "+(surfacePlafondPiece[i])+" mètre carré.");
        }
    }
    
}
