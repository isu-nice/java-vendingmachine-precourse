package vendingmachine.view;

import java.util.Map;

public class OutputView {
    public static final String COIN_AND_NUMBER = "%d원 - %d개\n";
    public static final String INSERT_MONEY = "투입금액: %d원";

    public static void printMachineCoins(Map<Integer, Integer> numberOfCoins) {
        System.out.println("자판기가 보유한 동전");
        numberOfCoins.forEach((key, value) -> {
            System.out.printf(COIN_AND_NUMBER, key, value);
        });
    }

    public static void printInsertMoney(int balance) {
        System.out.printf(INSERT_MONEY, balance);
    }
}
