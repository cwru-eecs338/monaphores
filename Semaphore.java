/*
 *  Implements a counting semaphore
 *  using monitors
 */
public class Semaphore {

    // The counting
    // semaphore value
    private int value;
    
    public Semaphore(int startingValue) {
        if (startingValue < 0) {
            throw new IllegalArgumentException(
                "Starting value must be nonnegative.");
        }
        this.value = startingValue;
    }

    public synchronized void semWait()
    throws InterruptedException {
        if (value == 0) {
            this.wait();
        }
        value--;
    }

    public synchronized void semSignal() {
        value++;
        this.notify();
    }
    
}
