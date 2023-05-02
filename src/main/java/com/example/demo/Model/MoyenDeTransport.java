package com.example.demo.Model;

import java.util.Date;

public class MoyenDeTransport {
    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getNbRoues() {
        return nbRoues;
    }

    public void setNbRoues(int nbRoues) {
        this.nbRoues = nbRoues;
    }

    public int getNbAilerons() {
        return nbAilerons;
    }

    public void setNbAilerons(int nbAilerons) {
        this.nbAilerons = nbAilerons;
    }

    public int getNbAiles() {
        return nbAiles;
    }

    public void setNbAiles(int nbAiles) {
        this.nbAiles = nbAiles;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }


    public int getVitesseMax() {
        return vitesseMax;
    }

    public void setVitesseMax(int vitesseMax) {
        this.vitesseMax = vitesseMax;
    }

    public int getDateDeMiseEnCirculation() {
        return dateDeMiseEnCirculation;
    }

    public void setDateDeMiseEnCirculation(int dateDeMiseEnCirculation) {
        this.dateDeMiseEnCirculation = dateDeMiseEnCirculation;
    }

    private String couleur;
    private String reference;
    private int nbRoues;
    private int nbAilerons;
    private int nbAiles;
    private String carburant;
    private int vitesseMax;

    private int dateDeMiseEnCirculation;


    public MoyenDeTransport(String couleur, String reference, int nbRoues, int nbAilerons, int nbAiles, String carburant, int vitesseMax, int dateDeMiseEnCirculation) {
        this.couleur = couleur;
        this.reference = reference;
        this.nbRoues = nbRoues;
        this.nbAilerons = nbAilerons;
        this.nbAiles = nbAiles;
        this.carburant = carburant;
        this.vitesseMax = vitesseMax;
        this.dateDeMiseEnCirculation = dateDeMiseEnCirculation;
    }

    // Create some methods abstract
    public String demarrer() {
        return null;
    }

    public String accelerer() {
        return null;
    }

    public String freiner() {
        return null;
    }


}
