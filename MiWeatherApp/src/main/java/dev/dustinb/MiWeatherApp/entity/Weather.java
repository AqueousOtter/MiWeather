package dev.dustinb.MiWeatherApp.entity;


import jakarta.persistence.*;

@Entity
@Table(name="miweatherreadings")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int idNo;

    @Column(name = "temperature")
    private float temperature;
    @Column(name = "humidity")
    private float humidity;

    @Column(name = "pressure")
    private float pressure;

    public Weather() {
    }

    public Weather(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
}
