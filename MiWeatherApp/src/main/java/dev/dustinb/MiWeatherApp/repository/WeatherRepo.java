package dev.dustinb.MiWeatherApp.repository;

import dev.dustinb.MiWeatherApp.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepo extends JpaRepository<Weather, Integer > {

}
