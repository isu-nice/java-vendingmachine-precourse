package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static org.assertj.core.api.Assertions.assertThat;

public class MachineCoinsGeneratorTest {
    private static final MachineMoney machineMoney = new MachineMoney(18000);
    private static final MachineCoinsGenerator generator = new MachineCoinsGenerator(machineMoney);
    private static final MachineCoins coins = generator.generate();

    @DisplayName("동전 생성 테스트")
    @Test
    void generateMachineCoinsTest() {
        EnumMap<Coin, Integer> numberOfCoins = coins.getNumberOfCoins();
        int resultMoney  = 0;
        for(Coin coin : numberOfCoins.keySet()){
            int coinMoney = coin.getAmount() * numberOfCoins.get(coin);
            resultMoney += coinMoney;
        }
        assertThat(resultMoney).isEqualTo(machineMoney.getMoney());
    }

}
