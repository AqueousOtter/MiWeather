package dev.dustinb.MiWeatherApp.rest;

import dev.dustinb.MiWeatherApp.entity.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.WeatherService;


@RestController
@RequestMapping("/api")
public class WeatherRest {

    private WeatherService weatherService;

    @Autowired
    public WeatherRest(WeatherService theWeatherService){
        weatherService = theWeatherService;
    }

    @PostMapping("/weather")
    public void saveWeather(@RequestBody Weather payload){
        weatherService.save(payload);

    }


}
