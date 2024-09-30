package com.example.weather_live;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class WeatherService {

    @Value("${e56eb45753eaff6735d7786c68312c36}")
    private String openWeatherApiKey;

    private static final String OPENWEATHER_URL = 
        "https://api.openweathermap.org/data/2.5/weather?q={city}&appid={e56eb45753eaff6735d7786c68312c36}&units=metric";

    public String getWeather(String city) {

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("city", city);
        uriVariables.put("e56eb45753eaff6735d7786c68312c36", openWeatherApiKey);
        
        return restTemplate.getForObject(OPENWEATHER_URL, String.class, uriVariables);
    }
}