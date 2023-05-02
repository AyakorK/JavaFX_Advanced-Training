package com.example.demo.Model;

import java.util.Date;

public class Voiture extends MoyenDeTransport {
    public Voiture(String couleur, String reference, int nbRoues, int nbAilerons, int nbAiles, String carburant, int vitesseMax, int dateDeMiseEnCirculation) {
        super(couleur, reference, nbRoues, nbAilerons, nbAiles, carburant, vitesseMax, dateDeMiseEnCirculation);
    }

    public String toString() {
        return "Voiture{" +
                "couleur='" + getCouleur() + '\'' +
                ", reference='" + getReference() + '\'' +
                ", nbRoues=" + getNbRoues() +
                ", nbAilerons=" + getNbAilerons() +
                ", nbAiles=" + getNbAiles() +
                ", carburant='" + getCarburant() + '\'' +
                ", vitesseMax=" + getVitesseMax() +
                ", dateDeMiseEnCirculation=" + getDateDeMiseEnCirculation() +
                '}';
    }

    @Override
    public String demarrer() {
        return "Je démarre avec la clé";
    }

    @Override
    public String accelerer() {
        return "J'appuie sur l'accélérateur";
    }

    public String freiner() {
        return "J'appuie sur le frein";
    }
}
