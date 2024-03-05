package adapter.main.java;

class Duck {
    void quack() {
        System.out.println("Quack!");
    }

    void fly() {
        System.out.println("Flying!");
    }
}

class Turkey {
    void gobble() {
        System.out.println("Gobble!");
    }

    void fly() {
        System.out.println("Flying short distance!");
    }
}

class TurkeyDuckAdapter extends Duck {
    Turkey turkey;

    TurkeyDuckAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    void quack() {
        turkey.gobble(); // Adapting gobble to quack
    }

    @Override
    void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly(); // Adapting turkey's short distance flight to duck's flying
        }
    }
}

class Main {
    public static void main(String[] args) {
        Duck duck = new Duck();

        Turkey turkey = new Turkey();
        Duck turkeyAdapter = new TurkeyDuckAdapter(turkey);

        System.out.println("Authentic duck:");

        duck.quack();
        duck.fly();

        System.out.println("Adapted turkey to duck:");

        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }
}
