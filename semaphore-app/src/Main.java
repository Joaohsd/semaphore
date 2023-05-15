public class Main {
    public static void main(String[] args) {
        // Creating shared USBController
        USBController usbController = new USBController();
        boolean useSemaphore = true;

        // Creating Threads
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            threads[i] = new Thread(new USBControllerProcess(usbController, useSemaphore));
        }

        // Starting Threads
        for (int i = 0; i < 3; i++) {
            threads[i].start();
        }
    }
}