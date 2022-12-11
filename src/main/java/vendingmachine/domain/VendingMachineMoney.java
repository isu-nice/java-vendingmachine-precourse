package vendingmachine.domain;

import vendingmachine.constant.ErrorMessage;

public class VendingMachineMoney {
    private int money;

    public VendingMachineMoney(int money) {
        validateMoney();
        this.money = money;
    }


    private void validateMoney() {
        int minimumAmount = Coin.getMinimumAmount();
        validateMinimumAmount(minimumAmount);
        validateDivisibleByMinimum(minimumAmount);
    }

    private void validateMinimumAmount(int minimumAmount) {
        if (money < minimumAmount) {
            throw new IllegalArgumentException(ErrorMessage.LESS_THAN_MINIMUM_AMOUNT);
        }
    }

    private void validateDivisibleByMinimum(int minimumAmount) {
        if (money % minimumAmount != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_BY_MINIMUM);
        }
    }

    public int getMoney() {
        return money;
    }
}
