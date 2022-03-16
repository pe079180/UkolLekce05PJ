package com.engeto.lekce5pj;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Plant {
    private String name;
    private String notes;
    private LocalDate plantedDate;
    private LocalDate lastWateringDate;
    private Integer frequencyOfWatering;

    public Plant(String name, String notes, LocalDate plantedDate, LocalDate lastWateringDate, Integer frequencyOfWatering) {
        this.name = name;
        this.notes = notes;
        this.plantedDate = plantedDate;
        this.lastWateringDate = lastWateringDate;
//        if (frequencyOfWatering <= 0) {
//            throw new PlantException("Unexpected  frequencyOfWatering " + frequencyOfWatering);
//        }
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public Plant(String name, LocalDate plantedDate, Integer frequencyOfWatering) {
//        try {
        this(name, "", plantedDate, LocalDate.now(), frequencyOfWatering);
//        } catch (PlantException e) {
//        }
    }

    public Plant(String name) {
        this(name, LocalDate.now(), 7);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlantedDate() {
        return plantedDate;
    }

    public void setPlantedDate(LocalDate plantedDate) {
        this.plantedDate = plantedDate;
    }

    public LocalDate getLastWateringDate() {
        return lastWateringDate;
    }

    public void setLastWateringDate(LocalDate lastWateringDate) {
        this.lastWateringDate = lastWateringDate;
    }

    public Integer getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(Integer frequencyOfWatering) {
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public String getWateringInfo() {
        return name + ", watered " + lastWateringDate + ", recomended watering " + lastWateringDate.plusDays(frequencyOfWatering);
    }

    public static Plant Parse(String plantStr, String delimiter) throws PlantException {
        String[] attributes = plantStr.split(delimiter);

        if (attributes.length != 5) throw new PlantException("unexpected number of attributes");

        String name = attributes[0];
        String notes = attributes[1];

        try {
            Integer frequencyOfWatering = Integer.parseInt(attributes[2]);
            LocalDate lastWateringDate = LocalDate.parse(attributes[3]);
            LocalDate plantedDate = LocalDate.parse(attributes[4]);

            return new Plant(name, notes, plantedDate, lastWateringDate, frequencyOfWatering);

        } catch (DateTimeParseException e) {
            throw new PlantException("incorrect date in row " + plantStr);
        } catch (NumberFormatException e) {
            throw new PlantException("incorrect number in row " + plantStr);
        }

    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", notes='" + notes + '\'' +
                ", plantedDate=" + plantedDate +
                ", lastWateringDate=" + lastWateringDate +
                ", frequencyOfWatering=" + frequencyOfWatering +
                '}';
    }
}
