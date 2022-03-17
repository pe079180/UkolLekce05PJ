package com.engeto.lekce5pj;

import javafx.util.converter.LocalDateStringConverter;

import java.time.LocalDate;

public class Main {
    public static final String DELIMITER = "\t";
    public static final String FROM_FILE = "kvetiny.txt";
    //    public static final String FROM_FILE = "kvetiny-spatne-datum.txt";
    //    public static final String FROM_FILE = "kvetiny-spatne-frekvence.txt";
    public static final String TO_FILE = "vystup.txt";


    public static void main(String[] args) {
        PlantList plantList = new PlantList();

        // task 12 Načtěte seznam květin ze souboru kvetiny.txt
        try {

            plantList.loadPlantListFromFile(FROM_FILE, DELIMITER);
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }

        //  task 13. Vypište na obrazovku informace o zálivce pro všechny květiny.
        System.out.println();
        System.out.println("--task 13. Vypište  informace o zálivce pro všechny květiny--");
        for (Plant plant : plantList.plantList
        ) {
            System.out.println(plant.getWateringInfo());
        }

        //  task 14. Přidejte dvě nové květiny do seznamu. Jednu květinu odeberte.
        plantList.addPlant(new Plant("Karafiát"));
        plantList.addPlant(new Plant("Astra", LocalDate.now(), 5));
        plantList.addPlant(new Plant("Růže", "červená",LocalDate.of(2020,3,7) ,LocalDate.now(), 14));
        plantList.removePlant(1);

        //  task 15. Uložte seznam květin do nového souboru a ověřte, že je jeho obsah správný.
        try {
            plantList.storePlantListToFile(TO_FILE, DELIMITER);
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }

        //  task 16. Vyzkoušejte opětovné načtení vygenerovaného souboru.
        System.out.println();
        System.out.println("--task 16. Vyzkoušejte opětovné načtení vygenerovaného souboru--");
        PlantList plantList2 = new PlantList();
        try {

            plantList2.loadPlantListFromFile(TO_FILE, DELIMITER);
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }

        System.out.println("--plantlist from output file--");
        for (Plant plant : plantList2.plantList
        ) {
            System.out.println(plant);
        }

        //  task 17. Vyzkoušejte, že se aplikace bude chovat správně při načtení vadného souboru
        System.out.println();
        System.out.println("--task 17:reading from kvetiny-spatne-datum.txt--");
        PlantList plantList3 = new PlantList();
        try {

            plantList2.loadPlantListFromFile("kvetiny-spatne-datum.txt", DELIMITER);
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }

        //  task 18. Vyzkoušejte, že se aplikace bude chovat správně při načtení vadného souboru
        System.out.println();
        System.out.println("--task 18:reading from kvetiny-spatne-frekvence.txt--");
        PlantList plantList4 = new PlantList();
        try {

            plantList2.loadPlantListFromFile("kvetiny-spatne-frekvence.txt", DELIMITER);
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }

        //  task 6. test frekvence zálikvy
        try { plantList.getPlant(1).setFrequencyOfWatering(-1);} catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }

        //  task 7. test datum posledni zálivky
        try { plantList.getPlant(1).setLastWateringDate(LocalDate.of(2000,1,1));} catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }

    }
}
