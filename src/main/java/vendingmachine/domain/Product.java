package vendingmachine.domain;

import vendingmachine.constant.ErrorMessage;

public class Product {
    private final String name;
    private final int price;
    private final int quantity;

    private static final int MINIMUM_PRICE = 100;

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        validatePrice();
    }

    private void validatePrice() {
        if (price > MINIMUM_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.LESS_THAN_MINIMUM_PRICE);
        }
        if (price % Coin.getMinimumAmount() != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_BY_MINIMUM);
        }
    }
}
