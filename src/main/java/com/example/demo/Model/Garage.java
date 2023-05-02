package com.example.demo.Model;

public class Garage {
//    private MoyenDeTransport[] voitures;
//    private MoyenDeTransport[] avions;
    private MoyenDeTransport[] transports;

    public Garage(MoyenDeTransport[] transports) {
//        this.voitures = voitures;
//        this.avions = avions;
        this.transports = transports;
    }

    public MoyenDeTransport[] getTransports() {
        return transports;
    }

    public void setTransports(MoyenDeTransport[] transports) {
        this.transports = transports;
    }

    public void addTransport(MoyenDeTransport transport) {
        MoyenDeTransport[] newTransports = new MoyenDeTransport[transports.length + 1];
        for (int i = 0; i < transports.length; i++) {
            newTransports[i] = transports[i];
        }
        newTransports[transports.length] = transport;
        transports = newTransports;
    }

//    public MoyenDeTransport[] getVoitures() {
//        return voitures;
//    }
//
//    public MoyenDeTransport[] getAvions() {
//        return avions;
//    }

//    public void setVoitures(MoyenDeTransport[] voitures) {
//        this.voitures = voitures;
//    }
//
//    public void setAvions(MoyenDeTransport[] avions) {
//        this.avions = avions;
//    }

//    public void addVoiture(Voiture voiture) {
//        MoyenDeTransport[] newVoitures = new MoyenDeTransport[voitures.length + 1];
//        for (int i = 0; i < voitures.length; i++) {
//            newVoitures[i] = voitures[i];
//        }
//        newVoitures[voitures.length] = voiture;
//        voitures = newVoitures;
//    }
//
//    public void addAvion(Avion avion) {
//        MoyenDeTransport[] newAvions = new MoyenDeTransport[avions.length + 1];
//        for (int i = 0; i < avions.length; i++) {
//            newAvions[i] = avions[i];
//        }
//        newAvions[avions.length] = avion;
//        avions = newAvions;
//    }



}
