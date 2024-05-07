package producer_consumer;

import logger.Logger;
import multiton.Valuable;
import multiton.ValuableType;
import shared.Deposit;

import java.util.Random;

public class Miner implements Runnable {
    private final Deposit<Valuable> deposit;
    private final Random random = new Random();
    private final Logger logger = Logger.getInstance();

    public Miner(Deposit<Valuable> deposit) {
        this.deposit = deposit;

    }

    @Override
    public void run() {
        while (true) {
            try {
                logger.log("Miner is mining");

                // Get random number between 1 and 10
                var numberOfValuables = random.nextInt(10) + 1;

                for (int i = 0; i < numberOfValuables; i++) {
                    // Get random number between 0 and 6
                    var valuableType = ValuableType.values()[(int) (Math.random() * 6)];
                    var valuable = Valuable.getInstance(valuableType);
                    System.out.println("Miner found " + valuable.toString());
                    deposit.enqueue(valuable);
                }


                logger.log("Miner found is waiting after mining and depositing valuables " + numberOfValuables);
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
