package com.mycompany.devisbatiment;

public class Niveau {
    
    public static int nbNiveau;
    public static int[] nbAppartement;
    
    public static int demanderNombreNiveau(){
        System.out.print("Combien de niveau dans votre immeuble ? ");
        nbNiveau = Lire.i();
        return nbNiveau;
    }
    
    public static int demanderNombreAppartement(int nbNiveau, int[] nbAppartement){
        
        for(int i=0; i<nbNiveau; i++){
            System.out.print("Combien d'appartement pour le niveau n°"+(i+1)+" ?");
            nbAppartement[i] = Lire.i();
        }
        return 0;
    }
    
}
