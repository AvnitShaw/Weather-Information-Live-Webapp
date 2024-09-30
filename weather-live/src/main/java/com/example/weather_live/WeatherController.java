package com.example.weather_live;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller

public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("city", "");
        return "index";
    }

    @PostMapping("/weather")
    public String getWeather(@RequestParam("city") String city, Model model) {
        String weatherData = weatherService.getWeather(city);
        model.addAttribute("weatherData", weatherData);
        model.addAttribute("city", city);
        return "index";
    }
}
