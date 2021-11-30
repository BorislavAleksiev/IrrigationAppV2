package com.example.sep4_android;


public class FirebaseHelperClass {

    String username;
    String plantName;
    String yards;
    String waterPerYards;
    String startingDate;
    String harvest;


    public FirebaseHelperClass(String username, String plantName, String yards, String waterPerYards, String startingDate, String harvest) {
        this.username = username;
        this.plantName = plantName;
        this.yards = yards;
        this.waterPerYards = waterPerYards;
        this.startingDate = startingDate;
        this.harvest = harvest;
    }
    public FirebaseHelperClass() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getHarvest() {
        return harvest;
    }

    public void setHarvest(String harvest) {
        this.harvest = harvest;
    }

    public String getYards() {
        return yards;
    }

    public void setYards(String yards) {
        this.yards = yards;
    }

    public String getWaterPerYards() {
        return waterPerYards;
    }

    public void setWaterPerYards(String waterPerYards) {
        this.waterPerYards = waterPerYards;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }



}
