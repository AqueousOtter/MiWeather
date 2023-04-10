package dev.dustinb.MiWeatherHistory.repository;


import dev.dustinb.MiWeatherHistory.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepo extends JpaRepository<Weather, Integer > {

}
