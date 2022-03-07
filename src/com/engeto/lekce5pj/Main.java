package com.engeto.lekce5pj;

public class Main {
    public static final String DELIMITER = ";";

    public static void main(String[] args) {
        PlantList plantList = new PlantList();
        Plant plant1 = new Plant("Růže");
        System.out.println(plant1.toString());
        System.out.println(plant1.getWateringInfo());

        plantList.addPlant(plant1);
        plantList.addPlant(new Plant("Lilie"));

        for (Plant plant : plantList.plantList
        ) {
            System.out.println(plant);
        }

        System.out.println(plantList.getPlant(0));
    }
}
