package vendingmachine.controller;

import vendingmachine.view.InputView;

public class VendingMachineController {

    public void run(){
        System.out.println(readVendingMachineMoney());
    }

    private int readVendingMachineMoney(){
        try{
            int vendingMachineMoney = InputView.inputVendingMachineMoney();
            return vendingMachineMoney;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readVendingMachineMoney();
        }
    }
}
