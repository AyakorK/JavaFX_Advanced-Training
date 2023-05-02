package com.example.demo.Model;

public class Avion extends MoyenDeTransport {
    public Avion(String couleur, String reference, int nbRoues, int nbAilerons, int nbAiles, String carburant, int vitesseMax, int dateDeMiseEnCirculation) {
        super(couleur, reference, nbRoues, nbAilerons, nbAiles, carburant, vitesseMax, dateDeMiseEnCirculation);
    }

    public String toString() {
        return "Avion{" +
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
    // Override the function demarrer
    @Override
    public String demarrer() {
        return "Je démarre avec le manche";
    }

    public String accelerer() {
        return "J'appuie sur le manche";
    }

    public String freiner() {
        return "J'appuie sur le manche";
    }
}
