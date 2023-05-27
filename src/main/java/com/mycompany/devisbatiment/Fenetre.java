package com.mycompany.devisbatiment;

public class Fenetre {
    
    public static int nbPiece;
    public static int[] nbFenetre;
    public int[] nbMur;
    public static int nbOuvertureFenetre[][];
    public String[] nomPiece;
    
    public static void demanderPositionOuvertureFenetre(int nbPiece, int[] nbFenetre, int[] nbMur, String[] nomPiece, int[][] nbOuvertureFenetre) {
        for (int i = 0; i < nbPiece; i++) {
            System.out.println();
            System.out.println("Pour la pièce "+nomPiece[i]+" Vous avez choisi "+nbFenetre[i]+" fenêtre(s) :");
            
            int fenetresRestantes = nbFenetre[i];
            while (fenetresRestantes > 0) {
                for (int j = 0; j < nbMur[i]; j++) {
                    System.out.println("Y a t-il une fenêtre sur le mur n°" + (j + 1) + " : 0 pour non, 1 pour oui");
                    nbOuvertureFenetre[i][j] = Lire.i();
                    if (nbOuvertureFenetre[i][j] == 1) {
                        fenetresRestantes--;
                    }
                }
            }
        }
    }
    
}
