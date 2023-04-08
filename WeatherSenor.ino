
#include <WiFi.h>
#include <HTTPClient.h>
#include <Wire.h>
#include <SPI.h>
#include <Adafruit_Sensor.h>
#include <Adafruit_BME280.h>

#define BME_SCK 13
#define BME_MISO 12
#define BME_MOSI 11
#define BME_CS 10

#define SEALEVELPRESSURE_HPA (1032.65)

Adafruit_BME280 bme; // I2C

const char* ssid = "00oo00";
const char* password = "9902246927";

//Your Domain name with URL path or IP address with path
const char* serverName = "http://192.168.0.14:8090/api/weather";

// the following variables are unsigned longs because the time, measured in
// milliseconds, will quickly become a bigger number than can be stored in an int.
unsigned long lastTime = 0;
// Timer set to 10 minutes (600000)
//unsigned long timerDelay = 600000;
// Set timer to 5 seconds (5000)
unsigned long timerDelay = 6000;

void setup() {
  Serial.begin(9600);
  while(!Serial);    // time to get serial running
  Serial.println(F("BME280 test"));

  unsigned status;
    
    // default settings
  status = bme.begin(0x76);  
  Serial.begin(115200);

  WiFi.begin(ssid, password);
  Serial.println("Connecting");
  while(WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.print("Connected to WiFi network with IP Address: ");
  Serial.println(WiFi.localIP());
 
  Serial.println("Timer set to 5 seconds (timerDelay variable), it will take 5 seconds before publishing the first reading.");
}

void loop() {
  
  //Send an HTTP POST request every 10 minutes
  if ((millis() - lastTime) > timerDelay) {
    
    //Check WiFi connection status
    if(WiFi.status()== WL_CONNECTED){
      WiFiClient client;
      HTTPClient http;
  
    
      // Your Domain name with URL path or IP address with path
      http.begin(client, serverName);
      float temp = bme.readTemperature();
      Serial.print(bme.readTemperature());
      float humid = bme.readHumidity();
      float pressure = bme.readPressure() / 100.0;

      //If you need an HTTP request with a content type: application/json, use the following:
      http.addHeader("Content-Type", "application/json");
      String payload = "{\"temperature\":" + String(temp) + ",\"humidity\":" + String(humid) + ",\"pressure\":" + String(pressure) + "}";
      int httpResponseCode = http.POST(payload);

     
      Serial.print("HTTP Response code: ");
      Serial.println(httpResponseCode);
        
      // Free resources
      http.end();
    }
    else {
      Serial.println("WiFi Disconnected");
    }
    lastTime = millis();
  }
}
void getValues(){
      
}

