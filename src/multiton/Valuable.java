package multiton;

import java.util.HashMap;

public class Valuable {
    private ValuableType key;
    private final static HashMap<ValuableType, Valuable> instances = new HashMap<>();

    private Valuable(ValuableType key) {
        this.key = key;
    }

    public synchronized static Valuable getInstance(ValuableType key) {
        if (!instances.containsKey(key)) {
            instances.put(key, new Valuable(key));
        }

        return instances.get(key);
    }

    @Override
    public String toString() {
        return key.toString();
    }
}
