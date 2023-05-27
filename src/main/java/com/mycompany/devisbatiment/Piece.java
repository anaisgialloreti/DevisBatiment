package com.mycompany.devisbatiment;

public class Piece {
    
    public int nbPiece;
    public double hauteurPlafond;
    public String[] nomPiece;
    public int[] nbMur;
    public int[] nbFenetre;
    public int[] nbPorte;
    public static int nbOuvertureFenetre[][];
    public static int nbOuverturePorte[][];

    public static int demanderNombrePiece(int nbPiece) {
        System.out.print("Combien de pièces dans votre habitation ? ");
        nbPiece = Lire.i();
        return nbPiece;
    }

    public static double demanderInfoPiece(int nbPiece, int[][] nbOuvertureFenetre, int[][] nbOuverturePorte, String[] nomPiece, int[] nbMur, int[] nbFenetre, int[] nbPorte, double hauteurPlafond) {
        for (int i = 0; i < nbPiece; i++) {

            System.out.println("Nom de la pièce n° " + (i + 1) + " ?");
            nomPiece[i] = Lire.S();

            System.out.println("Nombre de fenêtres ?");
            nbFenetre[i] = Lire.i();
            
            System.out.println("Nombre de portes ?");
            nbPorte[i] = Lire.i();
        }
        
        System.out.println("Hauteur sous plafond en mètre ?");
        hauteurPlafond = Lire.d();
        return hauteurPlafond;
    }

    public static void afficherInfoPiece(int nbPiece, String[] nomPiece, int[] nbMur, int[] nbFenetre, int[] nbPorte, double hauteurPlafond) {
        System.out.println();
        System.out.println("Informations sur les pièces de la maison :");
        System.out.println();
        for (int i = 0; i < nbPiece; i++) {
            System.out.println("Pièce : " + nomPiece[i]);
            System.out.println("Nombre de murs : " + nbMur[i]);
            System.out.println("Nombre de fenêtres : " + nbFenetre[i]);
            System.out.println("Nombre de portes : " + nbPorte[i]);
            System.out.println();
        }
        System.out.println("Hauteur sous plafond : " + hauteurPlafond + " mètres");
        System.out.println();
    }
}
