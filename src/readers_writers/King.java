package readers_writers;

import logger.Logger;
import multiton.Valuable;
import shared.TreasureRoom;
import utility.collection.ArrayList;

import java.util.Random;

public class King implements Runnable {
    private final Door door;
    private final TreasureRoom treasureRoom;
    private final Logger logger = Logger.getInstance();
    private final Random random = new Random();

    public King(Door door, TreasureRoom treasureRoom) {
        this.door = door;
        this.treasureRoom = treasureRoom;
    }

    @Override
    public void run() {
        while (true) {
            try {
                door.requestWriteLock();
                var target = random.nextInt(100) + 50;
                logger.log("King is trying to retrieve valuables worth " + target);

                var collectedValuables = new ArrayList<Valuable>();
                while (collectedValuables.size() < target) {
                    var valuable = treasureRoom.retrieve("king");
                    if (valuable == null) {
                        logger.log("King retrieved no valuables");
                        break;
                    }

                    collectedValuables.add(valuable);
                    logger.log("King retrieved 1 worth of " + valuable.toString() + " valuables");
                }

                if (collectedValuables.size() < target) {
                    logger.log("King did not retrieve enough valuables for the party and is returning them");
                    treasureRoom.add("king", collectedValuables);

                    Thread.sleep(1000);
                } else {
                    logger.log("King retrieved enough valuables for the party");
                }


                door.releaseWriteLock();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}