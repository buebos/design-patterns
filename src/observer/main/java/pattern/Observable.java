package observer.main.java.pattern;

import java.util.ArrayList;

public interface Observable {
    public ArrayList<Observer> observers = new ArrayList<>();

    public Observer attachObserver(Observer observer);

    public Boolean detachObserver(Observer observer);

    public void notifyObservers();
}
