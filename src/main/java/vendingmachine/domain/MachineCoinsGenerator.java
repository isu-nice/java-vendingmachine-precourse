package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class MachineCoinsGenerator {
    private int machineMoney;
    private final EnumMap<Coin, Integer> numberOfCoins;

    public MachineCoinsGenerator(MachineMoney inputMachineMoney) {
        this.machineMoney = inputMachineMoney.getMoney();
        numberOfCoins = initializeNumberOfCoins();
    }

    private EnumMap<Coin, Integer> initializeNumberOfCoins() {
        EnumMap<Coin, Integer> numberOfCoins = new EnumMap<>(Coin.class);
        Arrays.stream(Coin.values())
                .forEach(coin -> numberOfCoins.put(coin, 0));
        return numberOfCoins;
    }

    public MachineCoins generate() {
        putRandomNumber();
        validateMatchWithMachineMoney();
        return new MachineCoins(numberOfCoins);
    }

    private void putRandomNumber() {
        for (Coin coin : numberOfCoins.keySet()) {
            int randomNumber = getRandomNumber(coin);
            numberOfCoins.put(coin, numberOfCoins.get(coin) + randomNumber);
            machineMoney -= computeAmount(coin, randomNumber);
        }
    }

    private int getRandomNumber(Coin coin) {
        int amount = coin.getAmount();
        if (isOverThanMachineMoney(amount)) {
            int numberRange = machineMoney / amount;
            List<Integer> numbersInRange = getNumbersInRange(numberRange);
            return Randoms.pickNumberInList(numbersInRange);
        }
        return 0;
    }

    private boolean isOverThanMachineMoney(int amount) {
        return machineMoney >= amount;
    }

    private List<Integer> getNumbersInRange(int numberRange) {
        List<Integer> numbersInRange = new ArrayList<>();
        int count = 0;
        while (count <= numberRange) {
            numbersInRange.add(count);
            count++;
        }
        return numbersInRange;
    }

    private int computeAmount(Coin coin, int number) {
        int amount = coin.getAmount();
        return amount * number;
    }

    private void validateMatchWithMachineMoney() {
        if (machineMoney != 0) {
            generate();
        }
    }
}
