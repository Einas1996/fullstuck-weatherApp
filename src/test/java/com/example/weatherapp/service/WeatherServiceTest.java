package com.example.weatherapp.service;
import static org.junit.jupiter.api.Assertions.*;
import com.example.weatherapp.model.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;

public class WeatherServiceTest {
    private WeatherService weatherService;

    // Voordat we elke test uitvoeren, initialiseren we de WeatherService en mocken we de data
    @BeforeEach
    public void setUp() {
        weatherService = new WeatherService();

        // We overschrijven de weatherData van de service met onze eigen mock data
        // Gebruik de setter om de weatherData te overschrijven met mock data
        weatherService.setWeatherData(Arrays.asList(
                new Weather("Amsterdam", 15.5, "Clear sky"),
                new Weather("Rotterdam", 18.3, "Cloudy"),
                new Weather("Utrecht", 17.0, "Rainy")
        ));
    }

    // Test voor het ophalen van alle weerdata
    @Test
    public void testGetAllWeather() {
        List<Weather> allWeather = weatherService.getAllWeather();

        assertNotNull(allWeather); // Controleer of de lijst niet null is
        assertEquals(3, allWeather.size()); // Controleer of er 3 items zijn in de lijst
    }

    // Test voor het ophalen van weerdata op basis van een stad die bestaat
    @Test
    public void testGetWeatherByCity() {
        Weather weather = weatherService.getWeatherByCity("Amsterdam");

        assertNotNull(weather); // Controleer of er data is voor Amsterdam
        assertEquals("Amsterdam", weather.getCityName()); // Controleer of de stadnaam klopt
        assertEquals(15.5, weather.getTemperature()); // Controleer de temperatuur
        assertEquals("Clear sky", weather.getDescription()); // Controleer de beschrijving
    }

    // Test voor het ophalen van weerdata op basis van een stad die niet bestaat
    @Test
    public void testGetWeatherByCityNotFound() {
        Weather weather = weatherService.getWeatherByCity("NonExistentCity");

        assertNull(weather); // Controleer dat de methode null retourneert als de stad niet bestaat
    }
}
