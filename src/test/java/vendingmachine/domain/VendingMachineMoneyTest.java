package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.constant.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class VendingMachineMoneyTest {
    @DisplayName("최소금액 테스트")
    @Test
    void validateMinimumAmount() {
        int inputMoney = 9;
        assertThatThrownBy(() -> {
            VendingMachineMoney money = new VendingMachineMoney(inputMoney);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LESS_THAN_MINIMUM_AMOUNT);
    }

    @DisplayName("최소금액 나누어 떨어지는지 확인")
    @Test
    void validateDivisibleByMinimum() {
        int inputMoney = 500001;
        assertThatThrownBy(() -> {
            VendingMachineMoney machineMoney = new VendingMachineMoney(inputMoney);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_DIVISIBLE_BY_MINIMUM);
    }
}
