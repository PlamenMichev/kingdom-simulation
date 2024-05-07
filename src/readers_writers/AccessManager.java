package readers_writers;

public interface AccessManager {
    void releaseReadLock();
    void requestReadLock() throws InterruptedException;
    void releaseWriteLock();
    void requestWriteLock() throws InterruptedException;
}
