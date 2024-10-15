package com.example.weatherapp.service;

import com.example.weatherapp.model.Weather;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class WeatherService {

    private List<Weather> weatherData;

    public WeatherService() {
        loadWeatherData();
    }

    // Voeg een setter toe om de weerdata te kunnen overschrijven in tests
    public void setWeatherData(List<Weather> weatherData) {
        this.weatherData = weatherData;
    }

    // Methode om het JSON-bestand in te lezen
    private void loadWeatherData() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Weather>> typeReference = new TypeReference<>() {};
        InputStream inputStream = getClass().getResourceAsStream("/weather.json");

        try {
            weatherData = mapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not load weather data from JSON file.");
        }
    }

    // Alle weerdata ophalen
    public List<Weather> getAllWeather() {
        return weatherData;
    }

    // Weerdata ophalen op basis van stad
    public Weather getWeatherByCity(String cityName) {
        return weatherData.stream()
                .filter(weather -> weather.getCityName().equalsIgnoreCase(cityName))
                .findFirst()
                .orElse(null);
    }
}

