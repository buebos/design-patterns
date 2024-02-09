package observer.main.java;

import observer.main.java.pattern.WeatherObservable;
import observer.main.java.pattern.WeatherObserver;

class CurrentWeatherDisplay implements WeatherObserver, Display {
    protected float humidity;
    protected float temperature;

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;

        display();
    }

    public void display() {
        System.out.println("Current weather: { Temperature: " + temperature + "°C, Humidity: " + humidity + " }");
    }
}

class WeatherStatus implements WeatherObservable {
    protected float temperature;
    protected float pressure;
    protected float humidity;

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
    public Boolean detachObserver(WeatherObserver observer) {
        return observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            WeatherObserver observer = observers.get(i);

            observer.update(this.temperature, this.humidity, this.pressure);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        WeatherStatus weatherStatus = new WeatherStatus();
        CurrentWeatherDisplay currentDisplay = new CurrentWeatherDisplay();

        weatherStatus.attachObserver(currentDisplay);
        weatherStatus.setWeather(10, 20, 20);
        weatherStatus.setWeather(10, 20, 20);
    }
}
