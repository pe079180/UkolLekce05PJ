package com.engeto.lekce5pj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                String lineStr = scanner.nextLine();
                lineNumber++;
                try {
                    this.addPlant(Plant.parse(lineStr, delimiter));
                } catch (PlantException e) {
                    throw new PlantException("Incorrect input in file "+fileName+" line "+lineNumber+":\n\t"+e.getLocalizedMessage());
                }
            }
        } catch (FileNotFoundException e) {
            throw new PlantException("File "+fileName+" not found: "+e.getLocalizedMessage());
        }
    }

    public void storePlantListToFile(String fileName, String delimiter)  throws PlantException{
        int lineNumber = 0;
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))){
            for (Plant plant : plantList) {
                String lineString = plant.formatToOutput(delimiter);
                writer.println(lineString);
                lineNumber++;
            }
        } catch (IOException e) {
            throw new PlantException("Error when writing to : "+fileName+" line "+lineNumber+": "+e.getLocalizedMessage());
        }

    }
}
