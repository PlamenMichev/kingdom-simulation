package shared;

import logger.Logger;
import multiton.Valuable;
import proxy.Treasury;
import utility.collection.ArrayList;

public class TreasureRoom implements Treasury {
    private final ArrayList<Valuable> valuables = new ArrayList<>();
    private final Logger logger = Logger.getInstance();

    public TreasureRoom() {}

    @Override
    public void add(String actor, ArrayList<Valuable> valuables) {
        logger.log(actor + " is adding " + valuables.size() + " valuables");

        for (int i = 0; i < valuables.size(); i++) {
            this.valuables.add(valuables.get(i));
        }
    }

    @Override
    public Valuable retrieve(String actor) {
        logger.log(actor + " is retrieving valuable");
        try {
            return valuables.remove(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int look(String actor) {
        logger.log(actor + " is looking at the valuables");

        return valuables.size();
    }
}
