package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int inputVendingMachineMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String vendingMachineMoney = Console.readLine();
        InputValidator.validateToInteger(vendingMachineMoney);
        System.out.println();
        return Integer.parseInt(vendingMachineMoney);
    }

    public static String inputProducts() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        String products = Console.readLine();
        InputValidator.validateProductsInput(products);
        System.out.println();
        return products;
    }

    public static int inputInsertMoney() {
        System.out.println("투입 금액을 입력해 주세요.");
        String insertMoney = Console.readLine();
        InputValidator.validateToInteger(insertMoney);
        return Integer.parseInt(insertMoney);
    }

    public static String inputProductName() {
        System.out.println("구매할 상품명을 입력해 주세요.");
        String productName = Console.readLine();
        System.out.println();
        return productName;
    }
}
