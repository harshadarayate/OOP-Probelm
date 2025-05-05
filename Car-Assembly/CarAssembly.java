class CarAssembly implements Runnable {
    private String componentName;
    private int timeToPrepare;

    // Constructor
    public CarAssembly(String componentName, int timeToPrepare) {
        this.componentName = componentName;
        this.timeToPrepare = timeToPrepare;
    }

    // Run method with simulated preparation using sleep
    @Override
    public void run() {
        try {
            System.out.println(componentName + " is preparing...");
            Thread.sleep(timeToPrepare);
            System.out.println(componentName + " is ready.");
        } catch (InterruptedException e) {
            System.out.println(componentName + " preparation was interrupted.");
        }
    }

    // Main method to create and run threads
    public static void main(String[] args) {
        // Create Runnable objects for each component
        CarAssembly engine = new CarAssembly("Engine", 3000);
        CarAssembly body = new CarAssembly("Body", 4000);
        CarAssembly wheels = new CarAssembly("Wheels", 5000);

        // Create threads for each component
        Thread engineThread = new Thread(engine);
        Thread bodyThread = new Thread(body);
        Thread wheelThread = new Thread(wheels);

        // Start threads
        engineThread.start();
        bodyThread.start();
        wheelThread.start();

        // Use join to synchronize (wait for all threads to finish)
        try {
            engineThread.join();
            bodyThread.join();
            wheelThread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread joining interrupted.");
        }

        // Final message
        System.out.println("Car assembly is complete!");
    }
}
