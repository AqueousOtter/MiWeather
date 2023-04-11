package dev.dustinb.MiWeatherHistory.entity;


import jakarta.persistence.*;

import java.text.DecimalFormat;

@Entity
@Table(name="weather")//weather for pi, miweatherreadings for pc
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int idNo;

    @Column(name = "temperature")
    private String temperature;
    @Column(name = "humidity")
    private String humidity;

    @Column(name = "pressure")
    private String pressure;

    @Column(name = "dew_point")
    private String dewPoint;

    private static final DecimalFormat df = new DecimalFormat("0.00");
    public Weather() {
    }


    public Weather(String temperature, String humidity, String pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public String getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint() {// calculate dew point using temp and humidity
        double theTemperature = Double.parseDouble(this.getTemperature());
        double theHumidity = Double.parseDouble(this.getHumidity());
        this.dewPoint = String.valueOf(df.format(theTemperature - ((100-theHumidity)/5)));
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public void convertTemp(){
        //convert C to F
        double theTempNumber = Double.parseDouble(this.getTemperature());
        this.temperature =  String.valueOf(df.format((theTempNumber * 9/5) + 32));
    }



    @Override
    public String toString() {
        return "Weather{" +
                "idNo=" + idNo +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", pressure='" + pressure + '\'' +
                '}';
    }
}
