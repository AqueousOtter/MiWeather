package services;

import dev.dustinb.MiWeatherApp.entity.Weather;
import dev.dustinb.MiWeatherApp.repository.WeatherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    WeatherRepo weatherRepo;
    public WeatherServiceImpl() {
        // no-args constructor
    }
    @Autowired
    public WeatherServiceImpl(WeatherRepo theweatherRepo){
        weatherRepo = theweatherRepo;
    }



    @Override
    public void save(Weather theWeather) {
        theWeather.convertTemp();
        System.out.println(theWeather);
        weatherRepo.save(theWeather);

    }
}
