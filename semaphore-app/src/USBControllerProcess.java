public class USBControllerProcess implements Runnable{
    private USBController usbController;
    private boolean useSemaphore;
    public USBControllerProcess(USBController usbController, boolean useSemaphore) {
        this.usbController = usbController;
        this.useSemaphore = useSemaphore;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " ready to read buffer.");
        if(this.useSemaphore)
            this.usbController.readBufferWithSemaphore();
        else this.usbController.readBufferWithoutSemaphore();
    }
}
