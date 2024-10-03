package com.example.weather_live;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final String apiKey = "e56eb45753eaff6735d7786c68312c36";  // Your API key
    private final String weatherUrl = "https://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}&units=metric";

    public String getWeather(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(weatherUrl, String.class, city, apiKey);

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode json = mapper.readTree(response);
            System.out.println("Weather data: " + json);  // Add this line for debugging
            return json.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
