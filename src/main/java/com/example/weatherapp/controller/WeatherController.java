package com.example.weatherapp.controller;

import com.example.weatherapp.model.Weather;
import com.example.weatherapp.service.WeatherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/all")
    public List<Weather> getAllWeather() {
        return weatherService.getAllWeather();
    }

    @GetMapping("/city/{cityName}")
    public Weather getWeatherByCity(@PathVariable String cityName) {
        return weatherService.getWeatherByCity(cityName);
    }
}
