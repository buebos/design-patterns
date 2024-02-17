package decorator.main.java;

interface Beverage {
    double getCost();

    String getDesc();
}

interface Condiment extends Beverage {
}

/** Beverages (Component) */

class HouseBlend implements Beverage {
    public double getCost() {
        return 4;
    }

    public String getDesc() {
        return "House Blend";
    }
}

class DarkRoast implements Beverage {
    public double getCost() {
        return 3;
    }

    public String getDesc() {
        return "Dark Roast";
    }
}

/** Beverage Condiments (Decorators) */

class CinnamonScoop implements Condiment {
    Beverage beverage;

    public CinnamonScoop(Beverage beverage) {
        this.beverage = beverage;
    }

    public double getCost() {
        return this.beverage.getCost() + 0.2;
    }

    public String getDesc() {
        return this.beverage.getDesc() + ", Cinnamon Scoop";
    }
}

class OatMilk implements Condiment {
    Beverage beverage;

    public OatMilk(Beverage beverage) {
        this.beverage = beverage;
    }

    public double getCost() {
        return this.beverage.getCost() + 0.3;
    }

    public String getDesc() {
        return this.beverage.getDesc() + ", Oat Milk";
    }
}

class ExpressoShot implements Condiment {
    Beverage beverage;

    public ExpressoShot(Beverage beverage) {
        this.beverage = beverage;
    }

    public double getCost() {
        return this.beverage.getCost() + 0.5;
    }

    public String getDesc() {
        return this.beverage.getDesc() + ", Expresso Shot";
    }
}

public class Main {
    public static void main(String[] args) {
        Beverage darkRoast = new DarkRoast();
        Beverage houseBlend = new HouseBlend();
        Beverage anotherHouseBlend = new HouseBlend();

        darkRoast = new OatMilk(darkRoast);
        darkRoast = new ExpressoShot(darkRoast);
        darkRoast = new ExpressoShot(darkRoast);

        houseBlend = new ExpressoShot(houseBlend);
        houseBlend = new CinnamonScoop(houseBlend);
        houseBlend = new CinnamonScoop(houseBlend);

        anotherHouseBlend = new OatMilk(anotherHouseBlend);
        anotherHouseBlend = new ExpressoShot(anotherHouseBlend);
        anotherHouseBlend = new CinnamonScoop(anotherHouseBlend);

        System.out.println(darkRoast.getDesc() + " $" + darkRoast.getCost());
        System.out.println(houseBlend.getDesc() + " $" + houseBlend.getCost());
        System.out.println(anotherHouseBlend.getDesc() + " $" + anotherHouseBlend.getCost());
    }
}
