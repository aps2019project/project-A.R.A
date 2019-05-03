package Exceptions;

public class DuplicateUnitException extends CustomException{
    @Override
    public void printStackTrace(){
        System.out.println("Deck already has this Unit");
    }
}
