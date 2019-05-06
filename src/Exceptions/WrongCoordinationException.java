package Exceptions;

public class WrongCoordinationException extends CustomException {
    @Override
    public void printStackTrace(){
        System.out.println("Invalid target // wrong coordination");
    }
}
