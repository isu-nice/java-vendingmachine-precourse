package vendingmachine.view;

import vendingmachine.constant.ErrorMessage;
import vendingmachine.constant.ProductsFormatConstant;

import java.util.Arrays;

public class InputValidator {
    private static final String PRODUCT_BUNDLE_SYMBOL_REGEX = "[^[a-zA-Zㄱ-ㅎ가-힣0-9]*$]";

    public static void validateToInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC);
        }
    }

    public static void validateProductsInputFormat(String input) {
        String[] products = input.split(ProductsFormatConstant.PRODUCT_SEPARATOR);
        Arrays.stream(products)
                .filter(product -> product.matches(PRODUCT_BUNDLE_SYMBOL_REGEX))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_PRODUCT_FORMAT));
    }
}
