import java.util.concurrent.Semaphore;
public class USBController {

    private Semaphore semaphore = new Semaphore(1);

    public void readBufferWithoutSemaphore(){
        System.out.println(Thread.currentThread().getName() + " is reading buffer from controller.");
        System.out.println("Info for " + Thread.currentThread().getName() + " read!");
    }
    public void readBufferWithSemaphore(){
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " is reading buffer from controller.");
        } catch (InterruptedException e) {

        } finally {
            System.out.println("Info for " + Thread.currentThread().getName() + " read!");
            semaphore.release();
        }
    }
}
