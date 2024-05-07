package readers_writers;

import logger.Logger;
import shared.TreasureRoom;

public class Accountant implements Runnable {
    private final Door door;
    private final Logger logger = Logger.getInstance();
    private final TreasureRoom treasureRoom;

    public Accountant(Door door, TreasureRoom treasureRoom) {
        this.door = door;
        this.treasureRoom = treasureRoom;
    }

    @Override
    public void run() {
        while (true) {
            try {
                door.requestReadLock();
                logger.log("Accountant is counting the total sum of the valuables");

                Thread.sleep(1000);
                var totalValuables = treasureRoom.look("accountant");
                logger.log("Total sum of the valuables is " + totalValuables);

                door.releaseReadLock();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}