package services;

import dev.dustinb.MiWeatherApp.entity.Weather;
import dev.dustinb.MiWeatherApp.repository.WeatherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    WeatherRepo weatherRepo;

    @Autowired
    public WeatherServiceImpl(WeatherRepo theWeatherRepo){
        weatherRepo = theWeatherRepo;
    }
    @Override
    public void save(Weather theWeather) {
        weatherRepo.save(theWeather);

    }
}
