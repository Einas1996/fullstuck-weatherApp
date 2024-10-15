async function getWeatherInfo() {
    // Haal de waarde van het invoerveld op
    const countryInput = document.getElementById('countryInput').value;
    const weatherInfoElement = document.getElementById('weatherInfo');

    // Controleer of er een invoer is
    if (!countryInput) {
        weatherInfoElement.innerHTML = `<p>Please enter a city name.</p>`;
        return;
    }

    try {
        // Fetch de weergegevens van je Spring Boot API
        const response = await fetch(`http://localhost:8080/api/weather/city/${countryInput}`);

        // Controleer of de fetch succesvol was
        if (response.ok) {
            // Haal de JSON-gegevens op uit het antwoord
            const data = await response.json();

            // Update de HTML met de weerinformatie
            weatherInfoElement.innerHTML = `
                <p>Weather in ${data.cityName}:</p>
                <p>Temperature: ${data.temperature} °C</p>
                <p>Description: ${data.description}</p>
            `;
        } else {
            // Als de stad niet gevonden is, toon een foutmelding
            console.error('City not found or error occurred');
            weatherInfoElement.innerHTML = `<p>City not found or error occurred.</p>`;
        }
    } catch (error) {
        console.error('Error fetching weather data:', error);
        weatherInfoElement.innerHTML = '<p>City not found or error occurred.</p>';
    }
}
