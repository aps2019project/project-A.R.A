package Exceptions;

public class MainDeckNotValidNotValidException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("Your main deck is not complete");
    }
}
