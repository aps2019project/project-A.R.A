package Exceptions;

public class DecckNotReadyException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("Selected Deck is not complete");
    }
}
