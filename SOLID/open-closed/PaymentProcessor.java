// 3️⃣ PaymentProcessor — open for extension, closed for modification
class PaymentProcessor {
    public void process(PaymentMethod method, double amount) {
        method.pay(amount);  // Polymorphism at work
    }
}