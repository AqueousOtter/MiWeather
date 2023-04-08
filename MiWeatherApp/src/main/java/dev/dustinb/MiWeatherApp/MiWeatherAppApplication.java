package dev.dustinb.MiWeatherApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"services", "dev.dustinb.MiWeatherApp.rest", "dev.dustinb.MiWeatherApp.repository"})
public class MiWeatherAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiWeatherAppApplication.class, args);
	}

}
