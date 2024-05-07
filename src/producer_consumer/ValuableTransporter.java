package producer_consumer;

import logger.Logger;
import multiton.Valuable;
import readers_writers.Door;
import shared.Deposit;
import shared.TreasureRoom;
import utility.collection.ArrayList;

import java.util.Random;

public class ValuableTransporter implements Runnable {
    private final Deposit<Valuable> deposit;
    private final TreasureRoom treasureRoom;
    private final Door door;
    private final Random random = new Random();
    private final Logger logger = Logger.getInstance();

    public ValuableTransporter(Deposit<Valuable> deposit, TreasureRoom treasureRoom, Door door) {
        this.deposit = deposit;
        this.treasureRoom = treasureRoom;
        this.door = door;
    }

    @Override
    public void run() {
        var collectedValuables = new ArrayList<Valuable>();
        while (true) {
            try {
                logger.log("Valuable transporter starts to collect valuables");

                // Get random number between 50 and 200
                var numberOfValuables = random.nextInt(150) + 50;

                while (collectedValuables.size() <= numberOfValuables) {
                    var collectedValuable = deposit.dequeue();
                    collectedValuables.add(collectedValuable);
                    logger.log("Valuable transporter collected " + collectedValuable.toString() + " valuables");
                }


                logger.log("Valuable transporter is transporting valuables");
                door.requestWriteLock();

                treasureRoom.add("valuabletransporter", collectedValuables);

                while (!collectedValuables.isEmpty()) {
                    collectedValuables.remove(0);
                }

                logger.log("Valuable transporter transported " + numberOfValuables + " valuables");
                door.releaseWriteLock();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
