package adapter;

public interface Queue<T> {
    void enqueue(T item);
    T dequeue() throws InterruptedException;
    boolean isEmpty();
    int size();
}