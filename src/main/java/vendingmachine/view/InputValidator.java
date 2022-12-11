package vendingmachine.view;

import vendingmachine.constant.ErrorMessage;

public class InputValidator {

    public static void validateToInteger(String input){
        try{
            Integer.parseInt(input);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC);
        }
    }
}
