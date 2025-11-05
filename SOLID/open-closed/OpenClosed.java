/* Software entities (classes, modules, functions) should be open for extension but closed for modification.

Without OCP

class PaymentProcessor {
    public void processPayment(String type) {
        if (type.equals("CREDIT_CARD")) {
            System.out.println("Processing credit card payment...");
        } else if (type.equals("PAYPAL")) {
            System.out.println("Processing PayPal payment...");
        } else if (type.equals("UPI")) {
            System.out.println("Processing UPI payment...");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment("CREDIT_CARD");
    }
}

Problem:

If a new payment method (like Apple Pay) is added, you must modify the PaymentProcessor class.

This breaks OCP because existing code is not closed for modification.

The more payment types you add, the more complex and error-prone it becomes.

*/

// 4️⃣ Main - With OCP
public class OpenClosed {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        processor.process(new CreditCardPayment(), 2500);
        processor.process(new PayPalPayment(), 1200);
        processor.process(new UPIPayment(), 500);
    }
}
