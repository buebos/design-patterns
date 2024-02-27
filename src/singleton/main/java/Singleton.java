package singleton.main.java;

/** Example */
class Singleton {
    private static final Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }
}

class UtilTime {
    public static void setTimeout(Runnable runnable, int delay) {
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            } catch (Exception e) {
                System.err.println(e);
            }
        }).start();
    }
}

/** Implementation */

class ChocolateBoiler {
    /** Static prop to deal with multi threading */
    private static final ChocolateBoiler instance = new ChocolateBoiler();

    /** In milliliters */
    private final Float VOL_MAX = 500F;
    private Float volume;

    /** In Celsius (real chocolate boiling point) */
    private final Float TEMP_BOILING_POINT = 49F;
    private Float temperature;

    private boolean fireOn = false;

    private ChocolateBoiler() {
    }

    public static ChocolateBoiler getInstance() {
        return instance;
    }

    public void fill() {
        volume = VOL_MAX;
    }

    public void empty() {
        if (!isEmpty() && isBoiled()) {
            volume = 0F;
            fireOn = false;
        }

        for (int i = 1; i <= 7; i++) {
            UtilTime.setTimeout(() -> cool(7F), i * 1_000);
        }
    }

    private void cool(Float deg) {
        if (fireOn || temperature <= 7) {
            return;
        }

        temperature -= deg;

        System.out.println("Cooling the boiler current is: " + getTemperature() + " C");
    }

    public void boil() {
        fireOn = true;

        temperature = TEMP_BOILING_POINT;
    }

    public boolean isBoiled() {
        return temperature >= TEMP_BOILING_POINT;
    }

    public boolean isEmpty() {
        return volume == 0;
    }

    public Float getTemperature() {
        return temperature;
    }

    public Float getVolume() {
        return volume;
    }
}

class Main {
    public static void main(String[] args) {
        ChocolateBoiler boiler = ChocolateBoiler.getInstance();

        System.out.println("Unique chocolate boiler retrieved");

        System.out.println("Filling...");

        boiler.fill();

        System.out.println("Current volume on boiler: " + boiler.getTemperature() + " ml");

        System.out.println("Boiling...");

        boiler.boil();

        System.out.println("Current temperature on boiler: " + boiler.getTemperature() + " C");

        boiler.empty();

        System.out.println("Emptied boiler, current volume: " + boiler.getVolume() + " L");
    }
}