package Exceptions;

public class NotEnoughManaException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("Not enough Mana");
    }
}
