package com.mycompany.devisbatiment;

import java.io.IOException;

public class Immeuble {
    
    public static int nbNiveau;
    public static int[] nbAppartement;
    public static int nbPiece;
    public static int[] nbMur;
    public static String[] nomPiece;
    public static double[][] prixMur;
    public static double[] prixSol;
    public static double[] prixPlafond;
    public static double prixTotal = 0;

    public static void executerImmeuble(int[] nbAppartement,int nbNiveau) throws IOException {

        nbNiveau = Niveau.demanderNombreNiveau();

        // initialisation tableau
        nbAppartement = new int[nbNiveau];

        Niveau.demanderNombreAppartement(nbNiveau, nbAppartement);

        for (int i = 0; i < nbNiveau; i++) {
            for (int j = 0; j < nbAppartement[i]; j++) {
                Appartement.executerAppartement();
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("DEVIS :");
        System.out.println();
        System.out.println();
        for(int i=0; i< nbNiveau; i++){
            for (int j = 0; j < nbAppartement[i]; j++) {
                System.out.println();
                System.out.println();
                System.out.println("Devis de l'appartement n°"+(j+1)+" au niveau "+(i+1));
                Carrelage.afficherDevisPiece(nbPiece, nbMur, nomPiece, prixMur, prixSol, prixPlafond);
                Carrelage.afficherDevisTotal(nbPiece, nbMur, prixMur, prixSol, prixPlafond, prixTotal);
                System.out.println();
                System.out.println("--------------------------------------------------");
            }
        }
        
        Fichier.afficherDevisImmeuble(nbNiveau, nbAppartement);
    }
    
}
