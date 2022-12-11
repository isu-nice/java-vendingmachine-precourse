package vendingmachine.controller;

import vendingmachine.domain.MachineCoins;
import vendingmachine.domain.MachineCoinsGenerator;
import vendingmachine.domain.MachineMoney;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.LinkedHashMap;
import java.util.Map;

public class VendingMachineController {

    public void run() {
        MachineMoney machineMoney = readVendingMachineMoney();
        MachineCoins coins = generateMachineCoins(machineMoney);
        printMachineCoins(coins);
    }


    private MachineMoney readVendingMachineMoney() {
        try {
            int vendingMachineMoney = InputView.inputVendingMachineMoney();
            return new MachineMoney(vendingMachineMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readVendingMachineMoney();
        }
    }

    private MachineCoins generateMachineCoins(MachineMoney machineMoney) {
        MachineCoinsGenerator machineCoinsGenerator = new MachineCoinsGenerator(machineMoney);
        return machineCoinsGenerator.generate();
    }

    private void printMachineCoins(MachineCoins coins) {
        Map<Integer, Integer> machineCoins = new LinkedHashMap<>();
        coins.getNumberOfCoins()
                .forEach(((coin, number) -> {
                    machineCoins.put(coin.getAmount(), number);
                }));
        OutputView.printMachineCoins(machineCoins);
    }
}
