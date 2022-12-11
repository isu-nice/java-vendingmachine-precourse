package vendingmachine.domain;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static int getMinimumAmount(){
        return Arrays.stream(Coin.values())
                .mapToInt(coin -> coin.amount)
                .min()
                .orElseThrow(NoSuchElementException::new);
    }

    // 추가 기능 구현
}
