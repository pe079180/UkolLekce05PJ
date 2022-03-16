package com.engeto.lekce5pj;

import java.time.LocalDate;

public class Main {
    public static final String DELIMITER = ";";
    public static final String FROM_FILE = "kvetiny.txt";
    //    public static final String FROM_FILE = "kvetiny-spatne-datum.txt";
    //    public static final String FROM_FILE = "kvetiny-spatne-frekvence.txt";
    public static final String TO_FILE = "vystup.txt";


    public static void main(String[] args) {
        PlantList plantList = new PlantList();

//        test only
//        Plant plant1 = new Plant("Růže");
//        System.out.println(plant1.toString());
//        System.out.println(plant1.getWateringInfo());
//        plantList.addPlant(plant1);
        plantList.addPlant(new Plant("Lilie"));

        // task 12 Načtěte seznam květin ze souboru kvetiny.txt
        try {

            plantList.loadPlantListFromFile(FROM_FILE, DELIMITER);
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }

//       test
//        for (Plant plant : plantList.plantList
//        ) {
//            System.out.println(plant);
//        }

        //  task 13. Vypište na obrazovku informace o zálivce pro všechny květiny.
        for (Plant plant : plantList.plantList
        ) {
            System.out.println(plant.getWateringInfo());
        }

        //  task 14. Přidejte dvě nové květiny do seznamu. Jednu květinu odeberte.
        plantList.addPlant(new Plant("Karafiát"));
        plantList.addPlant(new Plant("Astra", LocalDate.now(),5));
        plantList.removePlant(1);

        //       test
        for (Plant plant : plantList.plantList
        ) {
            System.out.println(plant);
        }


// test
//        System.out.println(plantList.getPlant(0));


    }
}
