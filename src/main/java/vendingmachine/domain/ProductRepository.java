package vendingmachine.domain;

import vendingmachine.constant.ErrorMessage;
import vendingmachine.constant.ProductsFormatConstant;

import java.util.*;

public class ProductRepository {
    private static final List<Product> products = new ArrayList<>();

    public static void addProducts(String inputProducts) {
        String[] eachProduct = inputProducts.split(ProductsFormatConstant.PRODUCT_SEPARATOR);
        Arrays.stream(eachProduct)
                .forEach(productInfo -> {
                    Product product = generateEachProduct(productInfo);
                    products.add(product);
                });
    }

    private static Product generateEachProduct(String product) {
        String[] productInfo = product.split(ProductsFormatConstant.PRODUCT_COMPONENT_SEPARATOR);
        String productName = productInfo[0];
        int productPrice = Integer.parseInt(productInfo[1]);
        int productQuantity = Integer.parseInt(productInfo[2]);
        return new Product(productName, productPrice, productQuantity);
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
