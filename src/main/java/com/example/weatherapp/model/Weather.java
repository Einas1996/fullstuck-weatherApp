package com.example.weatherapp.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {
    private String cityName;
    private double temperature;
    private String description;

    // Constructor met @JsonCreator annotatie
    @JsonCreator
    public Weather(
            @JsonProperty("cityName") String cityName,
            @JsonProperty("temperature") double temperature,
            @JsonProperty("description") String description) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.description = description;
    }

    // Getters and Setters
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
