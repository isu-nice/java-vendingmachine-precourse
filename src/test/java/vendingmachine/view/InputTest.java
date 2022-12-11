package vendingmachine.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.constant.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {
    @DisplayName("상품 입력 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "[콜라,1500,20];[사이다,1000,10)",
            "[콜라,1500,20];[사이다,1000,10)]",
            "[콜라,1500,,20];[사이다,1000,10]",
            "[콜라,1500,20];[[사이다,1000,10]]",
            "[콜라,1500,20],;[사이다,1000,10]"
    })
    void validateProductInputTest(String input) {
        assertThatThrownBy(() -> {
            InputValidator.validateProductsInputFormat(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_PRODUCT_FORMAT);
    }
}
