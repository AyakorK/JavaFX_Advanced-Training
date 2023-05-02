package com.example.demo;

import com.example.demo.Model.Avion;
import com.example.demo.Model.Garage;
import com.example.demo.Model.MoyenDeTransport;
import com.example.demo.Model.Voiture;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Home {
    public static void main(String args[])
    {
//        FormApplication.main(args);

        List<MoyenDeTransport> carsList = Arrays.asList(
                new Voiture("rouge", "Peugeot", 4, 0, 0, "essence", 120, 2003),
                new Voiture("bleu", "Renault", 4, 0, 0, "diesel", 230, 1980),
                new Voiture("vert", "Clio", 4, 0, 0, "essence", 102, 1992),
                new Voiture("jaune", "Ferrari", 4, 0, 0, "diesel", 304, 2000),
                new Voiture("bleu", "Mazeratti", 4, 0, 0, "essence", 250, 2005),
                new Voiture("bleu", "Lamborghini", 4, 0, 0, "essence", 220, 2022),
                new Voiture("bleu", "Audi", 4, 0, 0, "essence", 180, 2010),
                new Voiture("bleu", "Mercedes AMG", 4, 0, 0, "essence", 100, 2021),
                new Voiture("bleu", "Clio", 4, 0, 0, "essence", 80, 2014),
                new Voiture("bleu", "Haas", 4, 0, 0, "essence", 110, 2013),
                new Voiture("bleu", "RB19", 4, 0, 0, "essence", 3200, 2022),
                new Voiture("bleu", "Mercedes", 4, 0, 0, "essence", 290, 2023),
                new Voiture("bleu", "Aston Martin", 4, 0, 0, "essence", 310, 1920),
                new Voiture("bleu", "RB18", 4, 0, 0, "essence", 320, 1980),
                new Voiture("bleu", "Williams", 4, 0, 0, "essence", 85, 2003)
        );

        List<MoyenDeTransport> planesList = Arrays.asList(
                new Avion("rouge", "Airbus", 3, 2, 2, "kerosene", 1400, 1923),
                new Avion("bleu", "Antonov", 3, 2, 2, "watah", 800, 1972),
                new Avion("vert", "ATR", 3, 2, 2, "kerosene", 1300, 1940),
                new Avion("jaune", "BAE Systems", 3, 2, 2, "watah", 1200, 2003),
                new Avion("bleu", "Boeing", 3, 2, 2, "kerosene", 1000, 2005),
                new Avion("bleu", "Bombardier", 3, 2, 2, "kerosene", 980, 2005),
                new Avion("bleu", "Bristol", 3, 2, 2, "kerosene", 960, 2005),
                new Avion("bleu", "ATR 72", 3, 2, 2, "kerosene", 920, 2005),
                new Avion("bleu", "CRJ-705", 3, 2, 2, "kerosene", 1203, 2005),
                new Avion("bleu", "CR-929", 3, 2, 2, "kerosene", 1102, 2005),
                new Avion("bleu", "DH-95", 3, 2, 2, "kerosene", 1104, 2005),
                new Avion("bleu", "Concorde", 3, 2, 2, "kerosene", 4023, 2005),
                new Avion("bleu", "Fokker F100", 3, 2, 2, "kerosene", 230, 2005),
                new Avion("bleu", "Gulfstream", 3, 2, 2, "kerosene", 1023, 2005)
        );

        MoyenDeTransport[] cars = planesList.toArray(new MoyenDeTransport[0]);
        MoyenDeTransport[] planes = carsList.toArray(new MoyenDeTransport[0]);

        Garage carsGarage = new Garage(cars);
        Garage planesGarage = new Garage(planes);

        fastVehicles(carsGarage, planesGarage);
        fastVehicles(carsGarage, null);
        fastVehicles(planesGarage, null);

        // sort 10 best Vehicles by Speed

        sortVehiclesBySpeed(carsGarage, planesGarage);
        sortVehiclesBySpeed(carsGarage, null);
        sortVehiclesBySpeed(planesGarage, null);

        // Sum of Years of Vehicles

        sumOfYears(carsGarage, planesGarage);
        sumOfYears(carsGarage, null);
        sumOfYears(planesGarage, null);


    }


    public static void fastVehicles(Garage garage, Garage garage2) {
        List<MoyenDeTransport> fastTransports;
        if (garage2 == null) {
            fastTransports = Arrays.stream(garage.getTransports())
                    .filter(transport -> transport.getVitesseMax() > 200)
                    .toList();
        } else {
            fastTransports = Stream.of(garage.getTransports(), garage2.getTransports())
                    .flatMap(Arrays::stream)
                    .filter(transport -> transport.getVitesseMax() > 200)
                    .toList();
        }

        if (fastTransports.size() == 0) {
            System.out.println("Aucun véhicule rapide");
        } else if (fastTransports.get(0) instanceof Voiture && fastTransports.stream().allMatch(transport -> transport instanceof Voiture)) {
            System.out.println("Voitures rapides : " + fastTransports.size());
        } else if (fastTransports.get(0) instanceof Avion && fastTransports.stream().allMatch(transport -> transport instanceof Avion)) {
            System.out.println("Avions rapides : " + fastTransports.size());
        } else {
            System.out.println("Véhicules rapides : " + fastTransports.size());
        }

        if (garage2 == null) {
            Arrays.stream(garage.getTransports())
                    .filter(transport -> transport.getVitesseMax() > 200)
                    .sorted((transport1, transport2) -> transport2.getVitesseMax() - transport1.getVitesseMax())
                    .map(MoyenDeTransport::getReference)
                    .forEach(System.out::println);
        } else {
            Stream.of(garage.getTransports(), garage2.getTransports())
                    .flatMap(Arrays::stream)
                    .filter(transport -> transport.getVitesseMax() > 200)
                    .sorted((transport1, transport2) -> transport2.getVitesseMax() - transport1.getVitesseMax())
                    .map(MoyenDeTransport::getReference)
                    .forEach(System.out::println);
        }
        System.out.println("-------------------");
    }

    public static void sortVehiclesBySpeed(Garage garage, Garage garage2) {
        List<MoyenDeTransport> sortTransports;
        if(garage2 == null) {
            sortTransports = Arrays.stream(garage.getTransports())
                    .sorted((transport1, transport2) -> transport2.getVitesseMax() - transport1.getVitesseMax())
                    .toList();
        } else {
           sortTransports = Stream.of(garage.getTransports(), garage2.getTransports())
                    .flatMap(Arrays::stream)
                    .sorted((transport1, transport2) -> transport2.getVitesseMax() - transport1.getVitesseMax())
                    .toList();
        }

        if (sortTransports.size() == 0) {
            System.out.println("Aucun véhicule rapide");
        } else if (sortTransports.get(0) instanceof Voiture && sortTransports.stream().allMatch(transport -> transport instanceof Voiture)) {
            System.out.println("Classement des voitures");
        } else if (sortTransports.get(0) instanceof Avion && sortTransports.stream().allMatch(transport -> transport instanceof Avion)) {
            System.out.println("Classement des avions");
        } else {
            System.out.println("Classement des véhicules");
        }

        if (garage2 == null) {
            Arrays.stream(garage.getTransports())
                    .sorted((transport1, transport2) -> transport2.getVitesseMax() - transport1.getVitesseMax())
                    .limit(10)
                    .forEach(transport -> System.out.println(transport.getReference()));
        } else {
            Stream.of(garage.getTransports(), garage2.getTransports())
                    .flatMap(Arrays::stream)
                    .sorted((transport1, transport2) -> transport2.getVitesseMax() - transport1.getVitesseMax())
                    .limit(10)
                    .forEach(transport -> System.out.println(transport.getReference()));
        }


        System.out.println("-------------------");
    }

    public static void sumOfYears(Garage garage, Garage garage2) {
        List<MoyenDeTransport> transports;
        if(garage2 == null) {
            transports = Arrays.stream(garage.getTransports())
                    .toList();
        } else {
            transports = Stream.of(garage.getTransports(), garage2.getTransports())
                    .flatMap(Arrays::stream)
                    .toList();
        }

        if (transports.size() == 0) {
            System.out.println("Aucun Véhicule enregistré");
            return;
        } else if (transports.get(0) instanceof Voiture && transports.stream().allMatch(transport -> transport instanceof Voiture)) {
            System.out.println("Voitures");
        } else if (transports.get(0) instanceof Avion && transports.stream().allMatch(transport -> transport instanceof Avion)) {
            System.out.println("Avions");
        } else {
            System.out.println("Véhicules");
        }

        int sumYears;
        if (garage2 == null) {
            sumYears = Arrays.stream(garage.getTransports())
                    .reduce(0, (sum, transport) -> sum + transport.getDateDeMiseEnCirculation(), Integer::sum);

        } else {
            sumYears = Stream.of(garage.getTransports(), garage2.getTransports())
                    .flatMap(Arrays::stream)
                    .reduce(0, (sum, transport) -> sum + transport.getDateDeMiseEnCirculation(), Integer::sum);
        }

        System.out.println("Somme des années : " + sumYears);
        System.out.println("-------------------");
    }


}
