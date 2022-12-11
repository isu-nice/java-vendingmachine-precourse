package vendingmachine.domain;

import vendingmachine.constant.ErrorMessage;
import vendingmachine.constant.ProductsFormatConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductRepository {
    private static final List<Product> products = new ArrayList<>();

    private static void addProducts(String inputProducts) {
        String[] eachProduct = inputProducts.split(ProductsFormatConstant.PRODUCT_SEPARATOR);

    }

    public Product findByName(String productName) {
        return products.stream()
                .filter(product -> product.isSameName(productName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_PRODUCT_NAME));
    }

    public static int findMinimumPrice() {
        return products.stream()
                .mapToInt(Product::getPrice)
                .min()
                .orElseThrow(NoSuchElementException::new);
    }

    public static List<Product> products() {
        return Collections.unmodifiableList(products);
    }
}
