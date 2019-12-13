package ua.training.creational.singleton;

public class ThreadSafeSingletonDoubleChecked {
    private static ThreadSafeSingletonDoubleChecked instance;

    private ThreadSafeSingletonDoubleChecked() {
    }

    public static ThreadSafeSingletonDoubleChecked getInstanceUsingDoubleLocking() {
        if (instance == null) {
            synchronized (ThreadSafeSingletonDoubleChecked.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingletonDoubleChecked();
                }
            }
        }
        return instance;
    }
}