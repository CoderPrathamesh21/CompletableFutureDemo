public class OrderService {

    public void placeOrder() {
        System.out.println("Order place");

        String paymentStatus = processPayment();

        System.out.println("Payment Status: " + paymentStatus);

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
