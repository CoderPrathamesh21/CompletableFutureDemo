import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OrderService {

    ExecutorService executor = Executors.newFixedThreadPool(2);

    public void placeOrder() {
        System.out.println("Order place");

        Thread t1 = new Thread(() -> {
            String paymentStatus = processPayment();
            System.out.println("Payment Status: " + paymentStatus);
        });
        t1.start();

        saveOrder();

        System.out.println("Order complete");
    }

    public String processPayment() {
        System.out.println("Processing Payment");
        sleep(3000);
        return "Success";
    }

    public void saveOrder() {
        System.out.println("Order Saved");
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}
