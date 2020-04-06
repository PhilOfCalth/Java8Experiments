package util;

public class ThreadUtils {
    /**
     * Quick and easy way to simulate a call to a database, microservice, etc
     */
    public static void simulateNetworkCall() {
        try {
            Thread.sleep(3000);//3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}