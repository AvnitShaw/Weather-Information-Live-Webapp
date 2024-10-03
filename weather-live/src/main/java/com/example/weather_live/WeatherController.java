package com.example.weather_live;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String home() {
        return "index";  // Ensure "index.html" is in the "templates" folder for Thymeleaf
    }

    @GetMapping("/weather")
    public String getWeather(@RequestParam("city") String city, Model model) {
        String weatherData = weatherService.getWeather(city);
        model.addAttribute("weatherData", weatherData);
        return "index";  // This will reload the index page with data passed in the model
    }
}
