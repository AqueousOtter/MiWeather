package dev.dustinb.MiWeatherHistory.rest;


import dev.dustinb.MiWeatherHistory.entity.Weather;
import dev.dustinb.MiWeatherHistory.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
