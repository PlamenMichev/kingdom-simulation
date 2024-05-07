package producer_consumer;

import logger.Logger;
import multiton.Valuable;
import shared.Deposit;

import java.util.ArrayList;
import java.util.Random;

public class ValuableTransporter implements Runnable {
    private final Deposit<Valuable> deposit;
    private final Random random = new Random();
    private final Logger logger = Logger.getInstance();

    public ValuableTransporter(Deposit<Valuable> deposit) {
        this.deposit = deposit;
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
                collectedValuables.clear();

                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
