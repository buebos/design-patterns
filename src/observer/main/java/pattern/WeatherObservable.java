package observer.main.java.pattern;

import java.util.ArrayList;

public interface WeatherObservable {
    public ArrayList<WeatherObserver> observers = new ArrayList<>();

    public WeatherObserver attachObserver(WeatherObserver observer);

    public void detachObserver(WeatherObserver observer);

    public void notifyObservers();
}
