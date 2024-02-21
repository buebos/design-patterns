package absfactory.main.java;

import java.util.ArrayList;

interface PizzaIngredientsFactory {
    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    Pepperoni createPepperoni();

    Clam createClam();

    ArrayList<Veggie> createVeggies();

}

class Ingredient {
    String name;

    public Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Dough extends Ingredient {
    public Dough(String name) {
        super(name);
    }
}

class Sauce extends Ingredient {
    public Sauce(String name) {
        super(name);
    }
}

class Veggie extends Ingredient {
    public Veggie(String name) {
        super(name);
    }
}

class Cheese extends Ingredient {
    public Cheese(String name) {
        super(name);
    }
}

class Pepperoni extends Ingredient {
    public Pepperoni(String name) {
        super(name);
    }
}

class Clam extends Ingredient {
    public Clam(String name) {
        super(name);
    }
}

class MashedBeans extends Ingredient {
    public MashedBeans(String name) {
        super(name);
    }
}

abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Cheese cheese;
    ArrayList<Veggie> veggies;
    Clam clams;
    Pepperoni pepperoni;

    public Pizza() {
        this.name = this.getName();
    }

    /** Forces to add a name in the implementation */
    abstract public String getName();

    abstract void prepare();

    public void setName(String name) {
        this.name = name;
    }

    public String getPizzaName() {
        return this.name + " Pizza";
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

class PizzaPepperoni extends Pizza {
    PizzaIngredientsFactory ingredientsFactory;

    public PizzaPepperoni(PizzaIngredientsFactory ingredientsFactory) {
        super();
        this.ingredientsFactory = ingredientsFactory;
    }

    public String getName() {
        return "Pepperoni";
    }

    void prepare() {
        System.out.println("Preparing a " + this.getPizzaName() + "...");
        dough = ingredientsFactory.createDough();
        sauce = ingredientsFactory.createSauce();
        cheese = ingredientsFactory.createCheese();
        pepperoni = ingredientsFactory.createPepperoni();

        System.out.println("\tTossing " + dough.getName() + "...");
        System.out.println("\tAdding Souce: " + sauce.getName() + "...");
        System.out.println("\tAdding Cheese: " + cheese.getName() + "...");
        System.out.println("\tAdding Pepperoni: " + pepperoni.getName() + "...");
    }
}

class PizzaCheese extends Pizza {
    PizzaIngredientsFactory ingredientsFactory;

    public PizzaCheese(PizzaIngredientsFactory ingredientsFactory) {
        super();
        this.ingredientsFactory = ingredientsFactory;
    }

    public String getName() {
        return "Cheese";
    }

    void prepare() {
        System.out.println("Preparing a " + this.getPizzaName() + "...");
        dough = ingredientsFactory.createDough();
        sauce = ingredientsFactory.createSauce();
        cheese = ingredientsFactory.createCheese();

        System.out.println("\tTossing " + dough.getName() + "...");
        System.out.println("\tAdding " + sauce.getName() + "...");
        System.out.println("\tAdding " + cheese.getName() + "...");
    }
}

class PizzaClam extends Pizza {
    PizzaIngredientsFactory ingredientsFactory;

    public PizzaClam(PizzaIngredientsFactory ingredientsFactory) {
        super();
        this.ingredientsFactory = ingredientsFactory;
    }

    public String getName() {
        return "Clam";
    }

    void prepare() {
        System.out.println("Preparing a " + this.getPizzaName() + "...");
        dough = ingredientsFactory.createDough();
        sauce = ingredientsFactory.createSauce();
        cheese = ingredientsFactory.createCheese();
        clams = ingredientsFactory.createClam();

        System.out.println("\tTossing Dough: " + dough.getName() + "...");
        System.out.println("\tAdding Sauce: " + sauce.getName() + "...");
        System.out.println("\tAdding Cheese: " + cheese.getName() + "...");
        System.out.println("\tAdding Clams: " + clams.getName() + "...");
    }
}

class PizzaTJStyle extends Pizza {
    PizzaIngredientsFactory ingredientsFactory;

    public PizzaTJStyle(PizzaIngredientsFactory ingredientsFactory) {
        super();
        this.ingredientsFactory = ingredientsFactory;
    }

    public String getName() {
        return "TJ Style";
    }

    void prepare() {
        System.out.println("Preparing a " + this.getPizzaName() + "...");
        Ingredient mashedBeans = new MashedBeans("Mashed Beans La Costeña");
        dough = ingredientsFactory.createDough();
        sauce = ingredientsFactory.createSauce();
        cheese = ingredientsFactory.createCheese();
        pepperoni = ingredientsFactory.createPepperoni();
        veggies = ingredientsFactory.createVeggies();

        System.out.println("\tTossing Dough: " + dough.getName() + "...");
        System.out.println("\tAdding Sauce: " + sauce.getName() + "...");
        System.out.println("\tAdding Cheese: " + cheese.getName() + "...");
        System.out.println("\tAdding Mashed Beans: " + mashedBeans.getName() + "...");
        System.out.println("\tAdding veggies...");

        for (int i = 0; i < veggies.size(); i++) {
            System.out.println("\tAdding " + veggies.get(i).getName() + "...");
        }
    }
}

class PizzaIngredientsFactoryNY implements PizzaIngredientsFactory {
    public Dough createDough() {
        return new Dough("Thin Crust Dough");
    }

    public Sauce createSauce() {
        return new Sauce("Marinara Sauce");
    }

    public Cheese createCheese() {
        return new Cheese("Mozzarella Cheese");
    }

    public Pepperoni createPepperoni() {
        return new Pepperoni("Pepperoni NY");
    }

    public Clam createClam() {
        return new Clam("Fresh Clams");
    }

    public ArrayList<Veggie> createVeggies() {
        ArrayList<Veggie> veggies = new ArrayList<Veggie>();

        veggies.add(new Veggie("Onion New York"));
        veggies.add(new Veggie("Tomato York"));

        return veggies;
    }
}

class PizzaIngredientsFactoryChicago implements PizzaIngredientsFactory {
    public Dough createDough() {
        return new Dough("Thick Crust Dough");
    }

    public Sauce createSauce() {
        return new Sauce("Plum Tomato Sauce");
    }

    public Cheese createCheese() {
        return new Cheese("Mozzarella Cheese");
    }

    public Pepperoni createPepperoni() {
        return new Pepperoni("Pepperoni Chicago");
    }

    public Clam createClam() {
        return new Clam("Frozen Clams");
    }

    public ArrayList<Veggie> createVeggies() {
        ArrayList<Veggie> veggies = new ArrayList<Veggie>();

        veggies.add(new Veggie("Onion Chicago"));
        veggies.add(new Veggie("Bell Pepper Chicago"));

        return veggies;
    }
}

class PizzaFactoryNY extends PizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientsFactory ingredientsFactory = new PizzaIngredientsFactoryNY();

        if (type.equals("pepperoni")) {
            pizza = new PizzaPepperoni(ingredientsFactory);
        } else if (type.equals("cheese")) {
            pizza = new PizzaCheese(ingredientsFactory);
        } else if (type.equals("clam")) {
            pizza = new PizzaClam(ingredientsFactory);
        } else if (type.equals("tjstyle")) {
            pizza = new PizzaTJStyle(ingredientsFactory);
        } else {
            return null;
        }

        pizza.setName(pizza.name + " NY");

        return pizza;
    }
}

class PizzaFactoryChicago extends PizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientsFactory ingredientsFactory = new PizzaIngredientsFactoryChicago();

        if (type.equals("pepperoni")) {
            pizza = new PizzaPepperoni(ingredientsFactory);
        } else if (type.equals("cheese")) {
            pizza = new PizzaCheese(ingredientsFactory);
        } else if (type.equals("clam")) {
            pizza = new PizzaClam(ingredientsFactory);
        } else if (type.equals("tjstyle")) {
            pizza = new PizzaTJStyle(ingredientsFactory);
        } else {
            return null;
        }

        pizza.setName(pizza.name + " Chicago");

        return pizza;
    }
}

class Main {
    public static void main(String[] args) {
        PizzaFactory pizzaFactoryNY = new PizzaFactoryNY();
        PizzaFactory pizzaFactoryChicago = new PizzaFactoryChicago();

        System.out.println("--- NEW YORK ---");
        pizzaFactoryNY.orderPizza("cheese");
        System.out.println("");
        pizzaFactoryNY.orderPizza("tjstyle");
        System.out.println("");

        System.out.println("--- CHICAGO ---");
        pizzaFactoryChicago.orderPizza("cheese");
        System.out.println("");
        pizzaFactoryChicago.orderPizza("tjstyle");
        System.out.println("");
    }
}