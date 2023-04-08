package dev.dustinb.MiWeatherApp.rest;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WeatherRest {


    @PostMapping("/weather")
    public void saveWeather(@RequestBody JsonNode payload){
        System.out.println(payload);
    }


}
