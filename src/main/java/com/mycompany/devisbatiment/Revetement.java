package com.mycompany.devisbatiment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Revetement {

    private int idRevetement;
    private String designation;
    private Boolean pourMur;
    private Boolean pourSol;
    private Boolean pourPlafond;
    private double prixUnitaire;

    public Revetement(int idRevetement, String designation, Boolean pourMur, Boolean pourSol, Boolean pourPlafond, double prixUnitaire) {
        this.idRevetement = idRevetement;
        this.designation = designation;
        this.pourMur = pourMur;
        this.pourSol = pourSol;
        this.pourPlafond = pourPlafond;
        this.prixUnitaire = prixUnitaire;
    }

    public int getIdRevetement() {
        return idRevetement;
    }

    public void setIdRevetement(int idRevetement) {
        this.idRevetement = idRevetement;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Boolean getPourMur() {
        return pourMur;
    }

    public void setPourMur(Boolean pourMur) {
        this.pourMur = pourMur;
    }

    public Boolean getPourSol() {
        return pourSol;
    }

    public void setPourSol(Boolean pourSol) {
        this.pourSol = pourSol;
    }

    public Boolean getPourPlafond() {
        return pourPlafond;
    }

    public void setPourPlafond(Boolean pourPlafond) {
        this.pourPlafond = pourPlafond;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public static ArrayList<Revetement> liste_revetements(String filepath) throws FileNotFoundException, IOException {

        ArrayList<Revetement> out = new ArrayList<Revetement>();

//        try {
        File file = new File(filepath);
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
        BufferedReader br = new BufferedReader(isr);
        String line;
        ArrayList<String> linesList = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            linesList.add(line);
        }
        String attribut = "";
        ArrayList<ArrayList<String>> revetementsStr = new ArrayList<>();
        ArrayList<String> attributsRevetement = new ArrayList<>();
        for (int i = 1; i < linesList.size(); i++) {
            attributsRevetement = new ArrayList<>();
            System.out.println("");
            char[] caracteres = linesList.get(i).toCharArray();
            for (int j = 0; j < caracteres.length; j++) {
                if (caracteres[j] != ';') {
                    attribut += caracteres[j];
                } else {
                    attributsRevetement.add(attribut);
                    System.out.println(attribut);
                    attribut = "";
                }

            }
            revetementsStr.add(attributsRevetement);
        }

        for (int i = 0; i < revetementsStr.size(); i++) {

            int id = Integer.parseInt(revetementsStr.get(i).get(0));
            String designation = revetementsStr.get(i).get(1);
            Boolean pourMur = Integer.parseInt(revetementsStr.get(i).get(2)) == 1;
            Boolean pourSol = Integer.parseInt(revetementsStr.get(i).get(3)) == 1;
            Boolean pourPlafond = Integer.parseInt(revetementsStr.get(i).get(4)) == 1;
            double prixUnitaire = Double.parseDouble(revetementsStr.get(i).get(5));

            Revetement revetement = new Revetement(id, designation, pourMur, pourSol, pourPlafond, prixUnitaire);
            out.add(revetement);
//            }

//        } catch (Exception e) {
//            System.out.println(e);
//            return null;
        }
        return (out);

    }

    @Override
    public String toString() {
        return "revetement" + "id=" + idRevetement + ", designation=" + designation + ", prixUnitaire=" + prixUnitaire + '}';
    }

}
