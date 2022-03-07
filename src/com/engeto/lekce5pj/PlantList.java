package com.engeto.lekce5pj;

import java.util.ArrayList;
import java.util.List;

public class PlantList {
    List<Plant> plantList = new ArrayList<>();

    public void addPlant( Plant plant){
        plantList.add(plant);
    }

    public Plant getPlant (int index){
        // todo create copy of plant
    return  plantList.get( index);
    }

    public void loadFromFile(String filename, String delimiter) {
    }

    public void loadToFile(String filename, String delimiter) {
    }
}
