package vendingmachine.domain;

public class Balance {
    private static int balance;

    public Balance(int insertMoney) {
        balance = insertMoney;
    }

    public static int getBalance() {
        return balance;
    }

    public static void deduct(Product product) {
        balance -= product.getPrice();
    }

    public static boolean isOverThanProductMinimum() {
        return balance > ProductRepository.findMinimumPrice();
    }
}
