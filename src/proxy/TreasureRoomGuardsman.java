package proxy;

import logger.Logger;
import multiton.Valuable;
import shared.TreasureRoom;
import utility.collection.ArrayList;

public class TreasureRoomGuardsman implements Treasury {
    private final TreasureRoom treasureRoom;
    private final Logger logger = Logger.getInstance();

    public TreasureRoomGuardsman(TreasureRoom treasureRoom) {
        this.treasureRoom = treasureRoom;
    }

    @Override
    public void add(String actor, ArrayList<Valuable> valuables) {
        if (actor.equalsIgnoreCase("valuabletransporter")) {
            treasureRoom.add(actor, valuables);
        } else {
            logger.log("You are not allowed to add valuables");
        }
    }

    @Override
    public Valuable retrieve(String actor) {
        if (actor.equalsIgnoreCase("king")) {
            return treasureRoom.retrieve(actor);
        } else {
            logger.log("You are not allowed to retrieve valuables");
            return null;
        }
    }

    @Override
    public int look(String actor) {
        if (actor.equalsIgnoreCase("accountant")) {
            return treasureRoom.look(actor);
        } else {
            logger.log("You are not allowed to look at the valuables");
            throw new IllegalArgumentException("You are not allowed to look at the valuables");
        }
    }
}
