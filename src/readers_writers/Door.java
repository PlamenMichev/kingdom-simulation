package readers_writers;

public class Door implements AccessManager {
    private int readers;
    private int writers;
    private int current;
    private int next;

    public Door() {
        readers = 0;
        writers = 0;
        current = 0;
        next = 0;
    }

    @Override
    public synchronized void releaseReadLock() {
        readers--;
        if (readers == 0) {
            notifyAll();
        }
    }

    @Override
    public synchronized void requestReadLock() throws InterruptedException {
        int currentNumber = next;
        next++;

        while (currentNumber != current) {
            wait();
        }

        while (writers > 0) {
            wait();
        }

        readers++;
        current++;
        notifyAll();
    }

    @Override
    public synchronized void releaseWriteLock() {
        writers--;
        if (writers == 0) {
            notifyAll();
        }
    }

    @Override
    public synchronized void requestWriteLock() throws InterruptedException {
        var currentNumber = next;
        next++;

        while (currentNumber != current) {
            wait();
        }

        while (writers > 0 || readers > 0) {
            wait();
        }

        writers++;
        current++;
        notifyAll();
    }
}
