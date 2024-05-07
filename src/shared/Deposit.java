package shared;

import adapter.Queue;
import utility.collection.ArrayList;

public class Deposit<T> implements Queue<T> {
    private final ArrayList<T> list;

    public Deposit() {
        list = new ArrayList<>();
    }

    @Override
    public synchronized void enqueue(T item) {
        list.add(item);
        notifyAll();
    }

    @Override
    public synchronized T dequeue() throws InterruptedException {
        if (isEmpty()) {
            wait();
        }

        return list.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return 0;
    }
}
