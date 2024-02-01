package observer.main.java;

import observer.main.java.pattern.Observable;
import observer.main.java.pattern.Observer;

class Waiter implements Observer {
    public void update() {
        System.out.println("Waiter has been updated");
    }
}

class Customer implements Observable {
    @Override
    public Observer attachObserver(Observer observer) {
        observers.add(observer);

        return observer;
    }

    @Override
    public Boolean detachObserver(Observer observer) {
        return observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = observers.get(i);

            observer.update();
        }
    }

    public void placeOrder() {
        System.out.println("Placing order");
        this.notifyObservers();
    }
}

public class Main {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        Customer customer = new Customer();

        customer.attachObserver(waiter);
        customer.placeOrder();
    }
}
