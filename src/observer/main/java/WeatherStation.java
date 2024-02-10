package observer.main.java;

import observer.main.java.pattern.WeatherObservable;
import observer.main.java.pattern.WeatherObserver;

class CurrentConditionsDisplay implements WeatherObserver, Display {
    private float humidity;
    private float temperature;
    @SuppressWarnings("unused")
    private WeatherObservable weatherData;

    public CurrentConditionsDisplay(WeatherObservable weatherData) {
        this.weatherData = weatherData;
        weatherData.attachObserver(this);
    }

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;

        display();
    }

    public void display() {
        System.out.println("Current weather: { Temperature: " + temperature + "°F, Humidity: " + humidity + " }");
    }
}

class ForecastDisplay implements WeatherObserver, Display {
    private float temperature;
    @SuppressWarnings("unused")
    private WeatherObservable weatherData;

    public ForecastDisplay(WeatherObservable weatherData) {
        this.weatherData = weatherData;
        weatherData.attachObserver(this);
    }

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        display();
    }

    public void display() {
        System.out.print("Forecast: ");

        if (temperature < 80) {
            System.out.println("Improving weather soon!");
        } else {
            System.out.println("Weather might be a bit hot!");
        }
    }
}

class StatisticsDisplay implements WeatherObserver, Display {
    private Float maxTemperature;
    private Float minTemperature;

    private Float temperatureSum = 0.0f;
    private Integer temperatureSampleSize = 0;

    @SuppressWarnings("unused")
    private WeatherObservable weatherData;

    public StatisticsDisplay(WeatherObservable weatherData) {
        this.weatherData = weatherData;
        weatherData.attachObserver(this);
    }

    public void update(float temperature, float humidity, float pressure) {
        this.temperatureSampleSize += 1;
        this.temperatureSum += temperature;

        if (this.maxTemperature == null || temperature > this.maxTemperature) {
            this.maxTemperature = temperature;
        }
        if (this.minTemperature == null || temperature < this.minTemperature) {
            this.minTemperature = temperature;
        }

        display();
    }

    public void display() {
        System.out.println("Temperature statistics in °F (avg | max | min): "
                + (this.temperatureSum / this.temperatureSampleSize) + " | "
                + this.maxTemperature + " | " + this.minTemperature);
    }
}

class HeatIndexDisplay implements WeatherObserver, Display {
    private float heatIndex;

    @SuppressWarnings("unused")
    private WeatherObservable weatherData;

    public HeatIndexDisplay(WeatherObservable weatherData) {
        this.weatherData = weatherData;
        weatherData.attachObserver(this);
    }

    public static double heatIndexCal(double F, double rh) {
        double Hindex;

        Hindex = -42.379 + 2.04901523 * F + 10.14333127 * rh;
        Hindex = Hindex - 0.22475541 * F * rh - 6.83783 * Math.pow(10, -3) * F * F;
        Hindex = Hindex - 5.481717 * Math.pow(10, -2) * rh * rh;
        Hindex = Hindex + 1.22874 * Math.pow(10, -3) * F * F * rh;
        Hindex = Hindex + 8.5282 * Math.pow(10, -4) * F * rh * rh;
        Hindex = Hindex - 1.99 * Math.pow(10, -6) * F * F * rh * rh;

        return Hindex;
    }

    public void update(float t, float humidity, float pressure) {
        float rh = humidity / 100;

        this.heatIndex = 16.923f + 1.85212f * (float) Math.pow(10, -1) * t + 5.37941f * rh
                - 1.00254f * (float) Math.pow(10, -1) * t * rh
                + 9.41695f * (float) Math.pow(10, -3) * (float) Math.pow(t, 2)
                + 7.28898f * (float) Math.pow(10, -3) * (float) Math.pow(rh, 2)
                + 3.45372f * (float) Math.pow(10, -4) * (float) Math.pow(t, 2) * rh - 8.14971f
                + (float) Math.pow(10, -4) * t * (float) Math.pow(rh, 2)
                + 1.02102f * (float) Math.pow(10, -5) * (float) Math.pow(t, 2)
                        * (float) Math.pow(rh, 2)
                - 3.8646f * (float) Math.pow(10, -5) * (float) Math.pow(t, 3)
                + 2.91583f * (float) Math.pow(10, -5) * (float) Math.pow(rh, 3)
                + 1.42721f * (float) Math.pow(10, -6) * (float) Math.pow(t, 3) * rh
                + 1.97483f * (float) Math.pow(10, -7) * t * (float) Math.pow(rh, 3)
                - 2.18429f * (float) Math.pow(10, -8) * (float) Math.pow(t, 3)
                        * (float) Math.pow(rh, 2)
                + 8.43296f * (float) Math.pow(10, -10) * (float) Math.pow(t, 2)
                        * (float) Math.pow(rh, 2)
                - 4.81975f * (float) Math.pow(10, -11) * (float) Math.pow(t, 3)
                        * (float) Math.pow(rh, 3);

        display();
    }

    public void display() {
        System.out.println("Heat index is: " + this.heatIndex);
    }
}

class WeatherStatus implements WeatherObservable {
    private float temperature;
    private float pressure;
    private float humidity;

    public void setWeather(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;

        notifyObservers();
    }

    @Override
    public WeatherObserver attachObserver(WeatherObserver observer) {
        observers.add(observer);

        return observer;
    }

    @Override
    public void detachObserver(WeatherObserver observer) {
        int index = observers.indexOf(observer);
        if (index >= 0) {
            observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            WeatherObserver observer = observers.get(i);
            observer.update(this.temperature, this.humidity, this.pressure);
        }
    }
}

public class WeatherStation {
    public static void main(String[] args) {
        WeatherStatus weatherStatus = new WeatherStatus();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherStatus);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherStatus);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherStatus);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherStatus);

        weatherStatus.setWeather(80, 65, 30.4f);
        weatherStatus.setWeather(82, 70, 29.2f);
        weatherStatus.setWeather(78, 90, 29.2f);

        weatherStatus.detachObserver(currentDisplay);
        weatherStatus.detachObserver(forecastDisplay);
        weatherStatus.detachObserver(statisticsDisplay);
        weatherStatus.detachObserver(heatIndexDisplay);
    }
}
