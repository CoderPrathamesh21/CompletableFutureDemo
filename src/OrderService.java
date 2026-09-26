import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class OrderService {

    ExecutorService executor = Executors.newFixedThreadPool(2);

    public void placeOrder() throws ExecutionException, InterruptedException {
        System.out.println("Order place");

        Future<String> payment = executor.submit(() -> processPayment());
        String status = payment.get();
        saveOrder(status);

        System.out.println("Order complete");
    }

    public String processPayment() {
        System.out.println("Processing Payment");
        sleep(3000);
        return "Success";
    }

    public void saveOrder(String status) {
        System.out.println("Order Saved with status: " + status);
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}
