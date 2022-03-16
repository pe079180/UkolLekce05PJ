package com.engeto.lekce5pj;

import java.util.ArrayList;
import java.util.List;

public class PlantList {
    List<Plant> plantList = new ArrayList<>();

    public void addPlant(Plant plant) {
        plantList.add(plant);
    }

    public Plant getPlant(int index) {
        //  create copy of plant
        Plant indexPlant = plantList.get(index);
        return new Plant(indexPlant.getName(), indexPlant.getNotes(), indexPlant.getPlantedDate(), indexPlant.getLastWateringDate(), indexPlant.getFrequencyOfWatering());
        // return plantList.get(index);
    }

    public void removePlant(int index){
        plantList.remove(index);
    }

    public void loadPlantListFromFile(String fileName, String delimiter) throws PlantException {

    }

    public void storePlantListToFile(String fileName, String delimiter) {
    }
}
