package Exceptions;

public class NotValidDeckException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("Please Enter a valid deckName");
    }
}
