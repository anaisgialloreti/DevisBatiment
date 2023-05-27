package com.mycompany.devisbatiment;

public class Mur {
    
    public static int nbPiece;
    public static double hauteurPlafond;
    public static double surfacePorte = 1.89;
    public static double surfaceFenetre = 1.44;
    public static String[] nomPiece;
    public static int[] nbMur;
    public static int[] nbFenetre;
    public static int[] nbPorte;
    public static int nbOuvertureMur[][];
    public static double[][] largeurMur;
    public static double[][] surfaceMur;
    public static int nbOuvertureFenetre[][];
    public static int nbOuverturePorte[][];
    

    public static void calculerSurfaceMur(int nbPiece, int[] nbFenetre, int[] nbPorte, String[] nomPiece, int[] nbMur, double[][] largeurMur, double hauteurPlafond, double[][] surfaceMur, double surfaceFenetre, double surfacePorte, int[][] nbOuvertureFenetre, int[][] nbOuverturePorte) {
        for (int i = 0; i < nbPiece; i++) {
            System.out.println("Pour la pièce : " + nomPiece[i] + ", donnez la longueur du mur n°1 en mètre");
            largeurMur[i][0] = Lire.d();
            largeurMur[i][2] = largeurMur[i][0];
            System.out.println("Pour la pièce : " + nomPiece[i] + ", donnez la longueur du mur n°2 en mètre");
            largeurMur[i][1] = Lire.d();
            largeurMur[i][3] = largeurMur[i][1];
        }
        double surface=0;
        
        for (int i = 0; i < nbPiece; i++) {
            for (int j = 0; j < nbMur[i]; j++) {
                surface = hauteurPlafond * largeurMur[i][j];

                if (nbOuvertureFenetre[i][j] == 1) {
                    surface -= surfaceFenetre;
                }

                if (nbOuverturePorte[i][j] == 1) {
                    surface -= surfacePorte;
                }

                surfaceMur[i][j] = surface;
            }
        }
    }

    public static void afficherSurfaceMur(int nbPiece, int[] nbMur, String[] nomPiece, double[][] surfaceMur) {
        for (int i = 0; i < nbPiece; i++) {
            for (int j = 0; j < nbMur[i]; j++) {
                System.out.println("Pièce : " + nomPiece[i]);
                System.out.println("Le mur n° " + (j + 1) + " a une surface de " + surfaceMur[i][j] + " mètre carré.");
            }
        }
    }
    
}
