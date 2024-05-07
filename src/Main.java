import multiton.Valuable;
import producer_consumer.Miner;
import producer_consumer.ValuableTransporter;
import shared.Deposit;

public class Main {
    public static void main(String[] args) {
        var deposit = new Deposit<Valuable>();
        var miner = new Miner(deposit);
        var valuableTransporter = new ValuableTransporter(deposit);

        var minerThread = new Thread(miner);
        var valuableTransporterThread = new Thread(valuableTransporter);
        minerThread.start();
        valuableTransporterThread.start();

    }
}