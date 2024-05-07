import multiton.Valuable;
import producer_consumer.Miner;
import producer_consumer.ValuableTransporter;
import readers_writers.Accountant;
import readers_writers.Door;
import readers_writers.King;
import shared.Deposit;
import shared.TreasureRoom;

public class Main {
    public static void main(String[] args) {
        var deposit = new Deposit<Valuable>();
        var door = new Door();
        var treasureRoom = new TreasureRoom();

        var miner = new Miner(deposit);
        var valuableTransporter = new ValuableTransporter(deposit, treasureRoom, door);
        var king = new King(door, treasureRoom);
        var accountant = new Accountant(door, treasureRoom);

        var minerThread = new Thread(miner);
        var valuableTransporterThread = new Thread(valuableTransporter);
        var kingThread = new Thread(king);
        var accountantThread = new Thread(accountant);

        minerThread.start();
        valuableTransporterThread.start();
        kingThread.start();
        accountantThread.start();

    }
}