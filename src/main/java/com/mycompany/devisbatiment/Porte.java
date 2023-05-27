package com.mycompany.devisbatiment;

public class Porte {
    
    public static int nbPiece;
    public static double surfacePorte = 1.89;
    public static int[] nbPorte;
    public int[] nbMur;
    public static int nbOuverturePorte[][];
    public String[] nomPiece;
    
    public static void demanderPositionOuverturePorte(int nbPiece, int[] nbPorte, int[] nbMur, String[] nomPiece, int[][] nbOuverturePorte) {
        for (int i = 0; i < nbPiece; i++) {
            System.out.println();
            System.out.println("Pour la pièce "+nomPiece[i]+" Vous avez choisi "+nbPorte[i]+" porte(s) :");
            
            int portesRestantes = nbPorte[i];
            while (portesRestantes > 0) {
                for (int j = 0; j < nbMur[i]; j++) {
                    System.out.println("Y a t-il une fenêtre sur le mur n°" + (j + 1) + " : 0 pour non, 1 pour oui");
                    nbOuverturePorte[i][j] = Lire.i();
                    if (nbOuverturePorte[i][j] == 1) {
                        portesRestantes--;
                    }
                }
            }
        }
    }
    
}
