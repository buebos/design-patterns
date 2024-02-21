package factory.main.java;

import java.util.ArrayList;

class Pizza {
    String name = "Simple Pizza";
    String dough;
    String sauce;
    ArrayList<String> toppings = new ArrayList<String>();

    public String getName() {
        return name;
    }

    public String getPizzaName() {
        return this.name + " Pizza";
    }

    void prepare() {
        System.out.println("Preparing a " + this.getPizzaName() + "...");
        System.out.println("\tTossing dough...");
        System.out.println("\tAdding sauce...");
        System.out.println("\tAdding toppings...");

        for (int i = 0; i < toppings.size(); i++) {
            System.out.println("\t\t" + toppings.get(i));
        }
    }

    void bake() {
        System.out.println("Baking a " + this.getPizzaName() + "...");
    }

    void cut() {
        System.out.println("Cutting a " + this.getPizzaName() + "...");
    }

    void box() {
        System.out.println("Boxing a " + this.getPizzaName() + "...");
    }
}

abstract class PizzaFactory {
    public Pizza orderPizza(String type) {
        Pizza pizza = this.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    abstract public Pizza createPizza(String type);
}

class PizzaPepperoniNY extends Pizza {
    public PizzaPepperoniNY() {
        name = "Pepperoni NY";
    }
}

class PizzaCheeseNY extends Pizza {
    public PizzaCheeseNY() {
        name = "Cheese NY";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
    }
}

class PizzaClamNY extends Pizza {
    public PizzaClamNY() {
        name = "Clam NY";
    }
}

class PizzaVeggieNY extends Pizza {
    public PizzaVeggieNY() {
        name = "Veggie NY";
    }
}

class PizzaTJStyleNY extends Pizza {
    public PizzaTJStyleNY() {
        name = "TJ Style NY";
    }
}

class PizzaFactoryNY extends PizzaFactory {
    public Pizza createPizza(String type) {
        if (type.equals("pepperoni")) {
            return new PizzaPepperoniNY();
        }
        if (type.equals("cheese")) {
            return new PizzaCheeseNY();
        }
        if (type.equals("clam")) {
            return new PizzaClamNY();
        }
        if (type.equals("veggie")) {
            return new PizzaVeggieNY();
        }
        if (type.equals("tjstyle")) {
            return new PizzaTJStyleNY();
        }

        return null;
    }
}

class PizzaPepperoniChicago extends Pizza {
    public PizzaPepperoniChicago() {
        name = "Pepperoni Chicago";
    }

    void cut() {
        System.out.println("Cutting in squares a " + this.getPizzaName() + "...");
    }
}

class PizzaCheeseChicago extends Pizza {
    public PizzaCheeseChicago() {
        name = "Cheese Chicago";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
    }

    void cut() {
        System.out.println("Cutting in squares a " + this.getPizzaName() + "...");
    }
}

class PizzaClamChicago extends Pizza {
    public PizzaClamChicago() {
        name = "Clam Chicago";
    }

    void cut() {
        System.out.println("Cutting in squares a " + this.getPizzaName() + "...");
    }
}

class PizzaVeggieChicago extends Pizza {
    public PizzaVeggieChicago() {
        name = "Veggie Chicago";
    }

    void cut() {
        System.out.println("Cutting in squares a " + this.getPizzaName() + "...");
    }
}

class PizzaTJStyleChicago extends Pizza {
    public PizzaTJStyleChicago() {
        name = "TJ Style Chicago";
    }

    void cut() {
        System.out.println("Cutting in squares a " + this.getPizzaName() + "...");
    }
}

class PizzaFactoryChicago extends PizzaFactory {
    public Pizza createPizza(String type) {
        if (type.equals("pepperoni")) {
            return new PizzaPepperoniChicago();
        }
        if (type.equals("cheese")) {
            return new PizzaCheeseChicago();
        }
        if (type.equals("clam")) {
            return new PizzaClamChicago();
        }
        if (type.equals("veggie")) {
            return new PizzaVeggieChicago();
        }
        if (type.equals("tjstyle")) {
            return new PizzaTJStyleChicago();
        }

        return null;
    }
}

class Main {
    public static void main(String[] args) {
        PizzaFactory pizzaFactoryNY = new PizzaFactoryNY();
        PizzaFactory pizzaFactoryChicago = new PizzaFactoryChicago();

        pizzaFactoryNY.orderPizza("tjstyle");
        pizzaFactoryChicago.orderPizza("cheese");
    }
}