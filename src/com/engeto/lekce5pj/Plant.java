package com.engeto.lekce5pj;

import java.time.LocalDate;

public class Plant {
    private String name;
    private String notes;
    private LocalDate plantedDate;
    private LocalDate wateringDate;
    private Integer frequencyOfWatering;

    public Plant(String name, String notes, LocalDate plantedDate, LocalDate wateringDate, Integer frequencyOfWatering)  {
        this.name = name;
        this.notes = notes;
        this.plantedDate = plantedDate;
        this.wateringDate = wateringDate;
//        if (frequencyOfWatering <= 0) {
//            throw new PlantException("Unexpected  frequencyOfWatering " + frequencyOfWatering);
//        }
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public Plant(String name, LocalDate plantedDate, Integer frequencyOfWatering) {
//        try {
            this(name, null, plantedDate, LocalDate.now(), frequencyOfWatering);
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

    public LocalDate getWateringDate() {
        return wateringDate;
    }

    public void setWateringDate(LocalDate wateringDate) {
        this.wateringDate = wateringDate;
    }

    public Integer getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(Integer frequencyOfWatering) {
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public String getWateringInfo() {
        return name + ", watered " + wateringDate + ", recomended watering " + wateringDate.plusDays(frequencyOfWatering);
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", notes='" + notes + '\'' +
                ", plantedDate=" + plantedDate +
                ", wateringDate=" + wateringDate +
                ", frequencyOfWatering=" + frequencyOfWatering +
                '}';
    }
}
